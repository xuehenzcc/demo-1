/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月17日
 */
package com.example.demo.vo;

import java.util.Date;

/**
 * @author c0z00k8
 *
 */
public class UserVO {

	private int id;
	private String name;
	private String desc;
	private Date createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
