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


}
