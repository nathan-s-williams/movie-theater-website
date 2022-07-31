/*

 */
package ejb;

import javax.ejb.Stateless;
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

    //Persistence injection
    @PersistenceContext(unitName = "MovieTheaterPU")
    EntityManager em;
    
    //Find theater by id
    //Return a single theater object
    public Theater findByTheaterId(String theaterId) {
        return em.createNamedQuery("Theater.findByTheaterId", Theater.class)
                .setParameter("theaterId", theaterId)
                .getSingleResult();
    }
    
    //Find theaters by zipcode
    //Return list of theaters
    public List<Theater> findByTheaterZipcode(String zipcode) {
        if(!ClientValidatorEJB.validateZipcode(zipcode))
            return null;
        return em.createNamedQuery("Theater.findByTheaterZipcode", Theater.class)
                .setParameter("zipcode", zipcode)
                .getResultList();
    }

    //Persistence method
    public void persist(Object object) {
        em.persist(object);
    }
    
}
