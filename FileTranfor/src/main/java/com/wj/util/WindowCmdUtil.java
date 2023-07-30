package com.wj.util;
import com.google.common.base.Joiner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 执行windows命令
 */
public class WindowCmdUtil {


    /**
     * 获取操作系统默认语言

     */
    private static String getsystemLanguage() {
        return null == System.getProperty("sun.jnu.encoding") ? "GBK"
                : System.getProperty("sun.jnu.encoding");
    }


    /**
     * cmd执行多条命令
     *
     */
    public static String executeCmd(List<String> cmds) {
        try {
            String cmdBin = "cmd /c ";
            String cmdStr = Joiner.on("&&").join(cmds);
            Process process = Runtime.getRuntime().exec(cmdBin + cmdStr);
            String result = getExecResult(process);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行单条命令
     *
     * @param cmd
     * @return
     */
    public static String executeCmd(String cmd) {
        try {
            String cmdBin = "cmd /c ";
            Process process = Runtime.getRuntime().exec(cmdBin + cmd);
            String result = getExecResult(process);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getExecResult(Process process) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName(getsystemLanguage())));
        String result = "";
        String line;
        while ((line = br.readLine()) != null) {
            result += line;
        }
        return result;
    }


}