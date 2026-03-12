package com.eighteen.table.to.xml;

import java.io.IOException;
import java.sql.SQLException;

import com.eighteen.table.to.xml.service.SysGeneratorService;

/**
 * 代码生成器主入口
 * 用于根据数据库表结构自动生成 Java 代码
 *
 * @author Flying
 * @email flying_miku@sina.com
 */
public class GeneratorTable {

    /** 数据库用户名 */
    public static final String USERNAME = "agent_poc";

    /** 数据库密码 */
    public static final String PASSWORD = "n3aZyhOce+dR0Yxz";

    /** 数据库驱动类名 */
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    /** 数据库连接地址 */
    public static final String URL = "jdbc:mysql://10.74.8.2:3306/ai_talker?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";

    /**
     * 主方法：执行代码生成
     * @param args 命令行参数
     * @throws IOException IO 异常
     * @throws SQLException SQL 异常
     */
    public static void main(String[] args) throws IOException, SQLException {
        // 指定要生成代码的表名数组
        String[] tableNames = new String[]{"ai_talker_call_request","ai_talker_share_info","t_restaurant_reservation_push"};

        // 创建代码生成服务实例
        SysGeneratorService sysGeneratorService = new SysGeneratorService();

        // 执行代码生成并获取生成文件的路径
        String filePath = sysGeneratorService.generatorCode(tableNames);

        // 输出文件生成信息
        System.out.println("文件已生成，文件目录："+filePath);
    }

}
