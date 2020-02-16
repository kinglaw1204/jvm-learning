package top.luozhou.classfile.constant.info.impl;

import lombok.Data;
import top.luozhou.classfile.constant.info.ConstantInfo;

/**
 * @description: 模块中开放或者导出的包
 * @author: luozhou
 * @create: 2020-02-07 21:20
 **/
@Data
public class ConstantPackageInfo implements ConstantInfo {
    public final int tag = 20;
    private int nameIndex;

    @Override
    public String getValue() {
        return null;
    }
}
