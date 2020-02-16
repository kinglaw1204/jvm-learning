package top.luozhou.classpath.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-16 22:13
 **/
public class WildcardClassEntry extends CompositeClassEntry {

    public WildcardClassEntry(String path) {
        super(toPathList(path));
    }

    private static String toPathList(String wildcardPath) {
        try {
            return Files.walk(Paths.get(wildcardPath.replace("*", "")))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
