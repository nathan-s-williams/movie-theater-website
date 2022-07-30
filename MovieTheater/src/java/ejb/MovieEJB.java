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

    @PersistenceContext(unitName = "MovieTheaterPU")
    private EntityManager em;
    
    public List<Movie> findAllMovies() {
        return em.createNamedQuery("Movie.findAllMovies", Movie.class)
                .getResultList();
    }
    
    public Movie findByMovieId(String movieId) {
        return em.createNamedQuery("Movie.findByMovieId", Movie.class)
                .setParameter("movieId", movieId)
                .getSingleResult();
    }
    
    public List<Movie> findMoviesByTheater(String theaterId) {
        return em.createNamedQuery("Movie.findMoviesByTheater", Movie.class)
                .setParameter("theaterId", theaterId)
                .getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
