package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 接口中方法的符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:14
 **/
@Data
public class ConstantInterfaceMethodrefInfo implements ConstantInfo {
    public final int tag = 11;
    private int classInfoIndex;
    private int nameAndTypeIndex;

    @Override
    public String getValue() {
        return null;
    }
}
