<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>证讯管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css_reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/securityManage.css">
</head>
<body>
	<div class="page security bind approval">
		<!-- 头部标题 -->
		<div class="header clearfix">
			<div class="title fl clearfix">
				<i class="icon_logo fl"></i>
				<h1 class="fl">证讯业务开发互联平台</h1>
			</div>
			<div class="userName fl">
				<a href="jacascript:;" class="clearfix">
					<i class='icon_user fl'></i>
					<span class="fl">${sessionScope.loginUser.name }</span>
				</a>
			</div>
			<div class="logOut fr"><a  href="/logout">退出</a></div>
		</div>
		<!-- 内容部分 -->
		<div class="body clearfix">
			<!-- 导航条 -->
			<div class="nav fl">
				<div class="nav-box">
					<ul id="nav-box">
						<li class="active">
							<i class="icon_manage"></i>
							<a href="javascript:void(0);"  onclick="toMain('/bank/manage_qs')">券商管理</a>
						</li>
						<li>
							<i class="icon_approval"></i>
							<a href="javascript:void(0);"  onclick="toMain('/bank/manage_sp')">证讯审批</a>
						</li>
						<li>
							<i class="icon_bind"></i>
							<a href="javascript:void(0);" onclick="toMain('/bank/manage_bd')">证讯绑定</a>
						</li>
						<li></li>
					</ul>
				</div>
			</div>
			<!-- 详细信息列表 -->
			<!-- 管理 -->
			<div class="securityContent fl">
				<iframe src="/bank/manage_qs" id="mainF" frameborder="0" name="mainFrame"></iframe>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/security.js"></script>
	<script type="text/javascript">
	  function toMain(link){
		  $("#mainF").attr('src',link);
	  };
	</script>
</body>
</html>