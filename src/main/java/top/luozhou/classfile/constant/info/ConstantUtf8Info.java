package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: utf-8编码字符串
 * @author: luozhou
 * @create: 2020-02-07 17:43
 **/
@Data
public class ConstantUtf8Info {
    /**
     * 标志
     */
    public final int tag = 1;
    /**
     * 字符串占用的字节数
     */
    private int length;
    /**
     * 字符串
     **/
    private String bytes;

}
