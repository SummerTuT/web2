<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>个人中心</title>
		<link rel="stylesheet" type="text/css" href="/work2/css/main.css" />
		
	</head>
	<body>
		<div id="header">
			<div id="header_tupian"><img src="/work2/images/bilibili.png"  /></div>
			<div id="header_word">
				<div id="p">
					<p >当前用户:${currentUser}  <a href="/work2/servlet/logout.do" id="header_p_a">[安全退出]</a></p>
				</div>
				<div id="con">
				
					<div id="li">
						<a href="#" class="a1">首页</a>
					</div>
					<div id="li">
						<a href="/work2/UserControl.jsp" class="a1">用户管理</a>
					</div>
					<div id="li">
						<a href="/work2/ResourceControl.jsp" class="a1">资源管理</a>
					</div>
					
					<div id="li">
						<a href="/work2/servlet/GetDownloadListController.do" class="a1">资源下载</a>
					</div>
					
					
					<div id="li">
						<a href="/work2/PersonalCenter.jsp" class="a1">个人中心</a>
					</div>
					
				
				</div>

			</div>
			
		</div>
		
		
		<div id="center">
		</div>
		<div id="element"><img src="/work2/images/main.jpg" /></div>
		<p>建设中..............</p>
	</body>
</html>