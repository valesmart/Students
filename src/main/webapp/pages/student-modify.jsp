<%@ page language="java" pageEncoding="UTF-8" %>
<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/student list">назад</a></div>
		</div>
		<div id="text2">Для модификации, введите новые значения и нажмите кнопку "Применить".</div>
		<div id="pole">
			<form method="post" action="/sudent-modify">
			<label class="label2" for="secondname1">Фамилия</label>
			<input class="input2" value="${student.surname}" type="text" name="secondname" title="Введите фамилию"
			maxlength="30" id="secondname1" width="50%"/>
			<br/><br/>
			<label class="label2"  for="name">Имя</label>
			<input class="input2" value="${student.name}" type="text"  name="name" title="Введите имя"
			maxlength="20" id="name" width="50%"/>
			<br/><br/>
			<label class="label2  for="group">Группа</label>
			<input class="input2" value="${student.group}" type="text"  name="group" title="Введите группу"
			maxlength="10" id="group" width="50%"/>
			<br/><br/>
			<label class="label2"  for="data">Дата поступления</label>
			<input class="input2" value="${student.date}" type="text" name="data" title="Введите дату поступления"
			maxlength="30" id="data" width="50%"/>
			<br/><br/>
			<input class="input2" id="but1" type="submit" value="Применить"/>
			</form>
			<jsp:include page="/modules/validationMessage.jsp" />
		</div>
</section>

<%--
value="${student.surname}"--%>
