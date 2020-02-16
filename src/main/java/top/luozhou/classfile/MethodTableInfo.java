package top.luozhou.classfile;

import lombok.Data;
import top.luozhou.classfile.attributes.AttributeInfo;

/**
 * @description: 方法表
 * @author: luozhou
 * @create: 2020-02-07 17:20
 **/
@Data
public class MethodTableInfo {
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private int attributesCount;
    private AttributeInfo[] attributes;

}
