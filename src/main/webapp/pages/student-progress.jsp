<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/student list">назад</a></div>
		</div>
	<form id="sevenform" method="post" action="/student-progress">
		<div id="text3">Отображена успеваемость для следующего студента:</div>
		<div id="table2">
			<table border="1" cellpadding="20" cellspacing="0" width="100%">
				<tr bgcolor="#AB814F">
					<th>Фамилия </th>
					<th>Имя</th>
					<th>Група</th>
					<th>Дата поступления</th>
				</tr>
				<tr bgcolor="white" height="30px">
					<td width="30%" align="center">${student.surname}</td>
					<td width="30%" align="center">${student.name}</td>
					<td width="10%" align="center">${student.group}</td>
					<td align="center">${student.date}</td>
				</tr>
			</table>
			<br/><br/>
			<div id="t2">
			<table border="1" cellpadding="20" cellspacing="0" width="100%">
				<tr bgcolor="#AB814F" height="50px">
					<th>Дисциплина</th>
					<th>Оценка</th>
				</tr>
				<c:forEach items="${discipline}" var="discipline">
				<tr bgcolor="white" height="50px">
					<td >${discipline.disciplinename}</td>
					<td width="30%" align="center">5</td>
				</tr>
				</c:forEach>
			</table>
			</div>
			
			<div id="pole2">
			<label>Выбрать семестр</label>
			<select id="sel" name = "choice">
				<c:forEach items="${terms}" var="term">
					<option id="${term.id}" value="${term.id}">Семестр ${term.id}</option>
				</c:forEach>
			</select>
			<input class="input2" id="but1" type="submit" value="Выбрать" title="Выбрать"/>
			<br/><br/>
			<p id="p1">Средняя оценка за семестр: </p>
			</div>

		</div>
	</form>
	</section>
