package top.luozhou.model;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import lombok.Data;

/**
 * @description: 参数实体类
 * @author: luozhou kinglaw1204@gmail.com
 * @create: 2020-02-17 20:47
 **/
@Data
public class Args {
    @Parameter(names = {"-?", "-help"}, description = "print help message", order = 3, help = true)
    private boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version and exit", order = 2)
    private boolean versionFlag = false;

    @Parameter(names = {"-cp", "-classpath"}, description = "classpath", order = 1)
    private String classpath;

    /**
     * jre目录
     */
    @Parameter(names = "-jre", description = "path to jre", order = 4)
   private String jre;


    private boolean ok;



    public  static Args parse(String[] argv) {
        Args args = new Args();
        JCommander cmd = JCommander.newBuilder()
                .addObject(args)
                .build();
        try {
            cmd.parse(argv);
            args.setOk(true);
        } catch (ParameterException ignored) {
           //忽略异常
        }

        return args;
    }
}
