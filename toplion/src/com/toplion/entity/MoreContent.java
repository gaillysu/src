package com.toplion.entity;

/**
 * 更多
 * @author Ayres
 *
 */
public class MoreContent {
	
	/*
	 * 案例名字及简介、案例截图
	 * */
	private Integer casenameid;
	private Integer casepic;
	
	
	private Integer wuda;
	private Integer logo;
	private Integer weWeima;
	private Integer lianxi;
	private String wangzhi;
	private String wangzhis;
	public String getWangzhis() {
		return wangzhis;
	}
	public void setWangzhis(String wangzhis) {
		this.wangzhis = wangzhis;
	}
	private Integer yuanjing;
	private Integer yuanjings;
	private String gongsi;
	private String gongsis;
	public Integer getWuda() {
		return wuda;
	}
	public void setWuda(Integer wuda) {
		this.wuda = wuda;
	}
	public Integer getLogo() {
		return logo;
	}
	public void setLogo(Integer logo) {
		this.logo = logo;
	}
	public Integer getWeWeima() {
		return weWeima;
	}
	public void setWeWeima(Integer weWeima) {
		this.weWeima = weWeima;
	}
	public Integer getLianxi() {
		return lianxi;
	}
	public void setLianxi(Integer lianxi) {
		this.lianxi = lianxi;
	}
	public String getWangzhi() {
		return wangzhi;
	}
	public void setWangzhi(String wangzhi) {
		this.wangzhi = wangzhi;
	}
	public Integer getYuanjing() {
		return yuanjing;
	}
	public void setYuanjing(Integer yuanjing) {
		this.yuanjing = yuanjing;
	}
	public Integer getYuanjings() {
		return yuanjings;
	}
	public void setYuanjings(Integer yuanjings) {
		this.yuanjings = yuanjings;
	}
	public String getGongsi() {
		return gongsi;
	}
	public void setGongsi(String gongsi) {
		this.gongsi = gongsi;
	}
	public String getGongsis() {
		return gongsis;
	}
	public void setGongsis(String gongsis) {
		this.gongsis = gongsis;
	}
	public MoreContent(Integer wuda, Integer logo, Integer weWeima, Integer lianxi,
			String wangzhi,String wangzhis, Integer yuanjing, Integer yuanjings, String gongsi,
			String gongsis) {
		super();
		this.wuda = wuda;
		this.logo = logo;
		this.weWeima = weWeima;
		this.lianxi = lianxi;
		this.wangzhi = wangzhi;
		this.wangzhis=wangzhis;
		this.yuanjing = yuanjing;
		this.yuanjings = yuanjings;
		this.gongsi = gongsi;
		this.gongsis = gongsis;
	}
	public MoreContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCasenameid() {
		return casenameid;
	}
	public void setCasenameid(Integer casenameid) {
		this.casenameid = casenameid;
	}
	public Integer getCasepic() {
		return casepic;
	}
	public void setCasepic(Integer casepic) {
		this.casepic = casepic;
	}

	
}
