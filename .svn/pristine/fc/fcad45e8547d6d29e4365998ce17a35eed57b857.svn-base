package com.anorng.bank.service;

import java.util.List;

import com.anorng.bank.entity.Certificate;
import com.anorng.bank.entity.Link;

/**
 * 处理银行管理的业务逻辑
 * 
 * @author liuxun
 *
 */
public interface BankService {

	/**
	 * 获取所有的证讯数据
	 * 
	 * @return
	 */
	public List<Certificate> getAllZX();

	/**
	 * 获取所有证券公司的名称以及对应的主键
	 * 
	 * @return
	 */
	public List<Object> findAllCompanyNameAndId();

	/**
	 * 根据证券公司的主键获取筛选符合条件的链接
	 * @param companyId 证券公司的ID
	 * @param zxId 证讯的ID
	 * @return
	 */
	public List<Link> getNeededLinksOfCompanyByZXId(Long companyId, Long zxId);

}
