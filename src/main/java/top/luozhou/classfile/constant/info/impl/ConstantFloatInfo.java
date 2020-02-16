package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
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

    public String getValue() {
        return null;
    }
}
