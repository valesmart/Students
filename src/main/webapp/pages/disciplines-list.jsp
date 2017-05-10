<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<section>


		<div id="glav">
			<a href="/">На главную</a>
		</div>
		<div id="text" >Список дисциплин</div>
		<div id="table">
			<div id="t2">
			<table border="1" cellpadding="20" cellspacing="0" width="100%">
				<tr bgcolor="#AB814F" height="50px">
					<th></th>
					<th >Наименование дисциплин</th>
				</tr>


				<form id="twoform" method="get" action="/discipline-modify">
					<c:forEach items="${disciplines}" var="discipline">
						<tr>
						<td valign="middle" align="center" width="10%" bgcolor="white" height="50px"><input type="checkbox" id="${discipline.id1}" name="disid" value="${discipline.id1}">
						<td bgcolor="white" height="50px">${discipline.disciplinename}</td>
						</tr>
					</c:forEach>
				</form>
				<%--<tr bgcolor="white" height="50px">
					<td valign="middle" align="center" width="10%" ><input class="checkbox" type="checkbox"/></td>
					<td width="90%" align="center">Высшая математика</td>
				</tr>
				<tr bgcolor="white" height="50px">
					<td valign="middle" align="center" width="10%" ><input class="checkbox" type="checkbox"/></td>
					<td width="90%" align="center">Информатика</td>
				</tr>--%>
			</table>
			</div>
			<div id="pole2">
				<%--<a href="/discipline-creating"><input class="but2" type="button" value="Создать дисциплину" title="Создать"/></a>--%>
					<input class="but2" type="button" value="Создать дисциплину" title="Создать" onclick="location.href='/discipline-creating'"/>
			<br/><br/>
				<input class="but2"  type="button" value="Модифицировать выбранную дисцыплину..." title="Модифицировать" onclick="disciplines('modif')" />
			<br/><br/>
			<input class="but2" type="submit" value="Удалить выбранную дисцыплину..." title="Удалить" name="delete" onclick="pageDisciplines('modif1')"/>
			</div>

		</div>
		
	</section>