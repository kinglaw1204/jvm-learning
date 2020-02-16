package top.luozhou.classpath;

/**
 * @description: 类文件入口接口类，定义如何去查找类
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 16:55
 **/
public interface ClassEntry {

    /**
     * 读取类文件的二进制数据
     * className: 类的全路径，比如xx/xxx/xx.class
     *
     * @author luozhou kinglaw1204@gmail.com
     * @date 2020/2/16 4:56 PM
     */
    byte[] readClass(String className) throws Exception;
}
