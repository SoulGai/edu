package top.testeru.edu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//启动类

@SpringBootApplication
//启用配置服务器的功能。配置服务器允许将应用程序的配置集中管理，以便在分布式系统中更容易地维护和更新配置。
//配置服务器从远程存储库（如 Git）中提供配置信息，以供其他微服务应用程序检索。其他微服务通过使用 spring.cloud.config 配置属性来连接到配置服务器，并获取其需要的配置。
@EnableConfigServer
public class EduConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduConfigApplication.class, args);
    }

}
