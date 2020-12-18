<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <meta charset="utf-8">
	  <title>下载页面</title>
	  <link rel="stylesheet" type="text/css" href="../css/download.css" />
  </head>
	
  <body>
   <c:forEach items="${downloadList}" var="download">
   	  <div id="box">
   			  <div id="box_top">
   				  ${download.resourceName} 
   			  </div>
				  
   			  <div id="box_left">
   				  <img src="../${download.image}"  style="width:100%;"/>
   			  </div>
   			  
   			  <div id="box_center">
   				  <div id="box_center_top">
   					 <p> ${download.description} </p>
   				  </div>
   				  
   				  <div id="box_center_bottom">
   					  <p id="time">时间: ${download.time}&nbsp </p>
					  <p id="size">大小: ${download.size}kb&nbsp </p>
					  <p id="star_size">星级:</p>
					  <p id="star" style="background-position-x: ${-(5-download.star)*30}px;"></p>
					  
   				  </div>
   			  </div>
			  <div id="box_right">
				  <a id="a1" href="DownloadController.do?id=${download.resourceId}">点击下载</a>
			  </div>
   	  </div>
	 </c:forEach>
  </body>
</html>
