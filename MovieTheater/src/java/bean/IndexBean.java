/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ClientValidatorEJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author nate
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean {
    
    public IndexBean() { }
    
    public void validateZipcode(FacesContext fc, UIComponent uic, Object o) {
        int zipcode = (int)o;
        if(!ClientValidatorEJB.validateZipcode(zipcode))
            ((UIInput) uic).setValid(false);
            FacesMessage message = new FacesMessage
                ("Zipcode must be exactly 5 digits.");
            fc.addMessage(uic.getClientId(fc), message);
    }
    
}
