package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 类或者接口符合引用
 * @author: luozhou
 * @create: 2020-02-07 21:10
 **/
@Data
public class ConstantClassInfo implements ConstantInfo {
    public final int tag = 7;
    private ConstantPool constPool;
    private int nameIndex;

    public ConstantClassInfo(ConstantPool constPool, ClassReader classReader) {
        this.nameIndex = classReader.nextU2ToInt();
        this.constPool = constPool;
    }

    @Override
    public String getValue() {
        return this.constPool.getUTF8(this.nameIndex);
    }

    @Override
    public String toString() {
        return this.constPool.getUTF8(this.nameIndex);
    }
}
