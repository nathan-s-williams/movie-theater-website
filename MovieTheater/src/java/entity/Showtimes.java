/*
Showtimes entity

By Nathan Williams and Akito Minosoko
 */
package entity;

//Imports
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//Named queries for finding showtimes and finding showtimes using the showtime date.
@Entity
@NamedQueries({
    @NamedQuery(name = "Showtimes.findShowtimes", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.theaterId = :theaterId AND s.showtimesPK.movieId = :movieId"),
    @NamedQuery(name = "Showtimes.findShowtimesWithDate", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.theaterId = :theaterId AND s.showtimesPK.movieId = :movieId AND s.showtimesPK.showtime = :showtime")
})
public class Showtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //Composite key
    @EmbeddedId
    protected ShowtimesPK showtimesPK;
    //Other attribute
    private int price;

    //Many to one relationship to MoviesAtTheater entity.
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="theaterId", referencedColumnName="theaterId", insertable=false, updatable=false),
        @JoinColumn(name="movieId", referencedColumnName="movieId", insertable=false, updatable=false)
    })
    private MoviesAtTheater moviesAtTheater;

    //Get MoviesAtTheater
    public MoviesAtTheater getMoviesAtTheater() {
        return moviesAtTheater;
    }

    //Set MoviesAtTheater
    public void setMoviesAtTheater(MoviesAtTheater moviesAtTheater) {
        this.moviesAtTheater = moviesAtTheater;
    }
    
    //Get ShowtimesPK
    public ShowtimesPK getShowtimesPK() {
        return showtimesPK;
    }

    //Set ShowtimesPK
    public void setShowtimesPK(ShowtimesPK showtimesPK) {
        this.showtimesPK = showtimesPK;
    }

    //Get price
    public int getPrice() {
        return price;
    }

    //Set price
    public void setPrice(int price) {
        this.price = price;
    }
    
    //Generate hashcode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showtimesPK != null ? showtimesPK.hashCode() : 0);
        return hash;
    }

    //Test equality of other object
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

    //Print toString string
    @Override
    public String toString() {
        return "entity.Showtimes[ showtimesPK=" + showtimesPK + " ]";
    }
    
}
