/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author nate
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Showtimes.findAllShowtimesAndTheatersByMovie", query = "SELECT s FROM Showtimes s, Theater t WHERE s.showtimesPK.theaterId = t.theaterId AND s.showtimesPK.movieId = :movieId"),
    @NamedQuery(name = "Showtimes.findAllShowtimesAndMoviesByTheater", query = "SELECT s FROM Showtimes s, Movie m WHERE s.showtimesPK.movieId = m.movieId AND s.showtimesPK.theaterId = :theaterId")
})
public class Showtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShowtimesPK showtimesPK;
    private int price;
    private Date showtime;
    
    @ManyToOne
    @MapsId("theaterId")
    @JoinColumn(name="theaterId")
    private Theater theater;
    
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name="movieId")
    private Movie movie;

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ShowtimesPK getShowtimesPK() {
        return showtimesPK;
    }

    public void setShowtimesPK(ShowtimesPK showtimesPK) {
        this.showtimesPK = showtimesPK;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getShowtime() {
        return showtime;
    }

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showtimesPK != null ? showtimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showtimes)) {
            return false;
        }
        Showtimes other = (Showtimes) object;
        if ((this.showtimesPK == null && other.showtimesPK != null) || (this.showtimesPK != null && !this.showtimesPK.equals(other.showtimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showtimes[ showtimesPK=" + showtimesPK + " ]";
    }
    
}
