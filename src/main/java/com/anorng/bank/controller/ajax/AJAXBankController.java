package com.anorng.bank.controller.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.anorng.bank.entity.BankUser;
import com.anorng.bank.entity.Link;
import com.anorng.bank.service.BankService;

/**
 * 处理 银行管理端的AJAX 请求
 * 
 * @author liuxun
 *
 */
@RestController
@RequestMapping("/bankAjax")
public class AJAXBankController {
	private final Logger log = LoggerFactory.getLogger(AJAXBankController.class);

	@Autowired
	BankService bankService;

	/**
	 * 获取所有的 证券公司名称 对应公司的ID 以及证讯的ID
	 * 
	 * @param response
	 * @param id
	 *            证讯的ID
	 * @return
	 */
	@RequestMapping("/companys")
	public Object getCompanyNameAndId(HttpServletResponse response, HttpSession session, Long id) {
		Object user = session.getAttribute("loginUser");
		if (user == null || !(user instanceof BankUser)) {
			response.setStatus(401);
			return "登录过期，请重新登录";
		}
		
		if (id == null) {
			response.setStatus(400);
			return "参数缺少证讯的ID";
		}
		
		// 获取所有的证券公司名称以及对应的公司ID
		List<Object> cNameAndIDs = bankService.findAllCompanyNameAndId();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("id", id);
		resultMap.put("companys", cNameAndIDs);
		log.info("====所有公司名称和对应ID如下 :{}",JSON.toJSONString(resultMap));
		return resultMap;
	}
	
	/**
	 * 根据证券公司的ID 获取这个公司中和当前证讯关联 以及没和任何证讯关联的链接
	 * @param response
	 * @param session
	 * @param companyId 证券公司的ID
	 * @param zxId 证讯的ID
	 * @return
	 */
	@RequestMapping("/links")
	public Object getNotRelatedToOtherZXOfCompany(HttpServletResponse response, HttpSession session, Long companyId,Long zxId) {
		Object user = session.getAttribute("loginUser");
		if (user == null || !(user instanceof BankUser)) {
			response.setStatus(401);
			return "登录过期，请重新登录";
		}
		if (companyId == null || zxId == null) {
			response.setStatus(400);
			return "参数不合法";
		}
		// 根据ID进行查询......
		List<Link> links = bankService.getNeededLinksOfCompanyByZXId(companyId,zxId);
		return links;
	}
			

}
