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
public class SallyGenKP {
    public static KeyPair genKeyPair (){
         KeyPair sallyKpair = null;
        try {
            System.out.println("Sally: Generate DH keypair ...");
            KeyPairGenerator sallyKpairGen = KeyPairGenerator.getInstance("DH");
            sallyKpairGen.initialize(4096);
            sallyKpair = sallyKpairGen.generateKeyPair();
            
            // Sally creates and initializes her DH KeyAgreement object
            System.out.println("Sally: Intilization ...");
            KeyAgreement sallyKeyAgree = KeyAgreement.getInstance("DH");
            sallyKeyAgree.init(sallyKpair.getPrivate());
        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {
            System.out.println(ex);
        }
        return sallyKpair;
    } //close genKeyPair
}
