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
@Named(value = "movieBean")
@Dependent
public class MovieBean {

    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }
    
}
