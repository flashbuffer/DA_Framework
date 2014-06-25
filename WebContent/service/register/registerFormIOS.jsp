<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="注册,登记">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

	<h3>注册</h3> <br>
	  
	<table>
		<tr><td>用户名称</td>		<td><input type="text" /></td></tr>
        <tr><td>密码</td>		<td><input type="password" id="password"/></td></tr>
        <tr><td>再次输入密码</td>	<td><input type="password"/></td></tr>
        <tr><td>电话号码</td>		<td><input type="text" /></td></tr>
        <tr><td>电子邮件</td>		<td><input type="text" /></td></tr>
	</table>
  
    <input type="button" value="注册" onclick="register();"/>
	<input type="button" value="取消"/>
	
	<script>
	    function register(){
	    	;
	    }
	</script>
  </body>
</html>
