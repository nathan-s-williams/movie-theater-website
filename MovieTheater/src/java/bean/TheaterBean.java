/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
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
@Named(value = "theaterBean")
@RequestScoped
public class TheaterBean {
    
    @EJB
    private TheaterEJB theaterEJB;
    private Theater theater = new Theater();

    public TheaterBean() { }
    
    public TheaterEJB getTheaterEJB() {
        return theaterEJB;
    }

    public void setTheaterEJB(TheaterEJB theaterEJB) {
        this.theaterEJB = theaterEJB;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
    
    public List<Theater> getAllTheaters() {
        return this.theaterEJB.findAllTheaters();
    }
    
    public List<Theater> getTheatersByMovie(String movieId) {
        return theaterEJB.findTheatersByMovie(movieId);
    }
    
    public String showTheatersMovies() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = 
                fc.getExternalContext().getRequestParameterMap();
        this.theater.setTheaterId(params.get("theaterId"));
        this.theater.setTheaterName(params.get("theaterName"));
        return "Movies.xhtml";
    }
    
    public List<Theater> showTheaterByZipcode(String zipcode) {
        return theaterEJB.findByTheaterZipcode(zipcode);
    }
    
}
