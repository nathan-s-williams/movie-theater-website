/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import entity.Showtimes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author nate
 */
@Stateless
public class ShowtimesEJB {

    @PersistenceContext(unitName = "ShowtimesPU")
    private EntityManager em;
    
    public List<Showtimes> findAllShowtimesAndTheatersByMovie(String movieId) {
        return em.createNamedQuery("Showtimes.findAllShowtimesAndTheatersByMovie", Showtimes.class)
                .setParameter("movieId", movieId)
                .getResultList();
    }
    
    public List<Showtimes> findAllShowtimesAndMoviesByTheater(String theaterId) {
        return em.createNamedQuery("Showtimes.findAllShowtimesAndMoviesByTheater", Showtimes.class)
                .setParameter("theaterId", theaterId)
                .getResultList();
    }
    
    //Method used to persist an object.
    public void persist(Object object) {
        em.persist(object);
    }
}
