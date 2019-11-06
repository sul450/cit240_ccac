/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

/**
 *
 * @author sliu11
 */
public class SampleCode {
    public static void main(String argv[]) throws Exception {
        System.out.println("Sally: Generate DH keypair ...");
        KeyPairGenerator sallyKpairGen = KeyPairGenerator.getInstance("DH");
        sallyKpairGen.initialize(4096);
        KeyPair sallyKpair = sallyKpairGen.generateKeyPair();
        
        System.out.println("Sally: Intilization ...");
        KeyAgreement sallyKeyAgree = KeyAgreement.getInstance("DH");
        sallyKeyAgree.init(sallyKpair.getPrivate());
        
        byte[] sallyPubKeyEnc = sallyKpair.getPublic().getEncoded();
        
        KeyFactory johnKeyFac = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sallyPubKeyEnc);
        
        PublicKey sallyPubKey = johnKeyFac.generatePublic(x509KeySpec);
        
        DHParameterSpec dhParamFromSallyPubKey = ((DHPublicKey)sallyPubKey).getParams();
        
        System.out.println("John: Generate DH Keypair ...");
        KeyPairGenerator johnKpairGen = KeyPairGenerator.getInstance("DH");
        johnKpairGen.initialize(dhParamFromSallyPubKey);
        KeyPair johnKpair = johnKpairGen.generateKeyPair();
        
        System.out.println("John: Initialization ...");
        KeyAgreement johnKeyAgree = KeyAgreement.getInstance("DH");
        johnKeyAgree.init(johnKpair.getPrivate());
        
        byte[] johnPubKeyEnc = johnKpair.getPublic().getEncoded();
        
        KeyFactory sallyKeyFac =  KeyFactory.getInstance("DH");
        x509KeySpec = new X509EncodedKeySpec(johnPubKeyEnc);
        PublicKey johnPubKey = sallyKeyFac.generatePublic(x509KeySpec);
        System.out.println("Sally: Execute PHASE1 ...");
        sallyKeyAgree.doPhase(johnPubKey, true);
        
        System.out.println("John: Execute PHASE1 ...");
        johnKeyAgree.doPhase(johnPubKey, true);
        
     
            byte[] sallySharedSecret = sallyKeyAgree.generateSecret();
            int sallyLen = sallySharedSecret.length;
            byte[] johnSharedSecret = new byte[sallyLen];
            int johnLen;
        
        johnLen = johnKeyAgree.generateSecret(johnSharedSecret, 0);
        System.out.println("Sally Secret: " + 
                toHexString(sallySharedSecret));
        System.out.println("John Secret: " +
                toHexString(johnSharedSecret));
        if (!java.util.Arrays.equals(sallySharedSecret, johnSharedSecret))
            throw new Exception("Shared secret differ");
        System.out.println("Shared secrets are the same");
    }
    
}
