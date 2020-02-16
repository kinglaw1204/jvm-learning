package top.luozhou.classfile;

import top.luozhou.classfile.util.ClassReader;

/**
 * @description: 属性表接口类
 * @author: luozhou
 * @create: 2020-02-07 16:54
 **/
public interface AttributeInfo {

    void readInfo(ClassReader reader);

}
