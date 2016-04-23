package com.core.aeschiper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class FileCoder {

	private static final String ALGORITHM = "AES";
	private static final String CIPHER_GETINSTANCE = "AES/CBC/PKCS5Padding";
	
	private static final BASE64Encoder ENCODER_64 = new BASE64Encoder();
	private static final BASE64Decoder DECODER_64 = new BASE64Decoder();
	
	private static final byte[] keyBytes = toBytes("ada13293a4c5e69728b9eaebecedee0f", 16);
	private static final byte[] ivSpec1 = toBytes("afe1d2a314f5d697b8c9fadbacadaeaf", 16);

	/**
	 * <p>
	 * ���ڿ��� ����Ʈ�迭�� �ٲ۴�.
	 * </p>
	 * 
	 * @param digits
	 *            ���ڿ�
	 * @param radix
	 *            ����
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NumberFormatException
	 */
	public static byte[] toBytes(String digits, int radix)
			throws IllegalArgumentException, NumberFormatException {
		if (digits == null) {
			return null;
		}
		if (radix != 16 && radix != 10 && radix != 8) {
			throw new IllegalArgumentException("For input radix: \"" + radix
					+ "\"");
		}
		int divLen = (radix == 16) ? 2 : 3;
		int length = digits.length();
		if (length % divLen == 1) {
			throw new IllegalArgumentException("For input string: \"" + digits
					+ "\"");
		}
		length = length / divLen;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			int index = i * divLen;
			bytes[i] = (byte) (Short.parseShort(
					digits.substring(index, index + divLen), radix));
		}
		return bytes;
	}

	private static Cipher getCipherInstance(boolean encoder)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			IOException, InvalidKeyException,
			InvalidAlgorithmParameterException {

		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
		IvParameterSpec ivSpec = new IvParameterSpec(ivSpec1);
		
		Cipher cipher = Cipher.getInstance(CIPHER_GETINSTANCE);
		
		if (encoder) {
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		} else {
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		}
		
		return cipher;
	}
	
	public static String encrypt(final String msg) throws IOException,
			NoSuchAlgorithmException, GeneralSecurityException {

		String encryptedMsg = "";
		byte[] encrypt = getCipherInstance(true).doFinal(msg.getBytes("UTF-8"));
		encryptedMsg = ENCODER_64.encode(encrypt);
		
		return encryptedMsg;
	}

	public static String decrypt(final String msg) throws IOException,
			NoSuchAlgorithmException, GeneralSecurityException {

		byte[] encrypt = DECODER_64.decodeBuffer(msg);
		byte[] decrypt = getCipherInstance(false).doFinal(encrypt);
        String decryptedMsg = new String(decrypt);
		
		return decryptedMsg;
	}

		
	
	
	
	/**
	 * From a base 64 representation, returns the corresponding byte[]
	 * 
	 * @param data
	 *            String The base64 representation
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] base64ToByte(String data) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(data);
	}
	
	/**
	 * From a byte[] returns a base 64 representation
	 * 
	 * @param data
	 *            byte[]
	 * @return String
	 * @throws IOException
	 */
	public static String byteToBase64(byte[] data) {
		BASE64Encoder endecoder = new BASE64Encoder();
		return endecoder.encode(data);
	}
	
	public static String byteToString(byte[] data) {
	
		StringBuilder sb = new StringBuilder();
		for (byte b : data) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	private static String hexify(byte[] output) {
		StringBuilder sb = new StringBuilder();
		for(byte b : output){
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1){
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}
	
	public static String getSalt() throws NoSuchAlgorithmException {
		// Uses a secure Random not a simple Random
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		// Salt generation 64 bits long
		byte[] bSalt = new byte[8];
		random.nextBytes(bSalt);
		String strSalt = byteToString(bSalt);
		// System.out.println("Salt String =>" + strSalt);
		return strSalt;
	}
	
	/**
	 * From a password, a number of iterations and a salt, returns the
	 * corresponding digest
	 * 
	 * @param iterationNb
	 *            int The number of iterations of the algorithm
	 * @param password
	 *            String The password to encrypt
	 * @param salt
	 *            byte[] The salt
	 * @return byte[] The digested password
	 * @throws NoSuchAlgorithmException
	 *             If the algorithm doesn't exist
	 * @throws UnsupportedEncodingException
	 */
	public static String ComputeHash(String plainText, String strSalt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		String strNewPassword = plainText + strSalt;
	
		byte[] bNewPassword = strNewPassword.getBytes("UTF-8");
		//byte[] bNewPassword = strNewPassword.getBytes();
		
		digest.update(bNewPassword);
		byte[] bOutput = digest.digest();
		
		String strHex = hexify(bOutput);
		System.out.println("hexify=> " + strHex);
		
		return byteToBase64(bOutput);
	}
	
	public static boolean VerifyHash(String plainText, String strHash, String strSalt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		String expectedHashString = ComputeHash(plainText,strSalt);
		return strHash.equals(expectedHashString);
	}
}
