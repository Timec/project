package com.core.aeschiper;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileCoderOpen {
	private Cipher cipherAes;
	private SecretKeySpec key;
	private IvParameterSpec initalVector;

	private static final String OPEN_KEY = "a0e97f59df7dda47979dc1a81d7ed8c2";
	private static final String OPEN_IV = "e381c02e82cf61e3c288a3d44e5086db";
	
	public FileCoderOpen() throws Exception {
		String key = OPEN_KEY;
		String initialVector = OPEN_IV;
		
		if (key == null || key.equals(""))
			throw new Exception("The key can not be null or an empty string.");

		if (initialVector == null || initialVector.equals(""))
			throw new Exception("The initial vector can not be null or an empty string.");

		// Create a AES algorithm.
		this.cipherAes = Cipher.getInstance("AES/CBC/PKCS5Padding");

		// Initialize an encryption key and an initial vector.
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		this.key = new SecretKeySpec(md5.digest(key.getBytes("UTF8")), "AES");
		this.initalVector = new IvParameterSpec(md5.digest(initialVector.getBytes("UTF8")));
	}
	
	public String encrypt(String value) throws Exception {
		if (value == null)
			value = "";

		// Initialize the cryptography algorithm.
		this.cipherAes.init(Cipher.ENCRYPT_MODE, this.key, this.initalVector);

		// Get a UTF-8 byte array from a unicode string.
		byte[] utf8Value = value.getBytes("UTF8");

		// Encrypt the UTF-8 byte array.
		byte[] encryptedValue = this.cipherAes.doFinal(utf8Value);

		// Return a base64 encoded string of the encrypted byte array.
		return Base64Encoder.encode(encryptedValue);
	}
	
	public String decrypt(String value) throws Exception {
		if (value == null || value.equals(""))
			throw new Exception("The cipher string can not be null or an empty string.");

		// Initialize the cryptography algorithm.
		this.cipherAes.init(Cipher.DECRYPT_MODE, this.key, this.initalVector);

		// Get an encrypted byte array from a base64 encoded string.
		byte[] encryptedValue = Base64Encoder.decode(value);

		// Decrypt the byte array.
		byte[] decryptedValue = this.cipherAes.doFinal(encryptedValue);

		// Return a string converted from the UTF-8 byte array.
		return new String(decryptedValue, "UTF8");
	}
}
