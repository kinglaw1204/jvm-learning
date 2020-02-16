package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 字符类型字面量
 * @author: luozhou
 * @create: 2020-02-07 21:11
 **/
@Data
public class ConstantStringInfo {
    public final int tag = 8;

    private String index;


}
