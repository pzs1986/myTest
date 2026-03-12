package com.eighteen.table.to.xml;

import java.io.IOException;
import java.sql.SQLException;

import com.eighteen.table.to.xml.service.SysGeneratorService;


public class GeneratorTable {
	
	 //数据库用户名  
    public static final String USERNAME = "agent_poc";
    //数据库密码  
    public static final String PASSWORD = "n3aZyhOce+dR0Yxz";
    //驱动信息   
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    //数据库地址  
    public static final String URL = "jdbc:mysql://10.74.8.2:3306/ai_talker?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
	
	
	
	public static void main(String[] args) throws IOException, SQLException {
		String[] tableNames = new String[]{"ai_talker_call_request","ai_talker_share_info","t_restaurant_reservation_push"};
		SysGeneratorService sysGeneratorService = new SysGeneratorService();
		String filePath = sysGeneratorService.generatorCode(tableNames);
		System.out.println("文件已生成,文件目录："+filePath);
	}
				
}

