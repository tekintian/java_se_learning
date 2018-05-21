package cn.tekin.utils.security;

import java.security.MessageDigest;

public class MD5Util {
    public static void main(String[] args) {

        System.out.println(MD5("123"));
    }
    /**
     * 将字符串加密为MD5的结果
     * @param source 源字符串
     * @return 加密后的字符串
     */
    public static String MD5(String source) {
        try {
            // 对密码进行ＭD5加密处理
            byte byteEncrypt[] = null;
            byteEncrypt = source.getBytes("UTF8");
            MessageDigest mdInstance = MessageDigest.getInstance("MD5");
            mdInstance.update(byteEncrypt);
            byte byteArray[] = mdInstance.digest();

            // MD5转换编码
            StringBuffer md5StrBuff = new StringBuffer();
            for (int i = 0; i < byteArray.length; i++) {

              //错误的方式；0xFF & byteArray[i]).length() == 1 的时候会缺少 0 位数不对
                md5StrBuff.append(Integer.toHexString(0xff & byteArray[i]));

                //正确的方式
                /*
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
                */
                //end

            }

            return md5StrBuff.toString();
        } catch (Exception e) {
        }

        return null;
    }
}




