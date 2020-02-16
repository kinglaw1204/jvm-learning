package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 方法句柄
 * @author: luozhou
 * @create: 2020-02-07 21:17
 **/
@Data
public class ConstantMethodHandleInfo {
    public final int tag =15;
    private int referenceKind;
    private int referenceIndex;

}
