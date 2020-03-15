package top.luozhou.classfile.attributes.impl;

import lombok.Getter;
import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description:
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-03-15 16:41
 **/
@Getter
public class CodeAttribute implements AttributeInfo {
    /**
     * 操作数栈的最大深度
     */

    private int maxStack;
    /**
     * 局部变量表大小
     */
    private int maxLocals;
    /**
     * 字节码
     */
    private byte[] code;
    /***
     * 子属性
     */
    private AttributeInfo[] attributes;

    private ConstantPool cp;
    /**
     * 异常处理表
     */
    private ExceptionTableEntry[] exceptionTable;

    public CodeAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        maxStack = reader.nextU2ToInt();
        maxLocals = reader.nextU2ToInt();

        //字节码
        int codeLength = reader.nextU4ToInt();
        code = reader.nextBytes(codeLength);

        //异常处理表
        exceptionTable = ExceptionTableEntry.readExceptionTable(reader);

        attributes = AttributeInfo.readAttributes(reader, cp);
    }

    static class ExceptionTableEntry {

        private int startPc;
        private int endPc;
        private int handlerPc;
        private int catchType;

        private ExceptionTableEntry(ClassReader reader) {
            this.startPc = reader.nextU2ToInt();
            this.endPc = reader.nextU2ToInt();
            this.handlerPc = reader.nextU2ToInt();
            this.catchType = reader.nextU2ToInt();
        }

        static ExceptionTableEntry[] readExceptionTable(ClassReader reader) {
            int length = reader.nextU2ToInt();
            ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[length];

            for (int i = 0; i < length; i++) {
                exceptionTable[i] = new ExceptionTableEntry(reader);
            }
            return exceptionTable;
        }
    }
}
