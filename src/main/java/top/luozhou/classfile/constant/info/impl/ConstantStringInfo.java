package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 字符类型字面量
 * @author: luozhou
 * @create: 2020-02-07 21:11
 **/
@Data
public class ConstantStringInfo implements ConstantInfo {
    public final int tag = 8;
    private ConstantPool constPool;
    private int nameIndex;
    public ConstantStringInfo(ConstantPool aConstPool, ClassReader reader) {
        this.nameIndex = reader.nextU2ToInt();
        this.constPool = aConstPool;
    }
    @Override
    public String getValue() {
        return this.constPool.getUTF8(this.nameIndex);
    }

    @Override
    public String toString() {
        return  this.constPool.getUTF8(this.nameIndex);
    }
}
