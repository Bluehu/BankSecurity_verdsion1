package com.anorng.bank.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 证券公司提供的链接 相关信息 也就是资讯
 * 
 * @author liuxun
 *
 */
@Entity
@Table(name = "link")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;

	public Link() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100)
	private String url; // 对应的链接

	@Column(length = 100)
	private String description; // 链接对应的描述

	@Column
	private Date createTime;

	@ManyToOne
	@JoinColumn(name = "securitycompany_id")
	private SecurityCompany securityCompany;

	@Enumerated(EnumType.STRING)
	private STATUS status;

	public enum STATUS {
		ENABLE, DISABLE, CHOOSED // 禁用 启用 被选中 只有启用的Link才可以被选中
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SecurityCompany getSecurityCompany() {
		return securityCompany;
	}

	public void setSecurityCompany(SecurityCompany securityCompany) {
		this.securityCompany = securityCompany;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Link(String url, String desc, SecurityCompany securityCompany, STATUS status) {
		this.url = url;
		this.description = desc;
		this.securityCompany = securityCompany;
		this.status = status;
	}

	public Link(String url, STATUS status,Long id) {
		super();
		this.url = url;
		this.status = status;
		this.id = id;
	}
	
	

}
