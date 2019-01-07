package util;

import java.security.MessageDigest;

public class MD5Util {

	public MD5Util() {
	}

	public static final String getMD5String(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte btInput[] = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte md[] = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}

			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args1[]) {

		String str = "time1517537007tokentyuiggl55663ddsd{\n"
				+ "\"clientid\":\"a31177c93b399cff151125d4390566a8\",\n"
				+ "\"phoneNo\":\"13083663880\",\n"
				+ "\"phoneModel\":\"x86_64\",\n"
				+ "\"countryCode\":\"86\"\n"
				+ "}adkj58ghf7545ytjk";
		System.out.println(MD5Util.getMD5String(str));
	}
}
