/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MovieEJB;
import ejb.ShowtimesEJB;
import ejb.TheaterEJB;
import entity.Movie;
import entity.Showtimes;
import entity.Theater;
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
@Named(value = "showtimeBean")
@RequestScoped
public class ShowtimeBean {

    @EJB
    private ShowtimesEJB showtimesEJB;
    private Theater theater = new Theater();
    private Movie movie = new Movie();

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

    public String showShowtimes() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = 
                fc.getExternalContext().getRequestParameterMap();
        this.theater.setTheaterId(params.get("theaterId"));
        this.movie.setMovieId(params.get("movieId"));
        return "Showtimes.xhtml";
    }
    
    public List<Showtimes> getShowtimes(String theaterId, String movieId) {
        return showtimesEJB.findShowtimes(theaterId, movieId);
    }
    
    
    public ShowtimeBean() { }
    
}
