package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description:整型字面量
 * @author: luozhou
 * @create: 2020-02-07 17:56
 **/
@Data
public class ConstantIntegerInfo implements ConstantInfo {
    public final int tag = 3;

    private int bytes;

    //读取U4类型数据
    public ConstantIntegerInfo(ClassReader reader) {
        bytes = reader.nextU4ToInt();
    }

    @Override
    public String getValue() {
        return bytes + "";
    }

    @Override
    public String toString() {
        return "Integer: " + bytes;
    }
}
