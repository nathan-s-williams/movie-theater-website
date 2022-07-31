/*
Composite key object for the MoviesAtTheaterPK

By Nathan Williams and Akito Minosoko
 */
package entity;

//import
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

//Composite class for the MoviesAtTheater composite key
@Embeddable
public class MoviesAtTheaterPK implements Serializable {

    private static final long serialVersionUID = 1L;
    //Keys for the composite key
    @NotNull
    private String theaterId;
    @NotNull
    private String movieId;

    //Constructors
    public MoviesAtTheaterPK() { }

    public MoviesAtTheaterPK(String theaterId, String movieId) {
        this.theaterId = theaterId;
        this.movieId = movieId;
    }

    //Generate hashcode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    //Test equality of other object
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

    //Print toString string
    @Override
    public String toString() {
        return "entity.ShowtimesPK[ theaterId=" + theaterId + " and movieId=" + movieId + " ]";
    }
    
}
