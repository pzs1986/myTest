package com.eighteen.table.to.xml.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.eighteen.table.to.xml.util.JdbcUtils;


/**
 * 代码生成器
 * 
 * @author Flying
 * @email flying_miku@sina.com
 * @date 2016年12月19日 下午3:32:04
 */
public class SysGeneratorDao {
	
	
	public Map<String, String> queryTable(String tableName) throws SQLException{
		 
		 JdbcUtils jdbcUtils = new JdbcUtils();  
        jdbcUtils.getConnection();  
        Map<String, String> result = jdbcUtils.findSimpleResult("select table_name tableName, engine,table_type tableType, table_comment tableComment, create_time createTime from information_schema.tables  where table_schema = (select database()) and table_name = ?", Arrays.asList(new Object[]{tableName})); 
        jdbcUtils.releaseConn();
        return result;
	}
	
	public List<Map<String, String>> queryColumns(String tableName) throws SQLException{
		 JdbcUtils jdbcUtils = new JdbcUtils();  
	     jdbcUtils.getConnection();  
		 List<Map<String, String>> result = jdbcUtils.findModeResult("select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns where table_name = ? and table_schema = (select database()) order by ordinal_position", Arrays.asList(new Object[]{tableName})); 
		 jdbcUtils.releaseConn();
		 return result;
	}
}
