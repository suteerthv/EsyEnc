package esyenc;

import java.io.*;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;


import org.apache.commons.codec.binary.*;

class AES
	{

		public  String Encrypt(String plainText, String key) throws
		    NoSuchAlgorithmException,
		    NoSuchPaddingException,
		    InvalidKeyException,
		    IllegalBlockSizeException,
		    BadPaddingException,
		    UnsupportedEncodingException
		{
		    SecretKeySpec KeyMaker = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		     
		    // Instantiate the Encryptor
		    Cipher Encryptor = Cipher.getInstance("AES");
		    Encryptor.init(Cipher.ENCRYPT_MODE, KeyMaker);
		     
		    byte[] EncBytes = Encryptor.doFinal(plainText.getBytes("UTF-8"));
		     
		    return new Base64().encodeAsString(EncBytes);
		}
		 
		public String Decrypt(String encryptedText, String key) throws
		    NoSuchAlgorithmException,
		    NoSuchPaddingException,
		    InvalidKeyException,
		    IllegalBlockSizeException,
		    BadPaddingException,
		    UnsupportedEncodingException 
		{
		     
		    SecretKeySpec KeyMaker = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
 
		    // Instantiate the Encryptor
		    Cipher Encryptor = Cipher.getInstance("AES");
		    Encryptor.init(Cipher.DECRYPT_MODE, KeyMaker);
		     
		    new Base64();
			byte[] EncBytes = Base64.decodeBase64(encryptedText);
		    byte[] decryptedTextBytes = Encryptor.doFinal(EncBytes);
     
		    return new String(decryptedTextBytes);
		}
 
	
	}
