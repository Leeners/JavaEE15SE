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
�޸ĸ�����Ϣ<p>
<s:form action="Userupdate" method="post">
    <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
    <s:textfield name="loginUser.account" label="�û��������޸�" value="%{#request.loginUser.account}" readonly="true"/>
    <s:textfield type="password" name="loginUser.password" label="�޸�����" value="%{#request.loginUser.password}"/>
    <s:textfield type="password" name="loginUser.repassword" label="���ٴ���������" value="%{#request.loginUser.password}"/>
    <s:textfield name="loginUser.name" label="�޸���ʵ����" value="%{#request.loginUser.name}"/>
    <s:radio name="loginUser.sex" list="#{1 : '��', 0 : 'Ů'}" label="�޸��Ա�" value="%{#request.loginUser.sexStr}"/>
    <sx:datetimepicker name="loginUser.birthday" displayFormat="yyyy-mm-dd" label="�޸�����" value="%{#request.loginUser.birthday}"/> 
    <s:textfield name="loginUser.phone" label="�޸���ϵ�绰" value="%{#request.loginUser.phone}"/>
    <s:textfield name="loginUser.email" label="�޸ĵ�������" value="%{#request.loginUser.email}"/>
    <s:textfield name="loginUser.address" label="�޸���ϵ��ַ" value="%{#request.loginUser.address}"/>
    <s:textfield name="loginUser.zipcode" label="�޸���������" value="%{#request.loginUser.zipcode}"/>
    <s:textfield name="loginUser.fax" label="�޸Ĵ������" value="%{#request.loginUser.fax}"/>
    <s:submit value="�޸�"/>
</s:form>

<s:form action="Userdelete" method="post">
	<s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>
	<s:submit value="ɾ��"/>
</s:form>
<a href="./allItems">�鿴������Ʒ��Ϣ</a><br>
</body>
</html>