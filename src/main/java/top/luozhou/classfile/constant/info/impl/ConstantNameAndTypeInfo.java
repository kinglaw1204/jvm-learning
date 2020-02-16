package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 字段或方法的部分符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:15
 **/
@Data
public class ConstantNameAndTypeInfo implements ConstantInfo {
    public final  int tag = 12;
    private int fieldAndMethodIndex;
    private int fieldAndMethodDescrib;


    public String getValue() {
        return null;
    }
}
