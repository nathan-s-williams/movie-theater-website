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
    EntityManager em;
    
    public Theater findByTheaterId(String theaterId) {
        return em.createNamedQuery("Theater.findByTheaterId", Theater.class)
                .setParameter("theaterId", theaterId)
                .getSingleResult();
    }
    
    public List<Theater> findByTheaterZipcode(String zipcode) {
        if(!ClientValidatorEJB.validateZipcode(zipcode))
            return null;
        return em.createNamedQuery("Theater.findByTheaterZipcode", Theater.class)
                .setParameter("zipcode", zipcode)
                .getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
}
