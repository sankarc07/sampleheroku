<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Security Example</title>
</head>
<body onload='document.form.username.focus();'>
	<c:if test="${param.error ne null}">
		<p>
			<font color='red'>Your login attempt was not successful, try again.<br />
			<br />Reason: Bad credentials
			</font>
		</p>
	</c:if>
	<c:if test="${param.logout ne null}">
		<p>
			<font color='green'>You have been logged out</font>
		</p>
	</c:if>
	<h3>Login with Username and Password</h3>
	<form name='form' action='/login' method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</table>
	</form>
</html>