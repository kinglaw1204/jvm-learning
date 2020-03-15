package top.luozhou.classfile.attributes.impl;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description:
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-03-15 16:49
 **/
public class LineNumberTableAttribute implements AttributeInfo {

    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader reader) {
        int length = reader.nextU2ToInt();

        lineNumberTable = new LineNumberTableEntry[length];

        for (int i = 0; i < length; i++) {
            lineNumberTable[i] = new LineNumberTableEntry(reader);
        }
    }

    private static class LineNumberTableEntry {
        private final int startPc;
        private final int lineNumber;

        public LineNumberTableEntry(ClassReader reader) {
            startPc = reader.nextU2ToInt();
            lineNumber = reader.nextU2ToInt();
        }
    }
}
