/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;


@Stateless
public class ClientValidatorEJB {
    
    public static boolean validateZipcode(int zipcode) {
        if(String.valueOf(zipcode).length() != 5)
            return false;
        return true;
    }
    
    public static boolean validateCreditcard(int cc) {
        if(String.valueOf(cc).length() != 16)
            return false;
        return true;
    }
}
