package top.luozhou.classfile.attributes;

import top.luozhou.classfile.util.ClassReader;

/**
 * @description: 属性表接口类
 * @author: luozhou
 * @create: 2020-02-07 16:54
 **/
public interface AttributeInfo {

    /** 读取字节信息
     * @param reader
     */
    void readInfo(ClassReader reader);

}
