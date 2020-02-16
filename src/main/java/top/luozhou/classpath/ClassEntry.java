package top.luozhou.classpath;

import top.luozhou.classpath.impl.CompositeClassEntry;
import top.luozhou.classpath.impl.DirClassEntry;
import top.luozhou.classpath.impl.WildcardClassEntry;
import top.luozhou.classpath.impl.ZipClassEntry;
import top.luozhou.common.CommonStringConstant;

import java.io.File;

/**
 * @description: 类文件入口接口类，定义如何去查找类
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 16:55
 **/
public interface ClassEntry {


    /**
     *  读取类字节信息
     * @param className
     * @return
     * @throws Exception
     * @author luozhou kinglaw1204@gmail.com
     */
    byte[] readClass(String className) throws Exception;

    /**
     * 静态工厂方法，根据路径创建合适的类查找入口
     * @author luozhou kinglaw1204@gmail.com
     * @param path
     * @return
     */
    static ClassEntry create(String path) {
        if (path.contains(File.pathSeparator)) {
            return new CompositeClassEntry(path);
        }
        if (path.endsWith(CommonStringConstant.COMMON_STAR)) {
            return new WildcardClassEntry(path);
        }
        if (path.endsWith(CommonStringConstant.LOWR_JAR) || path.endsWith(CommonStringConstant.UPPER_JAR) ||
                path.endsWith(CommonStringConstant.LOWR_ZIP) || path.endsWith(CommonStringConstant.UPPER_ZIP)) {
            return new ZipClassEntry(path);
        } else {
            return new DirClassEntry(path);
        }
    }
}
