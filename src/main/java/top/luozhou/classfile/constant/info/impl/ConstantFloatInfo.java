package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 浮点型字面量
 * @author: luozhou
 * @create: 2020-02-07 17:57
 **/
@Data
public class ConstantFloatInfo implements ConstantInfo {
    public final int tag = 4;

    private float bytes;

    public ConstantFloatInfo(ClassReader reader) {
        bytes = reader.nextU4ToFloat();
    }

    @Override
    public String getValue() {
        return bytes + "";
    }
    @Override
    public String toString() {
        return "Float: " + bytes;
    }

}
