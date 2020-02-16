package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 类或者接口符合引用
 * @author: luozhou
 * @create: 2020-02-07 21:10
 **/
@Data
public class ConstantClassInfo {
    public final int tag = 7;

    private int index;


}
