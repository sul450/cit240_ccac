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
    private SampleCode() {}
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
        
         /*
         * Now let's create a SecretKey object using the shared secret
         * and use it for encryption. First, we generate SecretKeys for the
         * "AES" algorithm (based on the raw shared secret data) and
         * Then we use AES in CBC mode, which requires an initialization
         * vector (IV) parameter. Note that you have to use the same IV
         * for encryption and decryption: If you use a different IV for
         * decryption than you used for encryption, decryption will fail.
         *
         * If you do not specify an IV when you initialize the Cipher
         * object for encryption, the underlying implementation will generate
         * a random one, which you have to retrieve using the
         * javax.crypto.Cipher.getParameters() method, which returns an
         * instance of java.security.AlgorithmParameters. You need to transfer
         * the contents of that object (e.g., in encoded format, obtained via
         * the AlgorithmParameters.getEncoded() method) to the party who will
         * do the decryption. When initializing the Cipher for decryption,
         * the (reinstantiated) AlgorithmParameters object must be explicitly
         * passed to the Cipher.init() method.
         */
        System.out.println("Use shared secret as SecretKey object ...");
        SecretKeySpec johnAesKey = new SecretKeySpec(johnSharedSecret, 0, 16, "AES");
        SecretKeySpec sallyAesKey = new SecretKeySpec(sallySharedSecret, 0, 16, "AES");
        
        /*
         * Bob encrypts, using AES in CBC mode
         */
        Cipher johnCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        johnCipher.init(Cipher..ENCRYPT_MODE, johnAesKey);
        byte [] cleartext = "This is just an example".getBytes();
        byte [] ciphertext = johnCipher.doFinal(cleartext);
        
        // Retreive the parameter that was used, and transfer it to Sally in 
        // encoded format
        byte [] encodedParams = johnCipher.getParameters().getEncoded();
        
         /*
         * Alice decrypts, using AES in CBC mode
         */

        // Instantiate AlgorithmParameters object from parameter encoding
        // obtained from Bob
        
       AlgorithmParameters aesParams = AlgorithmParameters.getInstance("AES");
       aesParams.init(encodedParams);
       Cipher sallyCipher - Cipher.getInstance("AES/CBC/PKCS5Padding");
       byte [] recovered = sallyCipher.doFinal(ciphertext);
       if (!java.util.Arrays.equals(cleartext, recovered))
           throw new Exception("AES in CBC mode recovered text is " + 
                               "different from cleartext");
       System.out.println("AES in CBC mode recovered text is " + "
                           same as cleartext");
       }
             
      /*
      * Converts a byte to hex digit and writes to the supplied buffer
      */ 
      private static void byte2hex(byte b, StringBuffer buf){
            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
                               '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            int high = ((b & 0xf0)) >> 4);
            int low = (b & 0x0f);
            buf.append(hexChars[high]);
            buf.append(hexChars[low]);
      }
      
      /*
      * Converts a byte array to hex string
      */
      private static String toHexString(byte[] block) {
          StingBuffer buf = new StringBuffer();
          int len = block.length;
          for (int i = 0; i < len; i++) {
              byte2hex(block[i], buf);
              if (i < len-1) {
                  buf.append(":");
              }                
         }
        return buf.toString();
    }
}
