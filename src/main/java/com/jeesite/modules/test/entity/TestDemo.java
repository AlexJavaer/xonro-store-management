/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * test_demoEntity
 * @author Crysta-hu
 * @version 2019-03-28
 */
@Table(name="test_demo", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="sex"),
	}, orderBy="a.id DESC"
)
public class TestDemo extends DataEntity<TestDemo> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String sex;		// sex
	
	public TestDemo() {
		this(null);
	}

	public TestDemo(String id){
		super(id);
	}

	@NotBlank(message="姓名不能为空")
	@Length(min=0, max=128, message="name长度不能超过 128 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank(message="性别不能为空")
	@Length(min=0, max=128, message="sex长度不能超过 128 个字符")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}