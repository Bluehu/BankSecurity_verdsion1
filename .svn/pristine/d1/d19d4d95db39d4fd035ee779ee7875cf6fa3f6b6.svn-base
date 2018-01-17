package com.anorng.bank.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anorng.bank.entity.Certificate;
import com.anorng.bank.entity.Link;
import com.anorng.bank.entity.SecurityCompany;
import com.anorng.bank.service.BankService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class BankServiceImpl implements BankService {
	private final Logger log = LoggerFactory.getLogger(BankServiceImpl.class);
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Certificate> getAllZX() {
		List<Certificate> resultList = em.createQuery("SELECT  c FROM Certificate c ", Certificate.class)
				.getResultList();
		log.info("=====获取证讯条数: {}", resultList.size());
		return resultList;
	}

	@Override
	public List<Object> findAllCompanyNameAndId() {
		List<Object> resultList = em
				.createQuery("SELECT new SecurityCompany(id,name) FROM SecurityCompany c WHERE c.status=:stat")
				.setParameter("stat", SecurityCompany.STATUS.UP).getResultList();
		return resultList;
	}

	@Override
	public List<Link> getNeededLinksOfCompanyByZXId(Long companyId, Long zxId) {
		String sql = "SELECT new Link(url,status,id) FROM Link l WHERE l MEMBER OF (SELECT ) ";
		em.createQuery(sql , Link.class);
		return null;
	}


}
