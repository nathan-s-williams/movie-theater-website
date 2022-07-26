/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MovieEJB;
import entity.Movie;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author nate
 */
@Named(value = "movieBean")
@RequestScoped
public class MovieBean {

    @EJB
    private MovieEJB movieEJB;
    private Movie movie = new Movie();
    
    public MovieBean() { }

    public MovieEJB getMovieEJB() {
        return movieEJB;
    }

    public void setMovieEJB(MovieEJB movieEJB) {
        this.movieEJB = movieEJB;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public List<Movie> getAllMovies() {
        return movieEJB.findAllMovies();
    }
    
    public List<Movie> getMoviesByTheater(String theaterId) {
        return movieEJB.findMoviesByTheater(theaterId);
    }
    
    public String showMoviesTheaters() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = 
                fc.getExternalContext().getRequestParameterMap();
        this.movie.setMovieId(params.get("movieId"));
        this.movie.setTitle(params.get("title"));
        return "Theaters.xhtml";
    }
    
}
