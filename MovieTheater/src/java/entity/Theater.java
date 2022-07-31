/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

//Imports
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//Named queries for find by theater id and find by theater zip
@Entity
@NamedQueries({
    @NamedQuery(name = "Theater.findByTheaterId", query = "SELECT t FROM Theater t WHERE t.theaterId = :theaterId"),
    @NamedQuery(name = "Theater.findByTheaterZipcode", query = "SELECT t FROM Theater t WHERE t.zipcode = :zipcode")
})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    //Primary key
    @Id
    private String theaterId;
    //Other attributes
    private String theaterName;
    private String zipcode;

    //Get theaterid
    public String getTheaterId() {
        return theaterId;
    }

    //Set theaterid
    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }
    
    //Get theatername
    public String getTheaterName() {
        return theaterName;
    }

    //Set theater name
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    //Get zip
    public String getZipcode() {
        return zipcode;
    }

    //Set zip
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    //Get hash
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        return hash;
    }

    //Test equality of other object
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        return true;
    }

    //Print toString string
    @Override
    public String toString() {
        return "entity.Theater[ theaterId=" + theaterId + " ]";
    }
    
}
