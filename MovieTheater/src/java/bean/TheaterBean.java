/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author nate
 */
@Named(value = "theaterBean")
@Dependent
public class TheaterBean {

    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterBean() {
    }
    
}
