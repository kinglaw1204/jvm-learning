package top.luozhou.classfile.constant.info;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.constant.info.impl.*;

/**
 * @description: 常量池类型接口
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 16:20
 **/
public interface ConstantInfo {
    int CONST_TAG_CLASS = 7;
    int CONST_TAG_FIELD_REF = 9;
    int CONST_TAG_METHOD_REF = 10;
    int CONST_TAG_INTERFACE_MTTHOD_REF = 11;
    int CONST_TAG_STRING = 8;
    int CONST_TAG_INTEGER = 3;
    int CONST_TAG_FLOAT = 4;
    int CONST_TAG_LONG = 5;
    int CONST_TAG_DOUBLE = 6;
    int CONST_TAG_NAME_AND_TYPE = 12;
    int CONST_TAG_UTF8 = 1;
    int CONST_TAG_METHOD_HANDLE = 15;
    int CONST_TAG_METHOD_TYPE = 16;
    int CONST_TAG_INVOKE_DYNAMIC = 18;
    /**
     * 获取常量信息
     * @return
     */
    String getValue();

    /**
     * @param tag 标志
     * @param reader 类解析器
     * @param constPool 常量池
     * @return
     */
    static ConstantInfo createConstantInfo(int tag, ClassReader reader, ConstantPool constPool) {
        switch (tag) {
            //数字
            case CONST_TAG_INTEGER:
                return new ConstantIntegerInfo(reader);
            case CONST_TAG_FLOAT:
                return new ConstantFloatInfo(reader);
            case CONST_TAG_LONG:
                return new ConstantLongInfo(reader);
            case CONST_TAG_DOUBLE:
                return new ConstantDoubleInfo(reader);

            case CONST_TAG_UTF8:
                return new ConstantUtf8Info(reader);

            //以下3个引用UTF8
            case CONST_TAG_STRING:
                return new ConstantStringInfo(constPool, reader);
            case CONST_TAG_CLASS:
                return new ConstantClassInfo(constPool, reader);
            case CONST_TAG_NAME_AND_TYPE:
                return new ConstantNameAndTypeInfo(constPool, reader);

            //以下3个引用CLASS+NAME_AND_TYPE
            case CONST_TAG_FIELD_REF:
                return new ConstantFieldrefInfo(constPool, reader);
            case CONST_TAG_METHOD_REF:
                return new ConstantMethodrefInfo(constPool, reader);
            case CONST_TAG_INTERFACE_MTTHOD_REF:
                return new ConstantInterfaceMethodrefInfo(constPool, reader);

            //是Java SE 7才添加到class文件中的，目的是支持新增的invokedynamic指令
            case CONST_TAG_METHOD_HANDLE:
                return null;
            case CONST_TAG_METHOD_TYPE:
                return null;
            case CONST_TAG_INVOKE_DYNAMIC:
                return null;

            default:
                throw new ClassFormatError("constant pool tag!");
        }
    }


}
