package top.luozhou.classpath;

import top.luozhou.classpath.impl.WildcardClassEntry;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @description: 类文件路径查找
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 22:34
 **/
public class ClassPath {
    private static final String JAVA_HOME = "JAVA_HOME";
    private static final String JRE = "jre";
    private static final String LIB = "lib";
    private static final String EXT = "ext";
    private static final String JREPATH = "./jre";
    private static final String CLASS_SUFIX = ".class";
    /**
     * 启动类的class
     */
    private ClassEntry bootClasspath;
    /**
     * 扩展类的class
     */
    private ClassEntry extClasspath;
    /**
     * 普通类的class
     */
    private ClassEntry userClasspath;

    public ClassPath(String jreOption, String cpOption) {
        parseBootAndExtClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    /**
     * 解析根路径和扩展类的class路径
     */
    private void parseBootAndExtClasspath(String jreOption) {
        String jreDir = getJreDir(jreOption);

        // jre/lib/*
        String jreLibPath = Paths.get(jreDir, LIB) + File.separator + "*";
        bootClasspath = new WildcardClassEntry(jreLibPath);

        // jre/lib/ext/*
        String jreExtPath = Paths.get(jreDir, LIB, EXT) + File.separator + "*";
        extClasspath = new WildcardClassEntry(jreExtPath);
    }

    private static String getJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }
        if (Files.exists(Paths.get(JREPATH))) {
            return JREPATH;
        }
        String jh = System.getenv(JAVA_HOME);
        if (jh != null) {
            return Paths.get(jh, JRE).toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }

    private void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = ClassEntry.create(cpOption);
    }


    public byte[] readClass(String className) throws Exception {
        className = className + CLASS_SUFIX;

        try {
            return bootClasspath.readClass(className);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        try {
            return bootClasspath.readClass(className);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        return userClasspath.readClass(className);
    }


    public static String join(String... paths) {
        return Arrays.stream(paths)
                .collect(Collectors.joining(File.pathSeparator));
    }

    public static String[] split(String pathList) {
        return pathList.split(File.pathSeparator);
    }
}
