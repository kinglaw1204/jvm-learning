package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 方法句柄
 * @author: luozhou
 * @create: 2020-02-07 21:17
 **/
@Data
public class ConstantMethodHandleInfo implements ConstantInfo {
    public final int tag =15;
    private int referenceKind;
    private int referenceIndex;
    @Override
    public String getValue() {
        return null;
    }
}
