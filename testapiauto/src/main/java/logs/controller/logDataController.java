package logs.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @ClassName: logDataController
 * @Description: TODO
 * @author: 假斯文
 * @date: 2021年03月23日 10:06
 * @Version 1.0
 */

public class logDataController {

    public static void main(String[] args) {
         /*解析非classpath下的配置文件
  String log4jPath=System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties";
  PropertyConfigurator.configure(log4jPath);*/
        Logger log = LogManager.getLogger(logDataController.class);
        log.debug("调试");
        log.info("信息");
        log.warn("警告");
        log.error("错误");
        log.fatal("致命错误");
    }



}