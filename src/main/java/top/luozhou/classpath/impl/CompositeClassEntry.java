package top.luozhou.classpath.impl;

import top.luozhou.classpath.ClassEntry;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合模式class入口，一次扫描多个类
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 22:10
 **/
public class CompositeClassEntry implements ClassEntry {
    private final List<ClassEntry> entries = new ArrayList<>();

    public CompositeClassEntry(String pathList) {
        for (String path : pathList.split(File.pathSeparator)) {
            entries.add(ClassEntry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className) throws Exception {

        for (ClassEntry entry : entries) {
            try {
                return entry.readClass(className);
            } catch (Exception ignored) {
            }
        }

        throw new Exception("class not found: " + className);
    }

}
