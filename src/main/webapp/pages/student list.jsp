<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<section>


		<div id="b4">
			<div id="glav2"><a href="/">На главную</a></div>

			<div id="b5">
				<ul type="none">
					<li><a href="/student-creating"><input class="input3" type = "submit" value = "Создать студента..."></a></li>

					<li><input class="input3" type = "button" value = "Модифицировать выбраного студента..." name="mod" onclick="progressStudents('modif')"></li>

				</ul>
			</div>
			<form id="firstform" method="get" action="/sudent-modify">
			<div id="b6">
				<ul type="none">
					<li><input class="input3" type = "button" value = "Просмотреть успеваемость выбраных студентов" onclick="StudentProg('prog')"></li>

					<li><input class="input3" type = "submit" value = "Удалить выбранных студентов" name="delete" onclick="deleteStudents('modif2')"></li>

				</ul>
			</div>
		</div>
		<footer id="footer1">
		
		<table id="table1" border="1" cellpadding="20" cellspacing="0" width="71%">
	<caption id="caption1">Список студентов</caption>
    <tr bgcolor="#AB814F">
        <th ></th>
        <th >Фамилия </th>
        <th>Имя</th>
        <th>Група</th>
		<th>Дата поступления</th>
    </tr>

				<c:forEach items="${students}" var="student">
			<tr bgcolor="white" height="50px">
				<td width="5%" valign="middle" align="center" ><input type="checkbox" id="${student.id}" name="studentid" value="${student.id}">
				<td width="30%" align="center">${student.surname}</td>
				<td width="30%" align="center">${student.name}</td>
				<td width="10%" align="center">${student.group}</td>
				<td align="center">${student.date}</td>
			</tr>
				</c:forEach>
			</form>

    <%--<tr bgcolor="white" height="50px">
	    <td width="5%" valign="middle" align="center"><input  type="checkbox"/></td>
        <td width="30%" align="center">Шевченко</td>
        <td width="30%" align="center">Андрей</td>
        <td width="10%" align="center">2-МП</td>
		<td align="center">12.12.12</td>
    </tr>
	<tr bgcolor="white" height="50px">
	    <td align="center" valign="middle"><input type="checkbox"/></td>
        <td align="center">Петров</td>
        <td align="center">Андрей</td>
        <td align="center">1-МП</td>
		<td align="center">12.12.12</td>
    </tr>--%>



</table>
		</footer>

</section>