/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Payment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nate
 */
@Stateless
public class PaymentEJB {

    @PersistenceContext(unitName = "PaymentPU")
    private EntityManager em;
    
    public List<Payment> findAllPaymentsByTheaterIdAndMovieId(String theaterId, String movieId) {
        return em.createNamedQuery("Payment.findAllPaymentsByTheaterIdAndMovieId", Payment.class)
                .setParameter("theaterId", theaterId)
                .setParameter("movieId", movieId)
                .getResultList();
    }
    
    //Method used to persist an object.
    public void persist(Object object) {
        em.persist(object);
    }
}
