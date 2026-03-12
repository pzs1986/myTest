package com.eighteen.table.to.xml.entity;

import java.util.List;

import lombok.Data;

/**
 * 表数据
 * 
 * @author Flying
 * @email flying_miku@sina.com
 * @date 2016年12月20日 上午12:02:55
 */
@Data
//@ApiModel("表数据")
public class TableEntity {
	//表的名称
	//@ApiModelProperty(value="表的名称")
	private String tableName;
	
	//表的备注
	//@ApiModelProperty(value="表的备注")
	private String comments;
	
	//表的主键
	//@ApiModelProperty(value="表的主键")
	private ColumnEntity pk;
	
	//表的列名(不包含主键)
	//@ApiModelProperty(value="表的列名(不包含主键)")
	private List<ColumnEntity> columns;
	
	//类名(第一个字母大写)，如：sys_user => SysUser
	//@ApiModelProperty(value="类名(第一个字母大写)，如：sys_user => SysUser")
	private String firstUppercaseClassName;
	
	//类名(第一个字母小写)，如：sys_user => sysUser
	//@ApiModelProperty(value="类名(第一个字母小写)，如：sys_user => sysUser")
	private String firstLowercaseClassName;
	
}
