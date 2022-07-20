/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author nate
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Theater.findAllTheaters", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTheaterId", query = "Select t FROM Theater t WHERE t.theaterId = :theaterId"),
    @NamedQuery(name = "Theater.findByTheaterName", query = "Select t FROM Theater t WHERE t.theaterName = :theaterName"),
    @NamedQuery(name = "Theater.findByTheaterZipcode", query = "Select t FROM Theater t WHERE t.zipcode = :zipcode"),
    @NamedQuery(name = "Theater.findMoviesByTheater", query = "Select m FROM Movie m, Showtimes s WHERE m.movieId = s.showtimesPK.movieId AND s.showtimesPK.theaterId = :theaterId")
})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String theaterId;
    private String theaterName;
    private int zipcode;

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterId=" + theaterId + " ]";
    }
    
}
