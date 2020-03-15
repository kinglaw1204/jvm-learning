package top.luozhou.classfile.attributes;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.attributes.impl.*;

/**
 * @description: 属性表接口类
 * @author: luozhou
 * @create: 2020-02-07 16:54
 **/
public interface AttributeInfo {

    /**
     * 读取字节信息
     *
     * @param reader
     */
    void readInfo(ClassReader reader);

    static AttributeInfo[] readAttributes(ClassReader reader, ConstantPool cp) {
        int attributesCount = reader.nextU2ToInt();
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];

        for (int i = 0; i < attributesCount; i++) {
            attributes[i] = readAttribute(reader, cp);
        }

        return attributes;
    }

    static AttributeInfo readAttribute(ClassReader reader, ConstantPool cp) {
        int attrNameIndex = reader.nextU2ToInt();
        String attrName = cp.getUTF8(attrNameIndex);
        long attrLen = reader.nextU4ToInt();
        AttributeInfo attributeInfo = newAttributeInfo(attrName, attrLen, cp);
        attributeInfo.readInfo(reader);
        return attributeInfo;
    }

    static AttributeInfo newAttributeInfo(String attrName, long attrLen, ConstantPool cp) {
        switch (attrName) {
            //method属性
            case "Code":
                //方法体
                return new CodeAttribute(cp);
            //field属性
            case "ConstantValue":
                //常量表达式的值  存常量池索引
                return new ConstantValueAttribute();
            //method属性
            case "Exceptions":
                //变长属性，记录方法抛出的异常表
                return new ExceptionsAttribute();
            //以下3是调试信息 不一定要 使用javac编译器编译Java程序时，默认会在class文件中生成 这些信息
            //  method属性的Code属性的属性
            //方法行号
            case "LineNumberTable":
                return new LineNumberTableAttribute();
            //  method属性的Code属性的属性
            //方法局部变量
            case "LocalVariableTable":
                return new LocalVariableTableAttribute();
            //class属性
            //源文件名 如 XXX.java
            case "SourceFile":
                return new SourceFileAttribute(cp);
            //最简单的两种属性，仅起标记作用，不包含任何数据。
            //ClassFile、field_info和method_info都可以用
            //为了支持嵌套类和嵌套接口
            case "Synthetic":
                return new SyntheticAttribute();
            //废弃标记
            case "Deprecated":
                return new DeprecatedAttribute();
            //不支持
            default:
                return new UnparsedAttribute(attrName, (int) attrLen);
        }
    }

}
