<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="utf-8" %>
<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/terms-list">назад</a></div>
		</div>
		<div id="text1">Для создания семестра заполните следующие данные и нажмите кнопку "Создать":</div>
		<div id="pole3">
			<form id="forform" method="post" action="/term-creating">
			<label for="semestr">Длительность (в неделях)</label>
			<input class="input2" type="text"  name="semestr" title="Введите длительность семестра"
			maxlength="30" id="semestr" width="50%"/>
			<br/><br/>
			<label id="label1" for="semestr">Дисциплины в семестре</label>

			<select class="vse" id="sel1" size="5" multiple="multiple" name = "choice">
				<c:forEach items="${disciplines}" var="discipline">
				<option id="${discipline.id1}" value="${discipline.id1}">${discipline.disciplinename}</option>
				</c:forEach>
			</select>


			<br/><br/><br/><br/><br/><br/>
			<input class="input2" id="but2" type="submit" value="Создать" title="Создать" <%--onclick="termCreate('create')--%>"/>
			</form>
			<jsp:include page="/modules/validationMessage.jsp" />
		</div>
</section>