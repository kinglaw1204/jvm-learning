package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 字段或方法的部分符号引用
 * @author: luozhou
 * @create: 2020-02-07 21:15
 **/
@Data
public class ConstantNameAndTypeInfo implements ConstantInfo {
    public final  int tag = 12;
    private int nameIndex;
    private int descriptorIndex;
    private ConstantPool constPool;

    public ConstantNameAndTypeInfo(ConstantPool aConstPool, ClassReader reader) {
        this.nameIndex = reader.nextU2ToInt();
        this.descriptorIndex = reader.nextU2ToInt();
        this.constPool = aConstPool;
    }
    @Override
    public String getValue() {
        return "";
    }

    @Override
    public String toString() {
        return this.constPool.getUTF8(this.nameIndex) + "&"
                + this.constPool.getUTF8(this.descriptorIndex);
    }

}
