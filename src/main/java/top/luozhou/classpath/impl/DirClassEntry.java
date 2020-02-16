package top.luozhou.classpath.impl;

import top.luozhou.classpath.ClassEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: 文件夹形式class入口
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 22:14
 **/
public class DirClassEntry implements ClassEntry {
    private Path absPath;

    public DirClassEntry(String path) {
        absPath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absPath.resolve(className));
    }
}
