/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *
 * @author sliu11
 */
public class FileChangeChecker {
    /**
     * Reads in the file name of a user=submitted text file for
     * later processing by the checkFileIntegrity() method.
     * In network systems, this first file represents
     * a document that will be sent over a network, where it 
     * might potentially be corrupted or maliciously intercepted.
     * @param fname
     * @return true of the file is located and read into memory.
     * This method should return false if the file cannot be read
     * for any reason
     */
    public boolean loadOriginalFile(String fname);
    
    /**
     * Returns the MD5 hash value of the file loaded into memory\
     * when loadOriginalFile is called.
     * @return the Sting representation of the Hash of he file
     * and returns null if the file is not loaded
     */
    public String getOriginalFileHash();
    
    /**
     * Reads in the file name of a user-submitted text file
     * for later hashing and checking by the checkFileIntegrity()
     * method
     * @param fname
     * @return
     */
    public boolean loadTransmittedFile(String fname);
    
    /**
     * Returns the MD5 hash of the file submitted when
     * loadTransmittedFile is called.
     * @return the string version of the MD5 hash. Returns
     * null if the file cannot be found or processed. 
     */
    public String getTransmittedFileHash();
    
    /**
     * Compares the MD5 hash of the original and transmitted file
     * and returns true of the files result in the same hash.
     * Returns false if the files are different.
     * An implementation could consider throwing an exception
     * if this method is called without proper setting up
     * of the two files.
     * @return
     */
    public boolean checkFileIntegrity();
}
