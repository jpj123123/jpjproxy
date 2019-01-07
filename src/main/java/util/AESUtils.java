package util;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by lyl on 2017/12/11.
 */
public class AESUtils {

    public static final String AES = "AES";
    public static final String UTF_8 = "utf-8";

    public static String encode(String sourceData, String aesKey, String vector) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(aesKey.getBytes(), AESUtils.AES),
                    new IvParameterSpec(vector.getBytes())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new String(Base64.encodeBase64(cipher.doFinal(sourceData.getBytes(AESUtils.UTF_8))), AESUtils.UTF_8);// 此处使用BASE64做转码。
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] encode(byte[] sourceData, String aesKey, String vector) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    new SecretKeySpec(aesKey.getBytes(), AESUtils.AES),
                    new IvParameterSpec(vector.getBytes())
            );
        } catch (Exception e) {
            //throw CExceptionFactory.create("SAKU_BASE_1002");
        }
        try {
            return Base64.encodeBase64(cipher.doFinal(sourceData));// 此处使用BASE64做转码。
        } catch (Exception e) {
            //throw CExceptionFactory.create("SAKU_BASE_1002");

        }
        return null;
    }

    public static String decode(String encryptData, String aesKey, String vector){
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cipher.init(
                    Cipher.DECRYPT_MODE,
                    new SecretKeySpec(aesKey.getBytes(AESUtils.UTF_8), AESUtils.AES),
                    new IvParameterSpec(vector.getBytes())
            );
        } catch (Exception e) {
            //throw CExceptionFactory.create("SAKU_BASE_1002");
        }
        try {
            return new String(cipher.doFinal(Base64.decodeBase64(encryptData)), AESUtils.UTF_8);
        } catch (Exception e) {
            //throw CExceptionFactory.create("SAKU_BASE_1002");
        }
        return null;
    }

}
