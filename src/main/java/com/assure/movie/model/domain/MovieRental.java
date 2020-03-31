package com.assure.movie.model.domain;

import com.assure.movie.common.enums.StatusRental;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie_rental")
public class MovieRental implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="movie_rental_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    private MovieCatalog movieCatalog;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "returned_date")
    private Date returnedDate;

    @Column(name = "status_rental", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusRental statusRental;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public MovieCatalog getMovieCatalog() {
        return this.movieCatalog;
    }

    public void setMovieCatalog(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public StatusRental getStatusRental() {
        return statusRental;
    }

    public void setStatusRental(StatusRental statusRental) {
        this.statusRental = statusRental;
    }
}
