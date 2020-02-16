package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 类中方法的符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:13
 **/
@Data
public class ConstantMethodrefInfo {
    public final int tag = 10;
    private int classInfoIndex;
    private int nameAndTypeIndex;

}
