package top.luozhou.classfile.attributes.impl;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description:
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-03-15 16:47
 **/
public class ConstantValueAttribute implements AttributeInfo {
    /**
     * 具体指向哪种常量因字段类型而异
     */

    private int constantValueIndex;

    @Override
    public void readInfo(ClassReader reader) {
        constantValueIndex = reader.nextU2ToInt();
    }
}
