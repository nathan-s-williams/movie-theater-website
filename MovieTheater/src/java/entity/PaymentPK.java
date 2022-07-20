/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nate
 */
@Embeddable
public class PaymentPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    private String theaterId;
    @NotNull
    private String movieId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int creditcard;
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        hash += (movieId != null ? movieId.hashCode() : 0);
        hash += (firstName != null ? firstName.hashCode() : 0);
        hash += (lastName != null ? lastName.hashCode() : 0);
        hash += (creditcard != 0 ? creditcard : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentPK)) {
            return false;
        }
        PaymentPK other = (PaymentPK) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        if ((this.firstName == null && other.firstName != null) || (this.firstName != null && !this.firstName.equals(other.firstName))) {
            return false;
        }
        if ((this.lastName == null && other.lastName != null) || (this.lastName != null && !this.lastName.equals(other.lastName))) {
            return false;
        }
        if ((this.creditcard == 0 && other.creditcard != 0) || (this.creditcard != 0 && this.creditcard != other.creditcard)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaymentPK[ theaterId=" + theaterId + 
                " movieId=" + movieId + 
                " firstName=" + firstName +
                " lastName=" + lastName +
                " creditcard=" + creditcard + " ]";
    }
    
}
