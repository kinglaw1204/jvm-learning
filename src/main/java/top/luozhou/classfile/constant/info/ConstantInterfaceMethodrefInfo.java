package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 接口中方法的符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:14
 **/
@Data
public class ConstantInterfaceMethodrefInfo {
    public final int tag = 11;
    private int classInfoIndex;
    private int nameAndTypeIndex;



}
