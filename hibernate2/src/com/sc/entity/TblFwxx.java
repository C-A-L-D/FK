package com.sc.entity;

import java.sql.Timestamp;

/**
 * TblFwxx entity. @author MyEclipse Persistence Tools
 */

public class TblFwxx implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "TblFwxx [fwid=" + fwid + ", uid=" + uid + ", jdid=" + jdid + ", lxid=" + lxid + ", shi=" + shi
				+ ", ting=" + ting + ", fwxx=" + fwxx + ", zj=" + zj + ", title=" + title + ", date=" + date
				+ ", telephone=" + telephone + ", lxr=" + lxr + "]";
	}

	private Integer fwid;
	private Integer uid;
	private Integer jdid;
	private Integer lxid;
	private String shi;
	private String ting;
	private String fwxx;
	private Long zj;
	private String title;
	private Timestamp date;
	private String telephone;
	private String lxr;

	
	//扩展属性(只是为了方便传值，不用改toString)
	private Long zj1;
	private Long zj2;
	private Integer[] lxids;
	public Long getZj1() {
		return zj1;
	}

	public void setZj1(Long zj1) {
		this.zj1 = zj1;
	}

	public Long getZj2() {
		return zj2;
	}

	public void setZj2(Long zj2) {
		this.zj2 = zj2;
	}

	public Integer[] getLxids() {
		return lxids;
	}

	public void setLxids(Integer[] lxids) {
		this.lxids = lxids;
	}

	
	// Constructors

	/** default constructor */
	public TblFwxx() {
	}

	/** full constructor */
	public TblFwxx(Integer uid, Integer jdid, Integer lxid, String shi, String ting, String fwxx, Long zj, String title,
			Timestamp date, String telephone, String lxr) {
		this.uid = uid;
		this.jdid = jdid;
		this.lxid = lxid;
		this.shi = shi;
		this.ting = ting;
		this.fwxx = fwxx;
		this.zj = zj;
		this.title = title;
		this.date = date;
		this.telephone = telephone;
		this.lxr = lxr;
	}

	// Property accessors

	public Integer getFwid() {
		return this.fwid;
	}

	public void setFwid(Integer fwid) {
		this.fwid = fwid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getJdid() {
		return this.jdid;
	}

	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}

	public Integer getLxid() {
		return this.lxid;
	}

	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}

	public String getShi() {
		return this.shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getTing() {
		return this.ting;
	}

	public void setTing(String ting) {
		this.ting = ting;
	}

	public String getFwxx() {
		return this.fwxx;
	}

	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}

	public Long getZj() {
		return this.zj;
	}

	public void setZj(Long zj) {
		this.zj = zj;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

}