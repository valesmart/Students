<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="utf-8" %>
<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/terms-list">назад</a></div>
		</div>
		<div id="text1">Для модификации семестра отредактируйте данные и нажмите кнопку "Применить":</div>
		<div id="pole3">
			<form id="fiveform" method="get" action="/term-modify">
			<label id="label1" for="termod">Длительность (в неделях)</label>
			<input class="input2" type="text" value=${term.duration} name="termod" title="Введите длительность димцыплины"
			maxlength="30" id="termod" width="50%"/>
			<br/><br/>
			<label for="termod">Дисциплины в семестре</label>
			<select id="sel1" size="4" multiple="multiple" name = "choice">
				<c:forEach items="${discipline}" var="discipline">
					<option id="${discipline.id1}" value="${discipline.id1}">${discipline.disciplinename}</option>
				</c:forEach>
			</select>
			<br/><br/><br/><br/>
			<input class="input2" id="but2" type="submit" value="Применить" title="Применить"/>
			</form>
			<jsp:include page="/modules/validationMessage.jsp" />
		</div>
</section>