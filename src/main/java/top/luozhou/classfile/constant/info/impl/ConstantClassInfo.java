package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 类或者接口符合引用
 * @author: luozhou
 * @create: 2020-02-07 21:10
 **/
@Data
public class ConstantClassInfo implements ConstantInfo {
    public final int tag = 7;

    private int index;


    public String getValue() {
        return null;
    }
}
