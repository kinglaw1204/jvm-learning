package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 双精度浮点型字面量
 * @author: luozhou
 * @create: 2020-02-07 21:10
 **/
@Data
public class ConstantDoubleInfo implements ConstantInfo {
    public final int tag = 6;
    private double bytes;

    public ConstantDoubleInfo(ClassReader reader) {
        bytes = reader.next2U4Double();
    }

    @Override
    public String getValue() {
        return bytes + "";
    }

    @Override
    public String toString() {
        return "Double:" + bytes;
    }
}
