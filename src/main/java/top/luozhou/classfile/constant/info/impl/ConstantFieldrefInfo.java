package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 字段的符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:12
 **/
@Data
public class ConstantFieldrefInfo implements ConstantInfo {
    public final int tag = 9;

    private int classInfoIndex;
    private int nameAndTypeIndex;

    public String getValue() {
        return null;
    }
}
