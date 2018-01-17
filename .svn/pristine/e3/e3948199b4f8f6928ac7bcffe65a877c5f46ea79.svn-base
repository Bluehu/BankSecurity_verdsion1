package com.anorng.bank.controller.ajax;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anorng.bank.entity.Link;
import com.anorng.bank.entity.SecurityUser;
import com.anorng.bank.service.SecurityService;

/**
 * 用于处理证券公司管理的一些AJAX请求
 * @author liuxun
 *
 */
@RestController
@RequestMapping("/securityAjax")
public class AJAXSecurityController {
	
	@Autowired
	SecurityService securityService;

	/**
	 * 为证券公司添加证讯
	 * @param session
	 * @param response
	 * @param link 封装证讯参数
	 * @return
	 */
	@RequestMapping(value="/addLink",method= {RequestMethod.POST})
	public Object addLink(HttpSession session,HttpServletResponse response,Link link) {
		// 判断参数是否非空
		if (link.getUrl()==null || link.getDescription() == null) {
			response.setStatus(400);
			return "参数不能为空";
		}
		
		Object user = session.getAttribute("loginUser");
		if(user == null || !(user instanceof SecurityUser)) {
			response.setStatus(401);
			return "登录身份失效，请重新登录";
		}
		SecurityUser sUser = (SecurityUser) user;
		Boolean isSuccess = securityService.saveLinkBySecurityUser(sUser.getId(),link);
		if (!isSuccess) {
			response.setStatus(500);
			return "服务器繁忙,稍后重试";
		}
		return "添加证讯成功";
	}
}
