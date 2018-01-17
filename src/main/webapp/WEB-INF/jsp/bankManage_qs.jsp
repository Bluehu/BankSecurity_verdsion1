<%@page import="org.hibernate.validator.constraints.SafeHtml.Tag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>券商管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css_reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/security.css">
</head>
<body>
<div class="page security bind approval">
		<!-- 内容部分 -->
		<div class="body clearfix">
			<!-- 详细信息列表 -->
			<!-- 管理 -->
			<div class="securityContent fl">
				<div class="title">
					<div class="name fl clearfix">
						<span>名称</span>
						<input type="text">
					</div>
					<div class="search fl">
						<a href="javascript:;">查询</a>
					</div>
				</div>
				<div class="conter">
					<div class="title">
						<h3>券商信息</h3>
					</div>
					<div class="list">
						<table>
							<tbody>
							<c:forEach items="${page.items }" var="company">
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/imgs/${company.logo}" height="45" width="49" alt="">
									</td>
									<td>
										<span>${company.name }</span>
									</td>
									<td>
										<span class="grounding">${company.status eq 'UP' ? '上架':'下架'  }</span>
									</td>
									<td>
										<c:choose>
										  <c:when test="${company.status eq 'UP' }">
											<a href="/bank/disOrEnable?id=${company.id}&isEnable=false&p=${page.pageNo}" class="undercarriage">下架</a>
										  </c:when>
										  <c:otherwise>
											<a href="/bank/disOrEnable?id=${company.id}&isEnable=true&p=${page.pageNo}" class="undercarriage">上架</a>
										  </c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
								<%-- <tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 2.png" height="46" width="62" alt="">
									</td>
									<td>
										<span>中信投建</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 3.png" height="47" width="90" alt="">
									</td>
									<td>
										<span>长城证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 4.png" height="48" width="80" alt="">
									</td>
									<td>
										<span>西南证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 5.png" height="48" width="80" alt="">
									</td>
									<td>
										<span>开源证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 6.png" height="29" width="74" alt="">
									</td>
									<td>
										<span>国泰君安证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 7.png" height="34" width="94" alt="">
									</td>
									<td>
										<span>中信投建</span>
									</td>
									<td>
										<span class="undercarriage">下架</span>
									</td>
									<td>
										<a href="javascript:;" class="grounding">上架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 8.png" height="32" width="86" alt="">
									</td>
									<td>
										<span>国泰君安证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 1.png" height="45" width="49" alt="">
									</td>
									<td>
										<span>国泰君安证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr>
								<tr>
									<td class="brokerLogo">
										<img src="${pageContext.request.contextPath}/static/image/图层 2.png" height="46" width="62" alt="">
									</td>
									<td>
										<span>国泰君安证券</span>
									</td>
									<td>
										<span class="grounding">上架</span>
									</td>
									<td>
										<a href="javascript:;" class="undercarriage">下架</a>
									</td>
								</tr> --%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/security.js"></script>
</body>
</html>