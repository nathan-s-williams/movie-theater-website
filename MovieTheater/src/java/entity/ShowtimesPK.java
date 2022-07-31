/*
Primary key for Showtimes entity
 */
package entity;

//imports
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//Composite key with keys defined
@Embeddable
public class ShowtimesPK implements Serializable {

    //Composite keys
    private static final long serialVersionUID = 1L;
    @NotNull
    private String theaterId;
    @NotNull
    private String movieId;
    @NotNull
    private java.util.Date showtime;

    //Constructor
    public ShowtimesPK() { }

    //Get theaterid
    public String getTheaterId() {
        return theaterId;
    }

    //Set theaterid
    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    //Get movieid
    public String getMovieId() {
        return movieId;
    }

    //Set movieid
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    //Get showtime
    public Date getShowtime() {
        return showtime;
    }

    //Set showtime
    public void setShowtime(Date showtime) {
        this.showtime = showtime;
    }
    
    //Constructor
    public ShowtimesPK(String theaterId, String movieId, Date showtime) {
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.showtime = showtime;
    }

    //Generate hashcode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        hash += (movieId != null ? movieId.hashCode() : 0);
        hash += (showtime != null ? showtime.hashCode() : 0);
        return hash;
    }

    //Test equality of other object
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

    //Print toString string
    @Override
    public String toString() {
        return "entity.ShowtimesPK[ theaterId=" + theaterId + " and movieId=" + movieId + " and showtime=" + showtime + " ]";
    }
    
}
