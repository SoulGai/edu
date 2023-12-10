package top.testeru.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.apache.commons.lang.StringUtils;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: edu
 * @author: 盖盖
 * @description: 自动生成
 * @Date: 2023/12/10
 */
public class CodeGenerate {
    //promotion_ad

    public static void main(String[] args) {

        //jdbc 路径
        String url = "jdbc:mysql://127.0.0.1:3306/edu_ad?characterEncoding=UTF-8&useUnicode=true&useSSL=false&serverTimezone=GMT";
        String username = "edu";
        String password = "Toturial@#2023";
        String author = "gai";
        // 指定输出目录
        String outputDir = "src/main/java/top/testeru/ad/mapper";


        //设置 mapperXml 生成路径
        String mapperXmlPath = "top.testeru.ad.mapper";
        //设置父包名
        String parentPkg = "top.testeru.ad.mapper";
        //设置父包模块名
        String moduleName = "top.testeru.ad.mapper";
        // 设置需要生成的表名
        String tableName = "promotion_ad";
        //String tableName = "promotion_space";

        FastAutoGenerator
                //基础配置
                .create(new DataSourceConfig.Builder(url, username, password))
                // 全局配置
                .globalConfig(
                        (scanner, builder) -> builder
                                //指定输出目录
                                //.outputDir()
                                //作者名
                                .author(scanner.apply("请输入作者名称？"))
                                //	开启 kotlin 模式
                                //.enableKotlin()
                                //开启 swagger 模式
                                .enableSwagger()
                                //时间策略
                                //.dateType(DateType.TIME_PACK)
                                //注释日期
                                //.commentDate("yyyy-MM-dd")
                                //
                                .fileOverride()
                )
                // 包配置
                .packageConfig(
                        (scanner, builder) -> builder
                                //父包名
                                .parent(scanner.apply("请输入父包名："))
                                //父包模块名
                                //.moduleName(scanner.apply("请输入父包模块名："))
                                //entity包名
                                .entity("po")
                                //service包名
                                .service("service")
                                //serviceImpl包名
                                .serviceImpl("service.impl")
                                //Mapper包名
                                .mapper("mapper")
                                //mapper XML包名
                                .xml("mapper.xml")
                                //controller包名
                                .controller("controller")
                                //自定义文件包名
                                //.other("other")
                                //路径配置信息
                                //.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://"))
                )
                // 策略配置
                .strategyConfig(
                        (scanner, builder) -> builder
                                .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                                .controllerBuilder()
                                //开启生成@RestController 控制器，false
                                .enableRestStyle()
                                //开启驼峰转连字符，false
                                .enableHyphenStyle()
                                //实体策略配置
                                .entityBuilder()
                                //开启 lombok 模型，false
                                .enableLombok()
                                //添加表字段填充
                                .addTableFills(
                                        new Column("create_time", FieldFill.INSERT)
                                )
                                .build()

                                //开启大写命名，false
                                //.enableCapitalMode()
                                //开启跳过视图，false
                                //.enableSkipView()
                                //禁用 sql 过滤	true
                                //.disableSqlFilter()
                                //模糊表匹配(sql 过滤)	 likeTable 与 notLikeTable 只能配置一项
                                //.likeTable(new LikeTable("USER"))
                                //增加表匹配(内存过滤)	支持正则匹配、例如 ^t_.* 所有 t_ 开头的表名
                                //.addInclude("t_simple")
                                //增加过滤表前缀
                                //.addTablePrefix("t_", "c_")
                                //增加过滤字段后缀
                                //.addFieldSuffix("_flag")

                )

                    //模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   //.templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())

                .execute();



    }
    // 处理 all 情况
    static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
