package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 方法类型
 * @author: luozhou
 * @create: 2020-02-07 21:18
 **/
@Data
public class ConstantMethodTypeInfo implements ConstantInfo {
    public final int tag = 16;
    private int descriptorIndex;

    public String getValue() {
        return null;
    }
}
