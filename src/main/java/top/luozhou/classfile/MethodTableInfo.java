package top.luozhou.classfile;

import lombok.Getter;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description: 方法表
 * @author: luozhou
 * @create: 2020-02-07 17:20
 **/
@Getter
public class MethodTableInfo {
    private ConstantPool cp;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private AttributeInfo[] attributes;

    public MethodTableInfo(ConstantPool constantPool, ClassReader reader) {
        this.cp=constantPool;
        accessFlags = reader.nextU2ToInt();
        nameIndex = reader.nextU2ToInt();
        descriptorIndex = reader.nextU2ToInt();
        attributes = AttributeInfo.readAttributes(reader, cp);
    }


    public static MethodTableInfo[] readMethodTableInfo(ConstantPool constantPool, ClassReader reader) {

        int fieldCount = reader.nextU2ToInt();
        MethodTableInfo[] methodTableInfos = new MethodTableInfo[fieldCount];

        for (int i = 0; i < fieldCount; i++) {
            methodTableInfos[i] = new MethodTableInfo(constantPool, reader);
        }
        return methodTableInfos;
    }
}
