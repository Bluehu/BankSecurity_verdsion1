package com.anorng.bank.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.anorng.bank.core.config.Global;
import com.anorng.bank.core.utils.Page;
import com.anorng.bank.entity.Link;
import com.anorng.bank.entity.SecurityCompany;
import com.anorng.bank.entity.SecurityUser;
import com.anorng.bank.service.SecurityService;

@Service
@Transactional
public class SecurityServiceImpl implements SecurityService {
	private final Logger log = LoggerFactory.getLogger(SecurityServiceImpl.class);
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<SecurityCompany> queryCompanyByPage(Integer p) {

		// 数据的总条数
		Long totalSize = (Long) em.createNamedQuery("querySecurityCompanyCount").getSingleResult();

		TypedQuery<SecurityCompany> query = em.createNamedQuery("querySecurityCompany", SecurityCompany.class);
		// 当前要查询的下标位置
		Integer offset = (p - 1) * Global.pageSize;
		query.setFirstResult(offset);
		query.setMaxResults(Global.pageSize);
		List<SecurityCompany> resultList = query.getResultList();

		Page<SecurityCompany> page = new Page<>(p, Global.pageSize, totalSize.intValue());
		page.setItems(resultList);
		log.info("分页证券公司信息={}", JSON.toJSONString(page));
		return page;
	}

	@Override
	public Boolean disOrEnableSecurity(Long id, Boolean isEnable) {
		SecurityCompany company = em.find(SecurityCompany.class, id);
		if (company == null) {
			return false;
		}
		company.setStatus(isEnable ? SecurityCompany.STATUS.UP : SecurityCompany.STATUS.DOWN);
		em.persist(company);
		return true;
	}

	@Override
	public Boolean saveLinkBySecurityUser(Long id, Link link) {
		SecurityUser securityUser = em.find(SecurityUser.class, id);
		if (securityUser == null) {
			return false;
		}
		SecurityCompany securityCompany = securityUser.getSecurityCompany();
		link.setStatus(Link.STATUS.DISABLE);
		link.setCreateTime(new Date());
		link.setSecurityCompany(securityCompany);
		securityCompany.getLinks().add(link);

		em.persist(securityCompany);
		return true;
	}

	@Override
	public SecurityUser getSecurityUserById(Long id) {
		return em.find(SecurityUser.class, id);
	}

	@Override
	public List<Link> findLinksofCompanyByUserId(Long id) {
		SecurityUser securityUser = em.find(SecurityUser.class, id);
		TypedQuery<Link> query = em.createQuery(
				"SELECT new Link(url,status,id) FROM Link l WHERE :sUser member of l.securityCompany.securityUsers",
				Link.class);
		query.setParameter("sUser", securityUser);
		return query.getResultList();
	}

	@Override
	public Link findLinkById(Long id) {
		return em.find(Link.class, id);
	}

	@Override
	public void delZX(Link link) {
		em.remove(link);
	}

	@Override
	public Boolean isZXRelatedToCompany(Long id) {
		SecurityCompany company = em.find(SecurityCompany.class, id);
		Query query = em.createQuery(
				"SELECT COUNT(c) FROM Certificate c WHERE EXISTS (SELECT l FROM Link l WHERE l MEMBER OF c.links AND EXISTS (SELECT cp FROM SecurityCompany cp WHERE l MEMBER OF cp.links AND cp =:company))");
		query.setParameter("company", company);
		Long count = (Long) query.getSingleResult();
		return count > 0 ? true : false;
	}

}
