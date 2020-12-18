<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <meta charset="utf-8">
    <title>出错啦！</title>
	<link rel="stylesheet" type="text/css" href="/work2/css/error.css" />
	<script >
	window.setInterval(changeLeaveTime, 1000);
	function changeLeaveTime(){
		var time=parseInt(document.getElementById("leaveTime").innerText);
		time=time-1;
		if(time==0){
			window.location.href="/work2/login.html";
		}
		else{
			document.getElementById("leaveTime").innerText=time;
		}
	}
	</script> 

  </head>
  
  <body>
	  <div id="boxleft">
		 <!-- <img src="../images/error_left1.png" id="tupian" /> -->
		 <img src="/work2/images/error_left2.png" id="tupian" />
	  </div>
	  
	  <div id="boxright">
		  <p id="inf">${info}!</p>
		  <p id="size">
		  	<span id="leaveTime">10 </span>秒后自动回到登录页面	
		  </p>
		  <p id="size">
		  	不能跳转，请<a href="/work2/login.html"  id="ppp">点击这里</a>
		  </p>
	  </div>
		
  </body>
</html>
