package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 方法类型
 * @author: luozhou
 * @create: 2020-02-07 21:18
 **/
@Data
public class ConstantMethodTypeInfo {
    public final int tag = 16;
    private int descriptorIndex;

}
