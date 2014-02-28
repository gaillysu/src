package com.toplion.entity;

/**
 * 解决方案
 * 
 * @author Ayres
 * 
 */
public class FangAn {
	// z政策
	private Integer zhengce;
	// 文字信息
	private String wenzis;
	// 特色服务
	private Integer fuwu;
	// 图文解决方案
	private Integer fangan;

	public Integer getZhengce() {
		return zhengce;
	}

	public void setZhengce(Integer zhengce) {
		this.zhengce = zhengce;
	}

	public String getWenzis() {
		return wenzis;
	}

	public void setWenzis(String wenzis) {
		this.wenzis = wenzis;
	}

	public Integer getFuwu() {
		return fuwu;
	}

	public void setFuwu(Integer fuwu) {
		this.fuwu = fuwu;
	}

	public Integer getFangan() {
		return fangan;
	}

	public void setFangan(Integer fangan) {
		this.fangan = fangan;
	}

	public FangAn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FangAn(Integer zhengce, String wenzis, Integer fuwu, Integer fangan) {
		super();
		this.zhengce = zhengce;
		this.wenzis = wenzis;
		this.fuwu = fuwu;
		this.fangan = fangan;
	}

}
