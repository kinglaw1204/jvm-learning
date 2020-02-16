package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 双精度浮点型字面量
 * @author: luozhou
 * @create: 2020-02-07 21:10
 **/
@Data
public class ConstantDoubleInfo {
    public final int tag = 6;
    private double bytes;

}
