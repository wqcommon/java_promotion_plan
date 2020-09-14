package kaikeba.zhibo0704;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Base64;

/**
 * @author: wenqiang
 * @date: 2020-07-04 08:40
 */
public class RSAUtil {

    public static void main(String[] args) throws Exception {
        //生成公私钥对
        RSAKeyPair keyPair = genKeyPair();
        System.out.println("public key:" + Base64.getEncoder().encodeToString(keyPair.publicKey.getEncoded()));
        System.out.println("private key:" + Base64.getEncoder().encodeToString(keyPair.privateKey.getEncoded()));

        //加密
        String data = "wq迭代001@123!";
        byte[] secretBytes = encrypt(data.getBytes("utf-8"),keyPair.publicKey);
        System.out.println("secret msg:" + new String(Hex.encode(secretBytes)));

        //解密
        System.out.println("source msg:" + new String(decrypt(secretBytes,keyPair.privateKey),"utf-8"));

        //签名
        byte[] signBytes = sign(secretBytes,keyPair.privateKey);
        System.out.println("sign msg:" + new String(Hex.encode(signBytes)));

        //验签
        System.out.println("verify sign:" + verifySign(secretBytes,signBytes,keyPair.publicKey));

    }


    static class RSAKeyPair{
        public RSAKeyPair(PublicKey publicKey, PrivateKey privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public PublicKey publicKey;
        public PrivateKey privateKey;
    }

    //生成公私钥对
    public static RSAKeyPair genKeyPair() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA","BC");
        keyPairGenerator.initialize(1024,new SecureRandom());
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PublicKey publicKey = keyPair.getPublic();//公钥
        PrivateKey privateKey = keyPair.getPrivate();//私钥
        return new RSAKeyPair(publicKey,privateKey);
    }

    //加密
    public static byte[] encrypt(byte[] dataBytes,PublicKey publicKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(dataBytes);
    }

    //解密
    public static byte[] decrypt(byte[] secretBytes,PrivateKey privateKey)
            throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return cipher.doFinal(secretBytes);
    }

    //签名
    public static byte[] sign(byte[] bytes,PrivateKey privateKey)
            throws Exception{
        Signature signature = Signature.getInstance("MD5WithRSA");
        signature.initSign(privateKey,new SecureRandom());
        signature.update(bytes);
        return signature.sign();
    }

    //验签
    public static boolean verifySign(byte[] sourceBytes,byte[] signBytes,PublicKey publicKey)
            throws Exception{
        Signature signature = Signature.getInstance("MD5WithRSA");
        signature.initVerify(publicKey);
        signature.update(sourceBytes);
        return signature.verify(signBytes);
    }

}
