<%@ page language="java" pageEncoding="UTF-8"%>

<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/disciplines-list">назад</a></div>
		</div>
		<div id="text1">Для того чтобы модифицировать дисциплину введите новое значение поля и нажмите кнопку "Применить":</div>
		<div id="pole">
			<form method="post" action="/discipline-modify">
			<label id="label1" for="secondname1">Название</label>
			<input class="input1" value="${discipline.disciplinename}" type="text" name="disciplinename" title="Поменяйте название дисцыплины"
			maxlength="30" id="secondname1" width="50%"/>
			<br/><br/>
			<input class="input1" id="but1" type="submit" value="Применить" title="Применить"/>
			</form>
			<jsp:include page="/modules/validationMessage.jsp" />
		</div>
</section>