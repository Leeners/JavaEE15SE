<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<s:property value="#request.tip"/><p>

<hr>
<table>
<tr><td>������Ϣ��<p></td></tr>
<tr><td>�û�����</td><td><s:property value="#request.loginUser.account" /></td></tr>
<tr><td>���룺</td><td><s:property value="#request.loginUser.password"/></td><tr>
<tr><td>��ʵ������</td><td><s:property value="#request.loginUser.name"/></td><tr>
<tr><td>�Ա�</td><td>
<s:if test="#request.loginUser.sex">
	<s:text name="������"/>
</s:if>
<s:else>
	<s:text name="Ůʿ��"/>
</s:else>
</td><tr>
<tr><td>�������ڣ�</td><td><s:property value="#request.loginUser.birthday" /> </td><tr>
<tr><td>�������䣺</td><td><s:property value="#request.loginUser.email"/></td><tr>
<s:if test="#request.loginUser.address">
	<s:form action="UserdelAddr" method="post">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<tr><td>��ϸ��ַ��</td><td><s:property value="#request.loginUser.address.detail" /></td><tr>
    <tr><td>�������룺</td><td><s:property value="#request.loginUser.address.zipcode" /></td><tr>
    <tr><td>��ϵ�绰��</td><td><s:property value="#request.loginUser.address.phone" /></td><tr>
    <tr><td>��ַ���ͣ�</td><td><s:property value="#request.loginUser.address.type" /></td><tr>
    <tr><td><s:submit value="ɾ��	"/></td><tr>
    </s:form>
</s:if>
<s:else>
	����µ�ַ��<p>
	<s:form action="UseraddAddr" method="post">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<s:textfield name="address.detail" label="��ϸ��ַ" />
	<s:textfield name="address.zipcode" label="��������" />
	<s:textfield name="address.phone" label="��ϵ�绰" />
	<s:textfield name="address.type" label="��ַ���ͣ���ͥ����˾�ȣ�" />
    <s:submit value="���"/>
	</s:form>
</s:else>

</table>


<a href="./allItems">�鿴������Ʒ��Ϣ</a><br>
</body>
</html>