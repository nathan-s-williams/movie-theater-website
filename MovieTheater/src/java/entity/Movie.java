/*
Movie Entity with database attributes.

By Nathan Williams and Akito Minosoko.
 */
package entity;

//imports
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//Named Queries for find all movies, find by the movie id and find by the theater.
@Entity
@NamedQueries({
    @NamedQuery(name = "Movie.findAllMovies", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Movie.findMoviesByTheater", query = "SELECT m FROM Movie m, MoviesAtTheater mt WHERE m.movieId = mt.moviesAtTheaterPK.movieId AND mt.moviesAtTheaterPK.theaterId = :theaterId")
})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    //Primary key
    @Id
    private String movieId;
    //Object attributes
    private String title;
    private String description;
    private String image;

    //Get movie id
    public String getMovieId() {
        return movieId;
    }

    //Set movie id
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    //Get title
    public String getTitle() {
        return title;
    }

    //Set title
    public void setTitle(String title) {
        this.title = title;
    }

    //Get description
    public String getDescription() {
        return description;
    }

    //Set description
    public void setDescription(String description) {
        this.description = description;
    }

    //Get image
    public String getImage() {
        return image;
    }

    //Set image
    public void setImage(String image) {
        this.image = image;
    }
    
    //Generate hash
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    //Test equality of other object
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    //Print toString string
    @Override
    public String toString() {
        return "entity.Movie[ movieId=" + movieId + " ]";
    }
    
}
