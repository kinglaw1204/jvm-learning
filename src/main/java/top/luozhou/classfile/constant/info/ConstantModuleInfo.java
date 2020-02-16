package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 模块
 * @author: luozhou
 * @create: 2020-02-07 21:19
 **/
@Data
public class ConstantModuleInfo {
    public final int tag=19;
    private int nameIndex;


}
