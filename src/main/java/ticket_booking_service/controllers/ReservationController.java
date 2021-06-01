package ticket_booking_service.controllers;

import org.springframework.web.bind.annotation.*;
import ticket_booking_service.dtos.ReservationRequestDto;
import ticket_booking_service.dtos.ReservationResponseDto;
import ticket_booking_service.exceptions.ReservationNotFoundException;
import ticket_booking_service.models.Reservation;
import ticket_booking_service.models.Screening;
import ticket_booking_service.models.Seat;
import ticket_booking_service.models.Ticket;
import ticket_booking_service.repositories.ReservationRepository;
import ticket_booking_service.repositories.ScreeningRepository;
import ticket_booking_service.repositories.SeatRepository;
import ticket_booking_service.repositories.TicketRepository;
import ticket_booking_service.tools.HelperService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class ReservationController {


    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final ScreeningRepository screeningRepository;

    public ReservationController(ReservationRepository reservationRepository, TicketRepository ticketRepository, SeatRepository seatRepository, ScreeningRepository screeningRepository) {
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/reservations")
    public List<Reservation> all() {

        return reservationRepository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public ReservationResponseDto one(@PathVariable Long id) {

        Reservation reservation = reservationRepository.findById(id) //
                .orElseThrow(() -> new ReservationNotFoundException(id));

        return new ReservationResponseDto(
                reservation.getTicket(),
                reservation.getFirstName(),
                reservation.getLastName(),
                reservation.getExpirationDate()
        );
    }

    @PostMapping("/reservations")
    public Reservation createReservation(@RequestBody ReservationRequestDto reservationRequest) {

        Screening screening = screeningRepository.getById(reservationRequest.getScreeningId());

        List<Seat> seats = seatRepository.findAllById(reservationRequest.getSeatIds());
        Ticket ticket = ticketRepository.findById(reservationRequest.getTicketId()).get();

        Reservation newReservation = reservationRepository.save(new Reservation(
                screening,
                ticket,
                reservationRequest.getFirstName(),
                reservationRequest.getLastName(),
                seats,
                HelperService.getReservationRetrievalDeadlineFromScreeningTime(screening.getStartTime())
        ));

        List<Seat> seatsReserved = seats.stream().map(seat -> {
            seat.setReservation(reservationRepository.findById(newReservation.getId()).get());
            return seatRepository.save(seat);
        }).collect(Collectors.toList());

        return newReservation;
    }



}

