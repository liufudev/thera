/**
 * @author liufu
 */

import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMacUtil {

    /**
     * sha256_HMAC加密
     *
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String sha256(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    public static void main(String[] args) {
        // String timestamp = "1544438581";
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime()).substring(0, 10);
        System.out.println("timestamp: " + timestamp);
        //【推荐内容接口】
        //
        //app_id：huaweibro-iflow
        //
        //app_key：edPbg9teqImeg4nYdpj8
        System.out.println("huaweibro-iflow: " + sha256("12345678" + timestamp, "edPbg9teqImeg4nYdpj8"));

        //【批量内容接口】
        //
        //app_id：huaweic-iflow
        //
        //app_key：nwF8kmUUfcepWDrn
        System.out.println("huaweic-iflow: " + sha256("12345678" + timestamp, "nwF8kmUUfcepWDrn"));
    }
}