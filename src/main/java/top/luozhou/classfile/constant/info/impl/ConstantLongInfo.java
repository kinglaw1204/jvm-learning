package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 长型字面量
 * @author: luozhou
 * @create: 2020-02-07 17:58
 **/
@Data
public class ConstantLongInfo  implements ConstantInfo {
    public final int tag = 5;

    private long bytes;

    @Override
    public String getValue() {
        return null;
    }
}
