/*
Showtimes EJB which handles the data retrieval of entity objects.
 */
package ejb;

//Imports
import javax.ejb.Stateless;
import entity.Showtimes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ShowtimesEJB {

    //Persistence injection
    @PersistenceContext(unitName = "MovieTheaterPU")
    private EntityManager em;
    
    //Find showtimes using the theaterId and movieId.
    //Returns a list of showtime objects.
    public List<Showtimes> findShowtimes(String theaterId, String movieId) {
        return em.createNamedQuery("Showtimes.findShowtimes", Showtimes.class)
                .setParameter("theaterId", theaterId)
                .setParameter("movieId", movieId)
                .getResultList();
    }
    
    //Find Showtimes using the showtime date.
    //Returns a single showtime.
    public Showtimes findShowtimesWithDate(String theaterId, String movieId, java.util.Date showtime) {
        return em.createNamedQuery("Showtimes.findShowtimesWithDate", Showtimes.class)
                .setParameter("theaterId", theaterId)
                .setParameter("movieId", movieId)
                .setParameter("showtime", showtime)
                .getSingleResult();
    }
    
    //Persistence method.
    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
