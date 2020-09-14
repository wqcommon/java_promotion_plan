package kaikeba.zhibo0704;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * @author: wenqiang
 * @date: 2020-07-04 08:07
 */
public class AESUtil {

    public static void main(String[] args) throws Exception {
        //获取秘钥
        byte[] secretKeyBytes = generateKey();
        System.out.println("secretKey:" + new String(Hex.encode(secretKeyBytes)));

        //加密
        String sourceData = "wenqiang001";
        byte[] secretBytes = encrypt(sourceData.getBytes(), secretKeyBytes);
        System.out.println("secretData:" + new String(Hex.encode(secretBytes)));

        //解密
        byte[] dataBytes = decrypt(secretBytes,secretKeyBytes);
        System.out.println("data:" + new String(dataBytes));
    }

    //生成秘钥
    public static byte[] generateKey() throws Exception {
       Security.addProvider(new BouncyCastleProvider());
       KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
       //包含 16字节 24字节 32字节的秘钥长度
       keyGenerator.init(128);
       SecretKey key = keyGenerator.generateKey();
       return key.getEncoded();
    }


    //加密
    public static byte[] encrypt(byte[] data,byte[] keyBytes) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        //转换为秘钥
        Key key = new SecretKeySpec(keyBytes,"AES");
        //iv
        byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00);
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key,params);
        return cipher.doFinal(data);
    }

    //解密
    public static byte[] decrypt(byte[] secretBytes,byte[] keyBytes) throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        //转换为秘钥
        Key key = new SecretKeySpec(keyBytes,"AES");
        //iv
        byte[] ivs = new byte[16];
        Arrays.fill(ivs, (byte) 0x00);
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(ivs));

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.DECRYPT_MODE,key,params);
        return cipher.doFinal(secretBytes);
    }
}
