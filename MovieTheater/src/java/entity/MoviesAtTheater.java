/*
MoviesAtTheater entity which handles the many-to-many relationship between
the Theaters and Movies.

By Nathan Williams and Akito Minosoko
 */
package entity;

//Import
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class MoviesAtTheater implements Serializable {

    private static final long serialVersionUID = 1L;

    //Primary key
    @EmbeddedId
    protected MoviesAtTheaterPK moviesAtTheaterPK;
    
    //Many to one relationship with theater entity using the theaterId.
    @ManyToOne
    @MapsId("theaterId")
    @JoinColumn(name="theaterId")
    private Theater theater;
    
    //Many to one relationship movie entity using the movieId
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name="movieId")
    private Movie movie;
    
    //Get theater
    public Theater getTheater() {
        return theater;
    }

    //Set theater
    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    //Get movie
    public Movie getMovie() {
        return movie;
    }

    //Set movie
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    //Generate hashcode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviesAtTheaterPK != null ? moviesAtTheaterPK.hashCode() : 0);
        return hash;
    }

    //Test equality of other object
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

    //Print toString string
    @Override
    public String toString() {
        return "entity.Showtimes[ moviesAtTheaterPK=" + moviesAtTheaterPK + " ]";
    }
    
}
