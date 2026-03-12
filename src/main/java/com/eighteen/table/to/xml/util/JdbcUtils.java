package com.eighteen.table.to.xml.util;  
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.texen.Generator;

import com.eighteen.table.to.xml.GeneratorTable;  
  
  
  
public class JdbcUtils {  
   
    private Connection connection;  
    private PreparedStatement pstmt;  
    private ResultSet resultSet;  
    public JdbcUtils() {  
        // TODO Auto-generated constructor stub  
        try{  
            Class.forName(GeneratorTable.DRIVER);  
        }catch(Exception e){  
  
        }  
    }  
      
    /** 
     * 获得数据库的连接 
     * @return 
     */  
    public Connection getConnection(){  
        try {  
            connection = DriverManager.getConnection(GeneratorTable.URL, GeneratorTable.USERNAME, GeneratorTable.PASSWORD);  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return connection;  
    }  
  
      
    /** 
     * 查询单条记录 
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */  
    public Map<String, String> findSimpleResult(String sql, List<Object> params) throws SQLException{  
        Map<String, String> map = new HashMap<String, String>();  
        pstmt = connection.prepareStatement(sql);  
        if(params != null && !params.isEmpty()){  
            for(int i=0; i<params.size(); i++){  
                pstmt.setObject(i+1, params.get(i));  
            }  
        }  
        resultSet = pstmt.executeQuery();//返回查询结果  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int col_len = metaData.getColumnCount();  
        while(resultSet.next()){  
            for(int i=0; i<col_len; i++ ){  
                String cols_name = metaData.getColumnLabel(i+1);  
                String cols_value = resultSet.getString(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
        }  
        return map;  
    }  
  
    /**查询多条记录 
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     */  
    public List<Map<String, String>> findModeResult(String sql, List<Object> params) throws SQLException{  
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();  
        pstmt = connection.prepareStatement(sql);  
        if(params != null && !params.isEmpty()){  
            for(int i = 0; i<params.size(); i++){  
                pstmt.setObject(i+1, params.get(i));  
            }  
        }  
        resultSet = pstmt.executeQuery();  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while(resultSet.next()){  
            Map<String, String> map = new HashMap<String, String>();  
            for(int i=0; i<cols_len; i++){  
                String cols_name = metaData.getColumnLabel(i+1);  
                String cols_value = resultSet.getString(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
            list.add(map);  
        }  
  
        return list;  
    }  
  
    /** 
     * 释放数据库连接 
     */  
    public void releaseConn(){  
    	try{  
	        if(resultSet != null){  
	                resultSet.close();  
	        } 
	        if(pstmt != null){  
	        	pstmt.close();  
        } 
	        if(connection!=null){
				connection.close();
	        }
    	}catch(SQLException e){  
    		e.printStackTrace();  
    	}  
       
    }  
}  