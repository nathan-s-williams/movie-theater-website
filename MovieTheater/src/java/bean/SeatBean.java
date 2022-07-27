/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Movie;
import entity.Payment;
import entity.Showtimes;
import entity.Theater;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author minosokoa
 */
@Named(value = "seatBean")
@RequestScoped
public class SeatBean {

    /**
     * Creates a new instance of SeatBean
     */
    public SeatBean() {
    }
    
    Movie movie = new Movie();
    Theater theater = new Theater();
    Showtimes showtimes = new Showtimes();
    Payment payment = new Payment();
    
    
    List<String> Listseatings;
    String[] seatings = new String[8];
    String stringSeatings;
    String tempString = "";
    int numOfChosenSeats;
    
    
    public String[] getSeatings () {
        return seatings;
    }
    
    public void setSeatings(String[] seatings) {
        for(int i = 0; i < seatings.length; i++) {
            tempString = tempString + seatings[i] + " ";
        }
        this.seatings = seatings;
        stringSeatings = tempString;
    }
    
    
    public String getStringSeatings() {
        return stringSeatings; 
    }
    
    public void setStringSeatings(String stringSeatings) {
        this.stringSeatings = stringSeatings;
    }

    public int getNumOfChosenSeats() {
        return numOfChosenSeats;
    }

    public void setNumOfChosenSeats(int numOfChosenSeats) {
        this.numOfChosenSeats = numOfChosenSeats;
    }
    
    public String calcNumOfSeats() {
        int num = this.stringSeatings.length() - this.stringSeatings.replaceAll(" ", "").length();
        setNumOfChosenSeats(num);
       
        return "Payment.xhtml";
    }
    
    public int calcTotal() {
        return numOfChosenSeats * 10;
    }
    
    
}
