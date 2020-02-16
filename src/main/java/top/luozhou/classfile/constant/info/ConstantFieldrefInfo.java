package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 字段的符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:12
 **/
@Data
public class ConstantFieldrefInfo {
    public final int tag = 9;

    private int classInfoIndex;
    private int nameAndTypeIndex;

}
