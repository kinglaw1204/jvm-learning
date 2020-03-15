package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: utf-8编码字符串
 * @author: luozhou
 * @create: 2020-02-07 17:43
 **/
@Data
public class ConstantUtf8Info implements ConstantInfo {
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


    public ConstantUtf8Info(ClassReader reader) {
        int length = reader.nextU2ToInt();
        byte[] bytes = reader.nextBytes(length);
        this.bytes = new String(bytes);
    }

    @Override
    public String getValue() {
        return bytes;
    }

    @Override
    public String toString() {
        return bytes;
    }
}
