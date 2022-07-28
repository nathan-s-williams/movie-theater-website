/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MovieEJB;
import entity.Movie;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author minosokoa
 */
@Named(value = "carouselBean")
@RequestScoped
public class CarouselBean {

    @EJB
    private MovieEJB movieEJB;
    
    Movie movie = new Movie();
    
    
    

    /**
     * Creates a new instance of CarouselBean
     */
    
    public List<Movie> getMovieList() {
        return movieEJB.findAllMovies();
    }
    
    
    public CarouselBean() {
    }
    
}
