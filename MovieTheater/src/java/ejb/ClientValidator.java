/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;


@Stateless
public class ClientValidator {

    private static boolean isInteger(String s) {
        try{
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean validateZipcode(String zipcode) {
        boolean result = true;
        if(zipcode.length() != 5)
            result = false;
        if(!isInteger(zipcode))
            result = false;
        return result;
    }
    
    public static boolean validateCreditcard(String cc) {
        boolean result = true;
        if(cc.length() != 16)
            result = false;
        if(!isInteger(cc))
            result = false;
        return result;
    }
}
