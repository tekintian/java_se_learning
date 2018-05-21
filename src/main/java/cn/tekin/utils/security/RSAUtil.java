package cn.tekin.utils.security;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RSAUtil {
    private static char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * main test
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(getPublicKey());
    }

    /**
     * 加密
     *
     * @param message
     * @return
     */
    public static String encrypt(String message) {
        byte[] result = null;
        try {
            result = encrypt(message, getPublicKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toHexString(result);
    }
    /**
     * 解密
     *
     * @param message
     * @return
     */
    public static String decrypt(String message) {
        byte[] result = null;
        try {
            result = decrypt(message, getPublicKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(result);
    }
    /**
     * 加密(公钥加密、私钥加密)
     *
     * @param message 待加密的消息
     * @param key 公钥或私钥
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(String message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 注意中文的处理
        return cipher.doFinal(message.getBytes("utf-8"));
    }
    /**
     * 解密(如果公钥加密，则用私钥解密；如果私钥加密，则用公钥解密)
     *
     * @param message 待解密的消息
     * @param key 公钥或私钥
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(String message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(toBytes(message));
    }
    /**
     * 通过模长和公钥指数获取公钥
     *
     * @param modulus 模长
     * @param publicExponent 公钥指数
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey() {
        PublicKey publicKey = null;
        String modulus = "140865665237544398577638791993321201143991791099370252934699963963887058026979531275917645451893685346013654333931757603593193739776986525943697469996693704995753266331593233395038088698299308180612215713544577462613426793519824197226393059683065343801412208205295045502348474411031999124137863144916358656019";
        String publicExponent = "65537";
        BigInteger m = new BigInteger(modulus);
        BigInteger e = new BigInteger(publicExponent);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
            publicKey = keyFactory.generatePublic(keySpec);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return publicKey;
    }
    private static final byte[] toBytes(String s) {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
            sb.append(HEXCHAR[b[i] & 0x0f]);
        }
        return sb.toString();
    }

}