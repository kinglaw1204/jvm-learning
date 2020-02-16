package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 动态方法调用点
 * @author: luozhou
 * @create: 2020-02-07 21:19
 **/
@Data
public class ConstantInvokeDynamicInfo  implements ConstantInfo {
    public final int tag = 18;
    public int bootstrapMethodAttrIndex;
    public int nameAndTypeIndex;
    @Override
    public String getValue() {
        return null;
    }
}
