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

    @PersistenceContext(unitName = "MovieTheaterPU")
    private EntityManager em;
    
    public List<Showtimes> findShowtimes(String theaterId, String movieId) {
        return em.createNamedQuery("Showtimes.findShowtimes", Showtimes.class)
                .setParameter("theaterId", theaterId)
                .setParameter("movieId", movieId)
                .getResultList();
    }
    
    public Showtimes findShowtimesWithDate(String theaterId, String movieId, java.util.Date showtime) {
        return em.createNamedQuery("Showtimes.findShowtimesWithDate", Showtimes.class)
                .setParameter("theaterId", theaterId)
                .setParameter("movieId", movieId)
                .setParameter("showtime", showtime)
                .getSingleResult();
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
