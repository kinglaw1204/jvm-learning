package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 模块中开放或者导出的包
 * @author: luozhou
 * @create: 2020-02-07 21:20
 **/
@Data
public class ConstantPackageInfo {
    public final int tag = 20;
    private int nameIndex;


}
