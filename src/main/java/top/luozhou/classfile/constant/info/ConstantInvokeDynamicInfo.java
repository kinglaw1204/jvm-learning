package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 动态方法调用点
 * @author: luozhou
 * @create: 2020-02-07 21:19
 **/
@Data
public class ConstantInvokeDynamicInfo {
    public final int tag = 18;
    public int bootstrapMethodAttrIndex;
    public int nameAndTypeIndex;

}
