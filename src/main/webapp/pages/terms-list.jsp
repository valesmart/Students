<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="utf-8" %>
<section>

		<div id="glav">
			<a href="/">На главную</a>
		</div>
		<form id="forform" method="post" action="/terms-list">
		<div id="text4">
		<label >Выбрать семестр</label>
			<select name = "choice">

				<c:forEach items="${terms}" var="term">
					<option id="${term.id}" value="${term.id}">Семестр ${term.id}</option>
				</c:forEach>
			</select>
			<input id="but3" type="submit" value="Выбрать" title="Выбрать"/>
			<br/><br/>
		<p>Длительность семестра: ${term.duration} недели</p>
		<br/>
		<p>Список дисциплин семестра</p>
		</div>
			<div id="table3">

			<div id="t2">
			<table border="1" cellpadding="20" cellspacing="0" width="100%">
				<tr bgcolor="#AB814F" height="50px">
					<th align="left">Наименование дисциплин</th>
				</tr>
					<c:forEach items="${discipline}" var="discipline">
				<tr bgcolor="white" height="50px">
					<td>${discipline.disciplinename}</td>
				</tr>
				</c:forEach>



				</tr>
				<%--<tr bgcolor="white" height="50px">
					<td align="left">Информатика</td>
				</tr>--%>
			</table>
				<jsp:include page="/modules/validationMessage.jsp" />
			</div>



			<div id="pole2">
				<a href="/term-creating"><input class="but4" type="button" value="Создать семестр" title="Создать"/></a>
			<br/><br/>
				<input class="but4" name="modterm" type="submit" value="Модифицировать текущий семестр..." title="Модифицировать" onclick="termModif('modif3')"/>
			<br/><br/>
			<input class="but4" name="termDelete" type="submit" value="Удалить текущий семестр..." title="Удалить" onclick="termDelete('mod')"/>
			</div>

		</div>
		</form>
		</form>

</section>