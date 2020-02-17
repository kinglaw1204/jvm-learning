package top.luozhou.classfile;

import lombok.Data;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description: 类文件
 * @author: luozhou
 * @create: 2020-02-07 16:46
 **/
@Data
public class ClassFile {
    /**次版本*/
    private int minorVersion;
    /**主版本*/
    private int majorVersion;
    /**常量池**/
    private ConstantPool constantPool;
    /**访问标志**/
    private int accessFlags;
    /**类索引**/
    private int thisClass;
    /**父类索引**/
    private int superClass;
    /**接口索引集合*/
    private int[] interfaces;
    /**字段表集合**/
    private FieldTableInfo[] fields;
    /**方法表集合*/
    private MethodTableInfo[] methods;
    /***属性表集合*/
    private AttributeInfo[] attributes;
    private ClassReader reader;
    private static String CAFA_BABY="cafebabe";
    public ClassFile(byte[] classData) {
        reader = new ClassReader(classData);

        this.readAndCheckMagic();
        this.readAndCheckVersion();
        this.readConstantPool();

        this.readAccessFlag();
//        this.readClassNameIndex();
//        this.readSuperClassNameIndex();
//        this.readInterfaceIndexes();
//        this.readFields();
//        this.readMethods();
    }

    //0xCAFEBABE
    private void readAndCheckMagic() {
        String magic = this.reader.nextU4ToHexString();
        if (!CAFA_BABY.equals(magic)) {
            throw new ClassFormatError("magic!");
        }
    }

    private void readAndCheckVersion() {
        this.minorVersion = this.reader.nextU2ToInt();
        this.majorVersion = this.reader.nextU2ToInt();

        if (this.majorVersion >= 46 && this.majorVersion <= 52 && this.minorVersion == 0) {
            return;
        }
        throw new UnsupportedClassVersionError();
    }

    private void readConstantPool() {
//        this.constantPool = new ConstantPool(this.reader);
    }

    private void readAccessFlag() {
        this.accessFlags = reader.nextU2ToInt();
    }

//    private void readClassNameIndex() {
//        classNameIndex = reader.nextU2ToInt();
//    }
//
//    private void readSuperClassNameIndex() {
//        superClassNameIndex = reader.nextU2ToInt();
//    }
//
//    private void readInterfaceIndexes() {
//        interfaceIndexes = reader.nextUint16s();
//    }
//
//    private void readFields() {
//        fields = MemberInfo.readMembers(constantPool, reader);
//    }
//
//    private void readMethods() {
//        methods = MemberInfo.readMembers(constantPool, reader);
//    }
}
