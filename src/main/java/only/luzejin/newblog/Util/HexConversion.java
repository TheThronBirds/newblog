package only.luzejin.newblog.Util;

/**
 * 包名称only.luzejin.newblog.Util
 * 类名称HexConversion
 * 类描述 TODO
 * 创建人luzejin
 * 创建时间2019/5/5 9:41
 **/
public class HexConversion {

    /**
     * 二进制转换成十六进制
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if(num < 0) {
                num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}
