package top.luozhou.classfile.util;

/**
 * @description: 字节转换工具类
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 15:46
 **/
public class ByteUtil {

    public static int byteToInt(byte[] codes) {
        String s1 = byteToHexString(codes);
        return Integer.valueOf(s1, 16).intValue();
    }

    public static String byteToHexString(byte[] codes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.length; i++) {
            byte b = codes[i];
            int value = b & 0xFF;
            String strHex = Integer.toHexString(value);
            if (strHex.length() < 2) {
                strHex = "0" + strHex;
            }
            sb.append(strHex);
        }
        return sb.toString();
    }

}
