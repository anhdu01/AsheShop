package library;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryString {
	public static String md5(String str){
		String result ="";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			BigInteger bi = new BigInteger(1,md.digest());
			result = bi.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
