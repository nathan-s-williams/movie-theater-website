/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author nate
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Showtimes.findShowtimes", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.theaterId = :theaterId AND s.showtimesPK.movieId = :movieId"),
    @NamedQuery(name = "Showtimes.findShowtimesWithDate", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.theaterId = :theaterId AND s.showtimesPK.movieId = :movieId AND s.showtimesPK.showtime = :showtime")
})
public class Showtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShowtimesPK showtimesPK;
    private int price;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="theaterId", referencedColumnName="theaterId", insertable=false, updatable=false),
        @JoinColumn(name="movieId", referencedColumnName="movieId", insertable=false, updatable=false)
    })
    private MoviesAtTheater moviesAtTheater;

    public MoviesAtTheater getMoviesAtTheater() {
        return moviesAtTheater;
    }

    public void setMoviesAtTheater(MoviesAtTheater moviesAtTheater) {
        this.moviesAtTheater = moviesAtTheater;
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
