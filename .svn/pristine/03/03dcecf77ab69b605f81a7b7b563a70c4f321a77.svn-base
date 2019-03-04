package com.wangbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan({"com.wangbo.*.mapper","com.wangbo.*.*.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("\n" +
                "                                                      .-'''-.             \n" +
                "                                                     '   _    \\          \n" +
                "                        _..._             /|       /   /` '.   \\         \n" +
                "       _     _        .'     '.   .--./)  ||      .   |     \\  '         \n" +
                " /\\    \\\\   //       .   .-.   . /.''\\\\   ||      |   '      |  '    \n" +
                " `\\\\  //\\\\ //  __    |  '   '  || |  | |  ||  __  \\    \\     / /    \n" +
                "   \\`//  \\'/.:--.'.  |  |   |  | \\`-' /   ||/'__ '.`.   ` ..' /        \n" +
                "    \\|   |// |   \\ | |  |   |  | /(\"'`    |:/`  '. '  '-...-'`         \n" +
                "     '     `\" __ | | |  |   |  | \\ '---.  ||     | |                    \n" +
                "            .'.''| | |  |   |  |  /'\"\"'.\\ ||\\    / '                  \n" +
                "           / /   | |_|  |   |  | ||     |||/\\'..' /                      \n" +
                "           \\ \\._,\\ '/|  |   |  | \\'. __// '  `'-'`                    \n" +
                "            `--'  `\" '--'   '--'  `'---'                                 \n" +
                "            (♥◠‿◠)ﾉﾞ  网博启动成功   ლ(´ڡ`ლ)ﾞ  "                         );
    }
}