/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import entity.Movie;
import entity.Theater;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author nate
 */
@Stateless
public class MovieEJB {
    
    //Injects a the persistence unit "MovieTheaterPU"
    @PersistenceContext(unitName = "MovieTheaterPU")
    private EntityManager em;
    
    /**
     * @return - The list of all movies using the named query in the movie entity
     */
    public List<Movie> findAllMovies() {
        return em.createNamedQuery("Movie.findAllMovies", Movie.class)
                .getResultList();
    }
    
    /**
     * @return - The movies using the named query in the movie entity using a MovieId
     */
    public Movie findByMovieId(String movieId) {
        return em.createNamedQuery("Movie.findByMovieId", Movie.class)
                .setParameter("movieId", movieId)
                .getSingleResult();
    }
    
    /**
     * @return - The list of movies in a theater using the theaterId
     */
    public List<Movie> findMoviesByTheater(String theaterId) {
        return em.createNamedQuery("Movie.findMoviesByTheater", Movie.class)
                .setParameter("theaterId", theaterId)
                .getResultList();
    }

    /**
     * This function persists the object parameter
     * @param object 
     */
    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
