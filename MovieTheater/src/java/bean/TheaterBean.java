/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author nate
 */
@Named(value = "theaterBean")
@RequestScoped
public class TheaterBean {

    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterBean() {
    }
    
}
