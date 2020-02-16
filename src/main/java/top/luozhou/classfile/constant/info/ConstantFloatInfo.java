package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 浮点型字面量
 * @author: luozhou
 * @create: 2020-02-07 17:57
 **/
@Data
public class ConstantFloatInfo {
    public final int tag = 4;

    private float bytes;

}
