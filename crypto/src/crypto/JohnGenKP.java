/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyAgreement;

/**
 *
 * @author sliu11
 */
public class JohnGenKP {
    public static KeyPair genKeyPair (){
        KeyPair johnKpair = null;
            
        try{
            System.out.println("John: Generate DH Keypair ...");
            KeyPairGenerator johnKpairGen = KeyPairGenerator.getInstance("DH");
            johnKpairGen.initialize(dhParamFromSallyPubKey);
            johnKpair = johnKpairGen.generateKeyPair();
            
            // John creates and initializes his DH KeyAgreement object
            System.out.println("John: Initialization ...");
            KeyAgreement johnKeyAgree = KeyAgreement.getInstance("DH");
            johnKeyAgree.init(johnKpair.getPrivate());
        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {
            System.out.println(ex);
        }       
        return johnKpair;
    }
}
