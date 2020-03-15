package top.luozhou.classfile;

import lombok.Getter;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description: 字段表
 * @author: luozhou
 * @create: 2020-02-07 17:19
 **/
@Getter
public class FieldTableInfo {
    private ConstantPool cp;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private AttributeInfo[] attributes;

    public FieldTableInfo(ConstantPool constantPool, ClassReader reader) {
        cp = constantPool;
        accessFlags = reader.nextU2ToInt();
        nameIndex = reader.nextU2ToInt();
        descriptorIndex = reader.nextU2ToInt();
        attributes = AttributeInfo.readAttributes(reader, cp);
    }

    public static FieldTableInfo[] readMethodTableInfo(ConstantPool constantPool, ClassReader reader) {
        int fieldCount = reader.nextU2ToInt();
        FieldTableInfo[] fields = new FieldTableInfo[fieldCount];

        for (int i = 0; i < fieldCount; i++) {
            fields[i] = new FieldTableInfo(constantPool, reader);
        }

        return fields;
    }
}
