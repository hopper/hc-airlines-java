package com.hopper.cloud.airlines.helper;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaHelper {
    protected static KeyPair generateRsaKeyPair(int rsaKeySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(rsaKeySize);
        return keyPairGenerator.genKeyPair();
    }

    public static Base64RsaKeyPair buildBase64RsaKeys() throws Exception {
        KeyPair keyPair = generateRsaKeyPair(2048);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String base64PublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String base64PrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        return new Base64RsaKeyPair(base64PublicKey, base64PrivateKey);
    }

    protected static RSAPublicKey base64StringToPublicKey(String base64PublicKey) throws Exception {
        byte [] keyBytes = Base64.getDecoder().decode(base64PublicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
    }

    protected static String encryptDataRsa(String plainData, PublicKey publicKey) throws Exception {
        Cipher inputCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        inputCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return Base64.getEncoder().encodeToString(inputCipher.doFinal(plainData.getBytes()));
    }

    /**
     * Encrypt a string using RSA-2048, with a pre-definite public key
     * @param value
     * @param base64PublicKey       Public base64 Key used for encryption
     * @return
     */
    public static String encryptDataUsingRSA(String value, String base64PublicKey) throws Exception {
        RSAPublicKey rsaPublicKey = RsaHelper.base64StringToPublicKey(base64PublicKey);
        return RsaHelper.encryptDataRsa(value, rsaPublicKey);
    }
}
