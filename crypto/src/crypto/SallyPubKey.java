/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

/**
 *
 * @author sliu11
 */
public class SallyPubKey {
    public static PublicKey sPubKey(byte[] sallyPubKeyEnc){
        try {
            PublicKey sPubKey = null;
            /*
            * Let's turn over to John. John has received Sally's public key
            * in encoded format
            * He instantiates a DH public key from the encoded key material.
            */
            KeyFactory johnKeyFac = KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sallyPubKeyEnc);
            
            PublicKey sallyPubKey = johnKeyFac.generatePublic(x509KeySpec);
            
            /*
            * John gets the DH parameters associated with Sally's public key.
            * He must use the same parameters when he generates his own key
            * pair
            */
            DHParameterSpec dhParamFromSallyPubKey = ((DHPublicKey)sallyPubKey).getParams();
            return sallyPubKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println(ex);
        }
        return null;
    }// close sPubKey
}
