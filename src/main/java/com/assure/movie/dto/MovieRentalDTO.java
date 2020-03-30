package com.assure.movie.dto;

import com.assure.movie.common.enums.StatusRental;
import org.springframework.lang.NonNull;

import java.util.Date;

/**
 * @author Israel Yasis
 */
public class MovieRentalDTO implements DTO {
    @NonNull
    private Long movieId;
    @NonNull
    private Long memberId;
    private Date date;
    private Date returnDate;
    private Date returnedDate;
    private StatusRental statusRental;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public StatusRental getStatusRental() {
        return statusRental;
    }

    public void setStatusRental(StatusRental statusRental) {
        this.statusRental = statusRental;
    }
}
