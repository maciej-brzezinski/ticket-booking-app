package ticket_booking_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ticket_booking_service.dtos.ScreeningDetailsDto;
import ticket_booking_service.dtos.ScreeningDto;
import ticket_booking_service.exceptions.ScreeningNotFoundException;
import ticket_booking_service.models.Screening;
import ticket_booking_service.repositories.ScreeningRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ScreeningController {


    private final ScreeningRepository screeningRepository;

    public ScreeningController(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/screenings")
    public List<Screening> all() {

        List<Screening> screenings = screeningRepository.findAll();

        return screenings;
    }

    @GetMapping("/screenings/find-by-start-time-between")
    List<Object> findByStartTimeBetween(
            @RequestParam("dateTimeFrom") String dateTimeFromString,
            @RequestParam("dateTimeTo") String dateTimeToString
    ) {
        LocalDateTime dateTimeFrom = LocalDateTime.parse(dateTimeFromString);
        LocalDateTime dateTimeTo = LocalDateTime.parse(dateTimeToString);

        List<Screening> screenings = screeningRepository.findByStartTimeBetween(dateTimeFrom, dateTimeTo);

        return screenings.stream()
                .map(screening -> new ScreeningDto(
                                screening.getId(),
                                screening.getStartTime(),
                                screening.getMovie().getTitle(),
                                screening.getMovie().getDurationInMinutes()
                        ))
                .sorted(Comparator.comparing(ScreeningDto::getMovieTitle))
                .sorted(Comparator.comparing(ScreeningDto::getStartTime))
                .collect(Collectors.toList());
    }

    @GetMapping("/screenings/{id}")
    public ScreeningDetailsDto oneDetail(@PathVariable Long id) {

        Screening screening = screeningRepository.findById(id).get();
        ScreeningDetailsDto screeningDetails = new ScreeningDetailsDto(
                screening.getId(),
                screening.getRoom().getId(),
                screening.getRoom().getSeats().stream().filter(seat -> seat.getReservation() == null).collect(Collectors.toList())
        );

        return screeningDetails;
    }

}
