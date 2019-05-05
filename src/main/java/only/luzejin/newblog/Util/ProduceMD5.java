package only.luzejin.newblog.Util;

import java.security.MessageDigest;

/**
 * 包名称only.luzejin.newblog.Util
 * 类名称ProduceMD5
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/5 9:40
 **/
public class ProduceMD5 {

    /**
     * 生成MD5值
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位
            md5 = HexConversion.bytesToHex(md5Byte);                            // 转换为16进制字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }
}
