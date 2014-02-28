package com.toplion.entity;

public class HomeContent {
private Integer yanJIuyuan;
private String contentOfCompany;
private Integer youShi;
private Integer yuan;
private Integer jing;
public Integer getYanJIuyuan() {
	return yanJIuyuan;
}
public void setYanJIuyuan(Integer yanJIuyuan) {
	this.yanJIuyuan = yanJIuyuan;
}
public String getContentOfCompany() {
	return contentOfCompany;
}
public void setContentOfCompany(String contentOfCompany) {
	this.contentOfCompany = contentOfCompany;
}
public Integer getYouShi() {
	return youShi;
}
public void setYouShi(Integer youShi) {
	this.youShi = youShi;
}
public Integer getYuan() {
	return yuan;
}
public void setYuan(Integer yuan) {
	this.yuan = yuan;
}
public Integer getJing() {
	return jing;
}
public void setJing(Integer jing) {
	this.jing = jing;
}
public HomeContent() {
	super();
	// TODO Auto-generated constructor stub
}
public HomeContent(Integer yanJIuyuan, String contentOfCompany,
		Integer youShi, Integer yuan, Integer jing) {
	super();
	this.yanJIuyuan = yanJIuyuan;
	this.contentOfCompany = contentOfCompany;
	this.youShi = youShi;
	this.yuan = yuan;
	this.jing = jing;
}
}
