package top.luozhou.classpath;

import org.junit.Test;
import top.luozhou.classpath.impl.CompositeClassEntry;
import top.luozhou.classpath.impl.DirClassEntry;
import top.luozhou.classpath.impl.WildcardClassEntry;
import top.luozhou.classpath.impl.ZipClassEntry;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EntryTest {

    @Test
    public void create() {
        assertEquals(DirClassEntry.class, ClassEntry.create(".").getClass());
        assertEquals(CompositeClassEntry.class,
                ClassEntry.create("foo.jar" + File.pathSeparator + "bar.jar").getClass());
        assertEquals(WildcardClassEntry.class, ClassEntry.create("foo/bar/*").getClass());
    }

    @Test
    public void dirEntry() throws Exception {
        String className = EntryTest.class.getName().replace('.', '/') + ".class";
        String classesDir = EntryTest.class.getResource("EntryTest.class")
                .getPath().replace(className, "");

        ClassEntry entry = ClassEntry.create(classesDir);
        assertEquals(DirClassEntry.class, entry.getClass());

        byte[] data = entry.readClass(className);
        assertNotNull(data);
    }

    @Test
    public void zipEntry() throws Exception {
        String[] cp = System.getProperty("java.class.path").split(File.pathSeparator);
        String rtJarPath = Arrays.stream(cp)
                .filter(path -> path.endsWith("/junit-4.12.jar"))
                .findFirst()
                .get();

        ClassEntry entry = ClassEntry.create(rtJarPath);
        assertEquals(ZipClassEntry.class, entry.getClass());

        byte[] data = entry.readClass("org/junit/Test.class");
        assertNotNull(data);
    }

    @Test
    public void compositeEntry() throws Exception {
        String jre ="/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home/jre";
        String classPath ="java.lang.String";
        ClassPath cp = new ClassPath(jre, classPath);

        String className = classPath.replace(".", "/");
        byte[] data = cp.readClass(className);
        assertNotNull(data);
    }

    @Test
    public void wildcardEntry() throws Exception {
        String[] cp = System.getProperty("java.class.path").split(File.pathSeparator);
        String rtJarPath = Arrays.stream(cp)
                .filter(path -> path.endsWith("/junit-4.12.jar"))
                .findFirst()
                .get()
                .replace("/junit-4.12.jar", "/*");

        ClassEntry entry = ClassEntry.create(rtJarPath);
        assertEquals(WildcardClassEntry.class, entry.getClass());

        byte[] data = entry.readClass("org/junit/Test.class");
        assertNotNull(data);
    }

}
