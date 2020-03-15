package top.luozhou.classfile.attributes.impl;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description:
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-03-15 16:51
 **/
public class SourceFileAttribute implements AttributeInfo {
    private ConstantPool cp;
    private String sourceFile;

    public SourceFileAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        int sourceFileIndex = reader.nextU2ToInt();
        sourceFile = cp.getUTF8(sourceFileIndex);
    }
}
