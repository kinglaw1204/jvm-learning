package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description:整型字面量
 * @author: luozhou
 * @create: 2020-02-07 17:56
 **/
@Data
public class ConstantIntegerInfo {
    public final int tag = 3;

    private int bytes;


}
