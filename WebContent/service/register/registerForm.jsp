<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html ng-app>
  <head>
   	<script src="<%=path%>/js/angular.js"></script>
	<script src="<%=path%>/js/angular-resource.js"></script>
	
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
	<div ng-controller="RegisterController">  
		<table>
			<tr><td>名称</td>		<td><input type="text" ng-model="user.name" placeholder="你的名称"/></td></tr>
	        <tr><td>密码</td>		<td><input type="password" ng-model="user.password"  placeholder="密码"/></td></tr>
	        <tr><td>再次输入密码</td>	<td><input type="password"   ng-model="user.password2"   placeholder="再次输入密码"/></td></tr>
	        <tr><td>电话号码</td>		<td><input type="text"  ng-model="user.telNumber"  placeholder="电话号码" /></td></tr>
	        <tr><td>电子邮件</td>		<td><input type="text"  ng-model="user.email" ng-model="user.number"  placeholder="电子邮件"/></td></tr>
		</table>
  
	    <input type="button" value="注册" ng-click="register();"/>
		<input type="button" value="取消" ng-click="cancel();"/>
	
	    <br>
	    <p>{{registerFlag}} <p>
	</div>
	
	<script>
		// And this controller definition
	    function RegisterController($scope, $http) {
	    	$scope.register = function() {
	    	    
		    	var registerCallback = $http.post("<%=path%>/register/doRegister", $scope.user);
					
				registerCallback.success(function(data, status, headers, config) {
					    $scope.data = data;
					    console.log(data);
					    if (data.result.flag){
					    	$scope.registerFlag = "注册成功";
					    }else{
					        $scope.registerFlag = "对不起，填入的信息有误";
					    }
					    
				});
					
				registerCallback.error(function(data, status, headers, config) {
					    console.log(data);
					    $scope.registerFlag = data.result.flag;
				});
		    };
		    	
		    $scope.cancel= function() {
		    	alert("To do.");
		    };
		    $scope.cancel= function() {
		    	alert("To do.");
		    };
	    }
	   
	
	</script>
  </body>
</html>
