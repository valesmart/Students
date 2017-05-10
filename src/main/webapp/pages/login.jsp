<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<div id="login">
	<form action="/login" method="post">

		<table id="login_table" cellpadding="20" cellspacing="0" width="100%" >
			<tr height="50px">
				<td colspan="2" class="caption" align="center">Вход</td>
			</tr >
			<tr height="50px">
				<td width="30%">Имя:</td>
				<td><input  type="text" name="username" value="" align="center" /></td>
			</tr >
			<tr height="50px">
				<td>Пароль:</td>
				<td><input  type="password" name="password" align="center"/></td>
			</tr>
			<tr height="50px">
				<td>Выбрать роль:</td>

				<td><select name="role" id="opening_list" align="center">
					<c:forEach items="${roles}" var="role">
						<option value="${role.id}">${role.name}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr height="50px">
				<td></td>
				<td><input id="b10" type="submit" value="войти" id="button" align="center"></td>
			</tr>
			</table>
		<jsp:include page="/modules/validationMessage.jsp" />

	</form>
</div>

	<div align="right" style="position: fixed; right: 20px; bottom: 0px;">
		<p>Тестовые аккаунты: "admin / password" , "student / password"</p>
		<p>Аккаунт "admin" поддерживает обе роли</p>
	</div>
	</section>