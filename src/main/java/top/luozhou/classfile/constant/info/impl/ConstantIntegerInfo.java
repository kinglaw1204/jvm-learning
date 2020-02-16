package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
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

    @Override
    public String getValue() {
        return null;
    }
}
