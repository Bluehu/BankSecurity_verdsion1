package com.anorng.bank.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anorng.bank.core.utils.MD5Tools;
import com.anorng.bank.entity.AdminUser;
import com.anorng.bank.entity.Bank;
import com.anorng.bank.entity.BankUser;
import com.anorng.bank.entity.Certificate;
import com.anorng.bank.entity.Link;
import com.anorng.bank.entity.SecurityCompany;
import com.anorng.bank.entity.SecurityUser;

@Service
@Transactional
public class TestService {
	@PersistenceContext
	private EntityManager em;

	public void test1() {
		// 测试数据-------添加证券公司以及用户
		SecurityUser user = new SecurityUser();
		user.setAccount("2652790899@qq.com");
		user.setPassword(MD5Tools.MD5("123456"));
		user.setName("太平洋管理员1");
		SecurityUser user2 = new SecurityUser();
		user2.setAccount("12345678@qq.com");
		user2.setPassword(MD5Tools.MD5("123456"));
		user2.setName("太平洋管理员2");

		SecurityCompany company = new SecurityCompany();
		company.setName("天平洋证券有限公司");
		company.getSecurityUsers().add(user);
		company.getSecurityUsers().add(user2);
		company.setStatus(SecurityCompany.STATUS.UP);
		company.getLinks().add(new Link("www.baidu.com", "资讯描述1", company, Link.STATUS.DISABLE));
		company.getLinks().add(new Link("www.baidu.com", "资讯描述2", company, Link.STATUS.DISABLE));
		company.getLinks().add(new Link("www.baidu.com", "资讯描述3", company, Link.STATUS.DISABLE));
		company.getLinks().add(new Link("www.baidu.com", "资讯描述4", company, Link.STATUS.DISABLE));
		company.setLogo("/图层 1.png");
		user.setSecurityCompany(company);
		user2.setSecurityCompany(company);

		SecurityUser user3 = new SecurityUser();
		user3.setAccount("889969@qq.com");
		user3.setPassword(MD5Tools.MD5("123456"));
		user3.setName("IBM管理员1");
		SecurityUser user4 = new SecurityUser();
		user4.setAccount("784411@qq.com");
		user4.setPassword(MD5Tools.MD5("123456"));
		user4.setName("IBM管理员2");
		SecurityCompany company2 = new SecurityCompany();
		company2.setName("IBM证券有限公司");
		company2.getSecurityUsers().add(user3);
		company2.getSecurityUsers().add(user4);
		company2.setStatus(SecurityCompany.STATUS.UP);
		company2.getLinks().add(new Link("www.baidu.com", "资讯描述1", company2, Link.STATUS.DISABLE));
		company2.getLinks().add(new Link("www.baidu.com", "资讯描述2", company2, Link.STATUS.DISABLE));
		company2.getLinks().add(new Link("www.baidu.com", "资讯描述3", company2, Link.STATUS.DISABLE));
		company2.getLinks().add(new Link("www.baidu.com", "资讯描述4", company2, Link.STATUS.DISABLE));
		company2.setLogo("/图层 2.png");
		user3.setSecurityCompany(company2);
		user4.setSecurityCompany(company2);

		em.persist(company);
		em.persist(company2);
		System.out.println(company.getId() + "============");
		System.out.println(company2.getId() + "============");

		// 添加银行以及管理员信息
		Bank bank = new Bank();
		bank.setName("建设银行");
		BankUser bankUser = new BankUser();
		bankUser.setName("银行管理员1");
		bankUser.setAccount("89898989@qq.com");
		bankUser.setPassword(MD5Tools.MD5("123456"));
		BankUser bankUser2 = new BankUser();
		bankUser2.setName("银行管理员2");
		bankUser2.setAccount("8989874@qq.com");
		bankUser2.setPassword(MD5Tools.MD5("123456"));
		bank.getBankUsers().add(bankUser);
		bank.getBankUsers().add(bankUser2);
		bankUser.setBank(bank);
		bankUser2.setBank(bank);
		em.persist(bank);
		System.out.println(bank.getId() + "============");

		// 添加超级管理员信息
		AdminUser adminUser = new AdminUser();
		adminUser.setAccount("6933327@126.com");
		adminUser.setLogo("http://logo.com");
		adminUser.setName("刘勋");
		adminUser.setPassword(MD5Tools.MD5("123456"));
		em.persist(adminUser);
		System.out.println(adminUser.getId() + "========");
		
		// 添加证讯数据
		Certificate certificate = new Certificate();
		certificate.setName("证讯一");
		certificate.getLinks().add(company.getLinks().get(0));
		certificate.getLinks().add(company2.getLinks().get(0));
		
		Certificate certificate2 = new Certificate();
		certificate2.setName("证讯二");
		certificate2.getLinks().add(company.getLinks().get(1));
		certificate2.getLinks().add(company2.getLinks().get(1));
		
		em.persist(certificate);
		em.persist(certificate2);
		
		System.out.println(certificate.getId()+"=============");
		System.out.println(certificate2.getId()+"=============");
	}
}
