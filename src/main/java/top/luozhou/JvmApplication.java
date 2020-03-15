package top.luozhou;

import top.luozhou.classfile.ClassFile;
import top.luozhou.classfile.ConstantPool;
import top.luozhou.classfile.FieldTableInfo;
import top.luozhou.classfile.MethodTableInfo;
import top.luozhou.classfile.constant.info.ConstantInfo;
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
            ClassFile classFile = new ClassFile(classData);
            printClassInfo(classFile);
        } catch (Exception e) {
            System.out.println("Could not find or load  class " +args.getClasspath());
        }
    }
    private static void printClassInfo(ClassFile cf) {
        System.out.println("version: "+ cf.getMajorVersion()+"."+cf.getMinorVersion());

        ConstantPool constantPool = cf.getConstantPool();
        ConstantInfo[] constantInfos = constantPool.getConstantInfos();
        System.out.println("constants count: "+ constantPool.getConstantPoolSize());
        for(int i = 1; i < constantPool.getConstantPoolSize() ; i++) {

            if(constantInfos[i]!=null){
                System.out.println(i+": "+constantInfos[i]);
            }
        }


        System.out.format("access flags: 0x%x\n", cf.getAccessFlag());
        System.out.println("this class: "+ constantPool.getUTF8(cf.getClassNameIndex()));
        System.out.println("super class: "+ constantPool.getUTF8(cf.getSuperClassNameIndex()));
        System.out.println("interfaces: "+cf.getInterfaceIndexes().length);
        FieldTableInfo[] fields = cf.getFields();
        System.out.println("fields count: "+ fields.length);
        for (FieldTableInfo fieldTableInfo : fields) {
            System.out.format("  %s\n", constantPool.getUTF8(fieldTableInfo.getNameIndex()));
        }

        MethodTableInfo[] methods = cf.getMethods();
        System.out.println("methods count: "+ methods.length);
        for (MethodTableInfo methodTableInfo : methods) {
            System.out.format("  %s\n", constantPool.getUTF8(methodTableInfo.getNameIndex()));
        }

    }
}
