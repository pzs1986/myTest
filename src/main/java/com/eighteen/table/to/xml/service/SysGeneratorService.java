package com.eighteen.table.to.xml.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;

import com.eighteen.table.to.xml.dao.SysGeneratorDao;
import com.eighteen.table.to.xml.util.GenUtils;


/**
 * 代码生成器
 * 
 * @author Flying
 * @email flying_miku@sina.com
 * @date 2016年12月19日 下午3:33:38
 */
public class SysGeneratorService {

	public Map<String, String> queryTable(String tableName) throws SQLException {
		SysGeneratorDao sysGeneratorDao = new SysGeneratorDao();
		return sysGeneratorDao.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) throws SQLException {
		SysGeneratorDao sysGeneratorDao = new SysGeneratorDao();
		return sysGeneratorDao.queryColumns(tableName);
	}

	public String generatorCode(String[] tableNames) throws SQLException, IOException {
		File f= new File(System.getProperties().getProperty("user.home") + File.separator +System.currentTimeMillis() +".zip") ;    // 声明File对象
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for(String tableName : tableNames){
			//查询表信息
			Map<String, String> table = queryTable(tableName);
			//查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		OutputStream out = new FileOutputStream(f)  ;  
        
        IOUtils.write(outputStream.toByteArray(), out); 
        out.close();
        
        return f.getPath();
	}
}
