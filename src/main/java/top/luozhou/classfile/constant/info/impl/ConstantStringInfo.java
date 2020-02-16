package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 字符类型字面量
 * @author: luozhou
 * @create: 2020-02-07 21:11
 **/
@Data
public class ConstantStringInfo implements ConstantInfo {
    public final int tag = 8;

    private String index;

    @Override
    public String getValue() {
        return null;
    }
}
