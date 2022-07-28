/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ClientValidatorEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author minosokoa
 */
@Named(value = "paymentBean")
@RequestScoped
public class PaymentBean {

    @EJB
    private ClientValidatorEJB clientValidatorEJB;
    
    private String cardNumber;
    private String firstName;
    private String lastName;
    private String expDate;
    private int cvv;
    
    public PaymentBean() { }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    
    public void validateCardNumber(FacesContext context, UIComponent comp, Object value) {
        String cc = (String) value;
        
        if(!ClientValidatorEJB.validateCreditcard(cc)) {
            ((UIInput) comp).setValid(false);
                FacesMessage errorMessage = new FacesMessage("Your credit card number must be 16 digits");
                context.addMessage(comp.getClientId(context), errorMessage);
        }
        
    }
    
    public String gotoNextPage() {
        return "index.xhtml";
    }
    
}
