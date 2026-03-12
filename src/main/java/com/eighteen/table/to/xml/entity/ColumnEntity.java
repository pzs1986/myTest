package com.eighteen.table.to.xml.entity;

import lombok.Data;

/**
 * 列的属性
 * 
 * @author Flying
 * @email flying_miku@sina.com
 * @date 2016年12月20日 上午12:01:45
 */
@Data
//@ApiModel("列的属性")
public class ColumnEntity {
	//列名
	//@ApiModelProperty(value="列名")
    private String columnName;
	
    //列名类型
	//@ApiModelProperty(value="列名类型")
    private String dataType;
	
    //列名备注
	//@ApiModelProperty(value="列名备注")
    private String comments;
    
    //属性名称(第一个字母大写)，如：user_name => UserName
    //@ApiModelProperty(value="属性名称(第一个字母大写)，如：user_name => UserName")
    private String firstUppercaseAttrName;
	
    //属性名称(第一个字母小写)，如：user_name => userName
	//@ApiModelProperty(value="属性名称(第一个字母小写)，如：user_name => userName")
    private String firstLowercaseAttrName;
	
    //属性类型
	//@ApiModelProperty(value="属性类型")
    private String attrType;
	
    //auto_increment
	//@ApiModelProperty(value="auto_increment")
    private String extra;
}
