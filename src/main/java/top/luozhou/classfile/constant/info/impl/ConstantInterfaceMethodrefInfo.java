package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
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
    private ConstantPool constantPool;

    public ConstantInterfaceMethodrefInfo(ConstantPool constantPool, ClassReader reader) {
        this.classInfoIndex = reader.nextU2ToInt();
        this.nameAndTypeIndex = reader.nextU2ToInt();
        this.constantPool = constantPool;
    }
    @Override
    public String getValue() {

        return constantPool.getUTF8(classInfoIndex) + " " + constantPool.getUTF8(nameAndTypeIndex);
    }

    @Override
    public String toString() {
        return constantPool.getUTF8(nameAndTypeIndex);
    }
}
