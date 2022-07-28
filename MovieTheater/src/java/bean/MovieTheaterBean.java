/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ClientValidatorEJB;
import ejb.MovieEJB;
import ejb.PaymentEJB;
import ejb.ShowtimesEJB;
import ejb.TheaterEJB;
import entity.Movie;
import entity.Showtimes;
import entity.Theater;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@Named(value = "movieTheaterBean")
@SessionScoped
public class MovieTheaterBean implements Serializable {

    @EJB
    private TheaterEJB theaterEJB;
    @EJB
    private ShowtimesEJB showtimesEJB;
    @EJB
    private PaymentEJB paymentEJB;
    @EJB
    private MovieEJB movieEJB;
    @EJB
    private ClientValidatorEJB clientValidatorEJB;
    private Theater theater = new Theater();
    private Movie movie = new Movie();
    
    public MovieTheaterBean() { }

    public TheaterEJB getTheaterEJB() {
        return theaterEJB;
    }

    public void setTheaterEJB(TheaterEJB theaterEJB) {
        this.theaterEJB = theaterEJB;
    }

    public ShowtimesEJB getShowtimesEJB() {
        return showtimesEJB;
    }

    public void setShowtimesEJB(ShowtimesEJB showtimesEJB) {
        this.showtimesEJB = showtimesEJB;
    }

    public PaymentEJB getPaymentEJB() {
        return paymentEJB;
    }

    public void setPaymentEJB(PaymentEJB paymentEJB) {
        this.paymentEJB = paymentEJB;
    }

    public MovieEJB getMovieEJB() {
        return movieEJB;
    }

    public void setMovieEJB(MovieEJB movieEJB) {
        this.movieEJB = movieEJB;
    }

    public ClientValidatorEJB getClientValidatorEJB() {
        return clientValidatorEJB;
    }

    public void setClientValidatorEJB(ClientValidatorEJB clientValidatorEJB) {
        this.clientValidatorEJB = clientValidatorEJB;
    }

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
    
    public void validateZipcode(FacesContext fc, UIComponent uic, Object o) {
        String zipcode = (String)o;
        if(!ClientValidatorEJB.validateZipcode(zipcode))
            ((UIInput) uic).setValid(false);
            FacesMessage message = new FacesMessage
                ("Zipcode must be exactly 5 digits.");
            fc.addMessage(uic.getClientId(fc), message);
    }
    
    /**************
    Theaters.xhtml
    **************/
    //Get Data table list
    
    public List<Theater> showTheatersByZipcode(String zipcode) {
        return theaterEJB.findByTheaterZipcode(zipcode);
    }
    
    //Store chosen theater in class theater object
    //Move to Movies.xhtml
    public String getMoviesByTheater(String theaterId) {
        this.theater = theaterEJB.findByTheaterId(theaterId);
        return "Movies.xhtml";
    } 
    
    /**************
    Movies.xhtml
    **************/
    
    
    public List<Movie> showMoviesByTheater() {
        return movieEJB.findMoviesByTheater(this.theater.getTheaterId());
    }
    
    public String getShowtimesByMovie(String movieId) {
        this.movie = movieEJB.findByMovieId(movieId);
        return "Showtimes.xhtml";
    }
    
    /**************
    Showtimes.xhtml
    **************/
    
    public List<Showtimes> showShowtimesByMovie() {
        return showtimesEJB.findShowtimes(theater.getTheaterId(), movie.getMovieId());
    }
    
    
    
}
