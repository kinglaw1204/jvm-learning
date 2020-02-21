package top.luozhou;

import top.luozhou.classfile.ClassReader;
import top.luozhou.classpath.ClassPath;
import top.luozhou.model.Args;

import java.util.Arrays;

/**
 * @description: 启动类
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-17 20:21
 **/
public class JvmApplication {
    public static void main(String[] args) {
        Args argsObj = Args.parse(args);
        if (!argsObj.isOk() || argsObj.isHelpFlag()) {
            System.out.println("Usage: <main class> [-options] class [args...]");
        } else if (argsObj.isVersionFlag()) {
            System.out.println("java version \"1.8.0\"");
        } else {
            startJVM(argsObj);
        }
    }

    private static void startJVM(Args args) {
        ClassPath cp = new ClassPath(args.getJre(), args.getClasspath());

        String className = args.getClasspath().replace(".", "/");
        try {
            byte[] classData = cp.readClass(className);
            System.out.println("class data: " + Arrays.toString(classData));
            ClassReader reader = new ClassReader(classData);
           // ClassFile classFile = reader.parseClassFile();
            System.out.println("class data:" + Arrays.toString(classData));
        } catch (Exception e) {
            System.out.println("Could not find or load  class " +args.getClasspath());
        }
    }
}
