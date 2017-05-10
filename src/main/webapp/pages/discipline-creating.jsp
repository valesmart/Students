<%@ page language="java" pageEncoding="UTF-8"%>

<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/disciplines-list">назад</a></div>
		</div>
		<div id="text1">Для того чтоб создать новую дисциплину заполните все поля и нажмите кнопку "Создать":</div>

		<div id="pole">
			<form method="post" action="/discipline-creating">
			<label id="label1" for="disciplinename">Название</label>
			<input class="input1" type="text" placeholder="Информатика" name="disciplinename" title="Введите название дисцыплины"
			maxlength="30" id="disciplinename" width="50%"/>
			<br/><br/>
			<input id="but1" class="input1" type="submit" value="Создать" title="Создать"/>
			</form>
			<jsp:include page="/modules/validationMessage.jsp" />
		</div>

</section>