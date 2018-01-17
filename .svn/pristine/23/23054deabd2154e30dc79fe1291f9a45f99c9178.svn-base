package com.anorng.bank.service;

import java.util.List;

import com.anorng.bank.core.utils.Page;
import com.anorng.bank.entity.Link;
import com.anorng.bank.entity.SecurityCompany;
import com.anorng.bank.entity.SecurityUser;

public interface SecurityService {
	/**
	 * 分页获取证券公司的数据
	 * 
	 * @param p
	 *            页码
	 * @return
	 */
	public Page<SecurityCompany> queryCompanyByPage(Integer p);

	/**
	 * 禁用或启用证券公司
	 * 
	 * @param id
	 * @param isEnable
	 * @return
	 */
	public Boolean disOrEnableSecurity(Long id, Boolean isEnable);

	/**
	 * 
	 * @param id
	 *            证券公司管理员的id
	 * @param link
	 *            要向证券公司添加的link
	 * @return
	 */
	public Boolean saveLinkBySecurityUser(Long id, Link link);

	/**
	 * 根据证券公司管理员的ID查询最新的管理员信息
	 * 
	 * @param id
	 * @return
	 */
	public SecurityUser getSecurityUserById(Long id);

	/**
	 * 根据证券公司管理员的ID 查询该公司的所有证讯数据
	 * 
	 * @param id
	 * @return
	 */
	public List<Link> findLinksofCompanyByUserId(Long id);

	/**
	 * 根据ID查询证讯
	 * 
	 * @param id
	 * @return
	 */
	public Link findLinkById(Long id);

	/**
	 * 删除证讯
	 * 
	 * @param link
	 */
	public void delZX(Link link);

	/**
	 * 判断该证券公司是否有链接被证讯关联
	 * 
	 * @param id
	 *            证券公司的主键
	 * @return
	 */
	public Boolean isZXRelatedToCompany(Long id);
}
