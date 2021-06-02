package ticket_booking_service.dtos;

import java.time.LocalDateTime;

public class ScreeningDto {

    private Long screeningId;
    private LocalDateTime startTime;
    private String movieTitle;
    private int duration;

    public ScreeningDto(Long screeningId, LocalDateTime startTime, String movieTitle, int duration) {
        this.screeningId = screeningId;
        this.startTime = startTime;
        this.movieTitle = movieTitle;
        this.duration = duration;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
