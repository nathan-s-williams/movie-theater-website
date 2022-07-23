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
public class TheaterEJB {

    @PersistenceContext(unitName = "MovieTheaterPU")
    private EntityManager em;

    
    
    public List<Theater> findAllTheaters(String movieId) {
        return em.createNamedQuery("Theater.findAllTheaters", Theater.class)
                .getResultList();
    }
    
    public Theater findByTheaterId(String theaterId) {
        return em.createNamedQuery("Theater.findByTheaterId", Theater.class)
                .setParameter("theaterId", theaterId)
                .getSingleResult();
    }
    
    public Theater findByTheaterName(String name) {
        return em.createNamedQuery("Theater.findByTheaterName", Theater.class)
                .setParameter("theaterName", name)
                .getSingleResult();
    }
    
    public List<Theater> findByTheaterZipcode(int zipcode) {
        if(!ClientValidatorEJB.validateZipcode(zipcode))
            return null;
        return em.createNamedQuery("Theater.findByTheaterZipcode", Theater.class)
                .setParameter("zipcode", zipcode)
                .getResultList();
    }
    
    public List<Movie> findMoviesByTheater(String theaterId) {
        return em.createNamedQuery("Theater.findMoviesByTheater", Movie.class)
                .setParameter("theaterId", theaterId)
                .getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
