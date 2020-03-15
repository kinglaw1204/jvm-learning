package top.luozhou.classfile.attributes.impl;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description:
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-03-15 16:52
 **/
public class UnparsedAttribute implements AttributeInfo {
    private String name;
    private int length;
    private byte[] info;

    public UnparsedAttribute(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public void readInfo(ClassReader reader) {
        info = reader.nextBytes(length);
    }
}
