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
 * PaymentBean is request scoped and will handle most of the payment
 * methods and hold the variables related to the customer
 * payment
 * @author minosokoa
 */
@Named(value = "paymentBean")
@RequestScoped
public class PaymentBean {
    
    //Calls the ClientValidatorEJB
    @EJB
    private ClientValidatorEJB clientValidatorEJB;
    
    //All variables related to payment
    private String cardNumber;
    private String firstName;
    private String lastName;
    private String expDate;
    private String cvv;
    
    //Constructor
    public PaymentBean() { }

    
    //Getters and Setters for each of the variables
    public ClientValidatorEJB getClientValidatorEJB() {
        return clientValidatorEJB;
    }

    public void setClientValidatorEJB(ClientValidatorEJB clientValidatorEJB) {
        this.clientValidatorEJB = clientValidatorEJB;
    }

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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    
    
    /**
     * The validation method used to validate that the card must be 16 digits exactly
     * This validation method is used in Payment.xhtml
     * @param context
     * @param comp
     * @param value 
     */
    public void validateCardNumber(FacesContext context, UIComponent comp, Object value) {
        String cc = (String) value;
        
        if(!ClientValidatorEJB.validateCreditcard(cc)) {
            ((UIInput) comp).setValid(false);
                FacesMessage errorMessage = new FacesMessage("Creditcard must be 16 digits.");
                context.addMessage(comp.getClientId(context), errorMessage);
        }
        
    }

    public String gotoNextPage() {
        return "index.xhtml";
    }
    
}
