/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.gen.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 代码生成表Entity
 * @author alex
 * @version 2019-03-21
 */
@Table(name="${_prefix}gen_table", alias="a", columns={
		@Column(name="table_name", attrName="tableName", label="表名", isPK=true),
		@Column(name="class_name", attrName="className", label="实体类名称", queryType=QueryType.LIKE),
		@Column(name="comments", attrName="comments", label="表说明"),
		@Column(name="parent_table_name", attrName="parentTableName", label="关联父表的表名", queryType=QueryType.LIKE),
		@Column(name="parent_table_fk_name", attrName="parentTableFkName", label="本表关联父表的外键名", queryType=QueryType.LIKE),
		@Column(name="tpl_category", attrName="tplCategory", label="使用的模板"),
		@Column(name="package_name", attrName="packageName", label="生成包路径", queryType=QueryType.LIKE),
		@Column(name="module_name", attrName="moduleName", label="生成模块名", queryType=QueryType.LIKE),
		@Column(name="sub_module_name", attrName="subModuleName", label="生成子模块名", queryType=QueryType.LIKE),
		@Column(name="function_name", attrName="functionName", label="生成功能名", queryType=QueryType.LIKE),
		@Column(name="function_name_simple", attrName="functionNameSimple", label="生成功能名", comment="生成功能名（简写）", queryType=QueryType.LIKE),
		@Column(name="function_author", attrName="functionAuthor", label="生成功能作者"),
		@Column(name="gen_base_dir", attrName="genBaseDir", label="生成基础路径"),
		@Column(name="options", attrName="options", label="其它生成选项"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class GenTable extends DataEntity<GenTable> {
	
	private static final long serialVersionUID = 1L;
	private String tableName;		// 表名
	private String className;		// 实体类名称
	private String comments;		// 表说明
	private String parentTableName;		// 关联父表的表名
	private String parentTableFkName;		// 本表关联父表的外键名
	private String tplCategory;		// 使用的模板
	private String packageName;		// 生成包路径
	private String moduleName;		// 生成模块名
	private String subModuleName;		// 生成子模块名
	private String functionName;		// 生成功能名
	private String functionNameSimple;		// 生成功能名（简写）
	private String functionAuthor;		// 生成功能作者
	private String genBaseDir;		// 生成基础路径
	private String options;		// 其它生成选项
	
	public GenTable() {
		this(null);
	}

	public GenTable(String id){
		super(id);
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@NotBlank(message="实体类名称不能为空")
	@Length(min=0, max=100, message="实体类名称长度不能超过 100 个字符")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@NotBlank(message="表说明不能为空")
	@Length(min=0, max=500, message="表说明长度不能超过 500 个字符")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Length(min=0, max=64, message="关联父表的表名长度不能超过 64 个字符")
	public String getParentTableName() {
		return parentTableName;
	}

	public void setParentTableName(String parentTableName) {
		this.parentTableName = parentTableName;
	}
	
	@Length(min=0, max=64, message="本表关联父表的外键名长度不能超过 64 个字符")
	public String getParentTableFkName() {
		return parentTableFkName;
	}

	public void setParentTableFkName(String parentTableFkName) {
		this.parentTableFkName = parentTableFkName;
	}
	
	@Length(min=0, max=200, message="使用的模板长度不能超过 200 个字符")
	public String getTplCategory() {
		return tplCategory;
	}

	public void setTplCategory(String tplCategory) {
		this.tplCategory = tplCategory;
	}
	
	@Length(min=0, max=500, message="生成包路径长度不能超过 500 个字符")
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	@Length(min=0, max=30, message="生成模块名长度不能超过 30 个字符")
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Length(min=0, max=30, message="生成子模块名长度不能超过 30 个字符")
	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	
	@Length(min=0, max=200, message="生成功能名长度不能超过 200 个字符")
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	@Length(min=0, max=50, message="生成功能名长度不能超过 50 个字符")
	public String getFunctionNameSimple() {
		return functionNameSimple;
	}

	public void setFunctionNameSimple(String functionNameSimple) {
		this.functionNameSimple = functionNameSimple;
	}
	
	@Length(min=0, max=50, message="生成功能作者长度不能超过 50 个字符")
	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}
	
	@Length(min=0, max=1000, message="生成基础路径长度不能超过 1000 个字符")
	public String getGenBaseDir() {
		return genBaseDir;
	}

	public void setGenBaseDir(String genBaseDir) {
		this.genBaseDir = genBaseDir;
	}
	
	@Length(min=0, max=1000, message="其它生成选项长度不能超过 1000 个字符")
	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
}