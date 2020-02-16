package top.luozhou.classpath.impl;

import top.luozhou.classpath.ClassEntry;

import java.nio.file.*;

/**
 * @description: 压缩文件class入口
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 22:14
 **/
public class ZipClassEntry implements ClassEntry {
    private Path absPath;

    public ZipClassEntry(String path) {
        absPath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        try (FileSystem zipFs = FileSystems.newFileSystem(absPath, null)) {
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

}
