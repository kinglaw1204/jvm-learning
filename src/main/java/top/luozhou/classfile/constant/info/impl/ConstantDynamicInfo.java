package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 动态计算常量
 * @author: luozhou
 * @create: 2020-02-07 21:18
 **/
@Data
public class ConstantDynamicInfo  implements ConstantInfo {
    public final int tag = 17;

    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;
    @Override
    public String getValue() {
        return null;
    }
}
