/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;


@Stateless
public class ClientValidatorEJB {
    
    
    /**
     * This function will receive a string parameter of zipcode and checks
     * if the length of the zipcode is 5.
     * @param zipcode
     * @return - If the zipcode length is not 5, return false. If the zipcode length is 5, return true;
     */
    public static boolean validateZipcode(String zipcode) {
        if(zipcode.length() != 5)
            return false;
        return true;
    }
    
    /**
     * This function will receive a string paramter of cc and checks
     * if the length of cc is 16
     * @param cc
     * @return If the zipcode is length is not 16, return false. If the cc length is 16, return true;
     */
    public static boolean validateCreditcard(String cc) {
        if(cc.length() != 16)
            return false;
        return true;
    }
}
