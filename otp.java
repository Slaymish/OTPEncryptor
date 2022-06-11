import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.nio.charset.Charset;

public class otp {
    Random rand = new Random();

    /**
     * Prints string in terminal
     * @param string
     */
    public void print(String s){
        System.out.println(s);
    }

    /**
     * Prints an array of bytes to terminal
     * @param bytes
     */
    public void printBytes(byte[] bytes){
        this.print(Arrays.toString(bytes));
    }

    /**
     * Prints an array of ints to terminal
     * @param ints
     */
    public void printInts(int[] ints){
        this.print(Arrays.toString(ints));
    }
    
    
    /**
     * Encrypts a word using a OTP caesar cipher
     * @param word
     */
    public byte[] encryptWord(String word){
        // Convert word to bytes
        byte[] wordBytes = word.getBytes();

        // Generate random key
        byte[] keyTemp = new byte[wordBytes.length];
        rand.nextBytes(keyTemp);

        // Apply OTP to bytes
        for(int i=0; i< wordBytes.length ; i++) {
            byte b = wordBytes[i];
            b += keyTemp[i];
            wordBytes[i] = b;
        }

        // Convert key to string
        //this.printBytes(keyBytes);
        //this.printBytes(encryptedWord);

        // encryptedWord
        // keyBytes

        byte[] combinedbytes = new byte[keyTemp.length*2];
        System.arraycopy(keyTemp, 0, combinedbytes, 0, keyTemp.length);
        System.arraycopy(wordBytes, 0, combinedbytes, keyTemp.length, keyTemp.length);
        return combinedbytes;
        
    }

    /**
     * Decrypts using key and word assigned to obj
     */
    public String decryptWord(byte[] bytes){
        byte[] key = new byte[bytes.length/2];
        byte[] word = new byte[bytes.length/2];
        System.arraycopy(bytes,0,key,0,(bytes.length/2));
        System.arraycopy(bytes,(bytes.length/2),word,0,bytes.length/2);

        for(int i=0; i< word.length ; i++) {
            byte b = word[i];
            b -= key[i];
            word[i] = b;
        }

        String s = new String(word); 
        return s;
    }


}
