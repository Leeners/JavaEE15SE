<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>login page</title>
</head>
<body>
<s:property value="#request.tip"/><p>
<s:form action="Userlogin" method="post">
    <s:textfield name="loginUser.account" label="�������û���"/>
    <s:password name="loginUser.password" label="����������"/>
    <s:submit value="��¼"/>
</s:form>    
</body>
</html>