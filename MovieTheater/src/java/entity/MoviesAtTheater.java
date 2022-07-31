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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author nate
 */
@Entity
public class MoviesAtTheater implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoviesAtTheaterPK moviesAtTheaterPK;
    
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviesAtTheaterPK != null ? moviesAtTheaterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoviesAtTheater)) {
            return false;
        }
        MoviesAtTheater other = (MoviesAtTheater) object;
        if ((this.moviesAtTheaterPK == null && other.moviesAtTheaterPK != null) || (this.moviesAtTheaterPK != null && !this.moviesAtTheaterPK.equals(other.moviesAtTheaterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showtimes[ moviesAtTheaterPK=" + moviesAtTheaterPK + " ]";
    }
    
}
