/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author sliu11
 */
public class Md5Test {

    private static final String importantMessage = "Accleartion is nine point eight "
            + "meters Not per SECOND per second on earth";
    
    /*
     * Demo method for computing an MD5 hash value of an incoming string
     */
    public static void main(String[] args){
        System.out.println("INPUT: ");
        System.out.println(importantMessage);
        try{
            //Create an instance of a hashing machine
            MessageDigest digester = MessageDigest.getInstance("MD5");
            
            // call update() as many times as we need to store
            // all the data we want to hash, we must pass in the input
            // as an array of bytes, not a string
            digester.update(importantMessage.getBytes());
            
            // Finally, call digest() to get the hashed value
            // and we immediately pass output to 
            // a fancy adapter class calls DataTypeConverter 
            // which turns a raw bytes into Unicode string
            String h = DatatypeConverter.printHexBinary(digester.digest());
            // output hashed value to user.
            System.out.println("hashed value: " + h);
        }catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
    }
    
}
