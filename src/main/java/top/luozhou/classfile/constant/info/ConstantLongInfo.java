package top.luozhou.classfile.constant.info;

import lombok.Data;

/**
 * @description: 长型字面量
 * @author: luozhou
 * @create: 2020-02-07 17:58
 **/
@Data
public class ConstantLongInfo {
    public final int tag = 5;

    private long bytes;


}
