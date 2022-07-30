/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nate
 */
@Embeddable
public class MoviesAtTheaterPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private String theaterId;
    @NotNull
    private String movieId;

    public MoviesAtTheaterPK() { }

    public MoviesAtTheaterPK(String theaterId, String movieId) {
        this.theaterId = theaterId;
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoviesAtTheaterPK)) {
            return false;
        }
        MoviesAtTheaterPK other = (MoviesAtTheaterPK) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShowtimesPK[ theaterId=" + theaterId + " and movieId=" + movieId + " ]";
    }
    
}
