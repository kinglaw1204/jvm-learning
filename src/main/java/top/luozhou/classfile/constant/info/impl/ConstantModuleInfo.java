package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 模块
 * @author: luozhou
 * @create: 2020-02-07 21:19
 **/
@Data
public class ConstantModuleInfo implements ConstantInfo {
    public final int tag=19;
    private int nameIndex;

    @Override
    public String getValue() {
        return null;
    }
}
