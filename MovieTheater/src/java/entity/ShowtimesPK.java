/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nate
 */
@Embeddable
public class ShowtimesPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private String theaterId;
    @NotNull
    private String movieId;
    @NotNull
    private java.util.Date showtime;

    public ShowtimesPK() { }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Date getShowtime() {
        return showtime;
    }

    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }
    
    public ShowtimesPK(String theaterId, String movieId, Date showtime) {
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.showtime = showtime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        hash += (movieId != null ? movieId.hashCode() : 0);
        hash += (showtime != null ? showtime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShowtimesPK)) {
            return false;
        }
        ShowtimesPK other = (ShowtimesPK) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        if ((this.showtime == null && other.showtime != null) || (this.showtime != null && !this.showtime.equals(other.showtime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShowtimesPK[ theaterId=" + theaterId + " and movieId=" + movieId + " and showtime=" + showtime + " ]";
    }
    
}
