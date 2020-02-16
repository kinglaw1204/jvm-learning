package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 动态计算常量
 * @author: luozhou
 * @create: 2020-02-07 21:18
 **/
@Data
public class ConstantDynamicInfo {
    public final int tag = 17;

    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

}
