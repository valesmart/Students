<%@ page language="java" pageEncoding="UTF-8" %>
<section>

		<div id="glav1">
			<a href="/">На главную</a>
		<div id="back"><a href="/student list">назад</a></div>
		</div>
		<div id="text2">Для создания студента заполните все поля и нажмите кнопку "Создать".</div>
		<div id="pole">
			<form method="post" action="/student-creating">
			<label class="label2" for="secondname1">Фамилия</label>
			<input class="input2"  type="text" placeholder="Иванов" name="secondname" title="Введите фамилию"
			maxlength="30" id="secondname1" width="50%"/>
			<br/><br/>
			<label class="label2" for="name">Имя</label>
			<input class="input2"  type="text" placeholder="Иван" name="name" title="Введите имя"
			maxlength="20" id="name" width="50%"/>
			<br/><br/>
			<label class="label2" for="group">Группа</label>
			<input class="input2"  type="text" placeholder="ТМ-91" name="group" title="Введите группу"
			maxlength="10" id="group" width="50%"/>
			<br/><br/>
			<label class="label2" for="data">Дата поступления</label>
			<input class="input2"  type="text" name="data" title="Введите дату поступления"
			maxlength="30" id="data" width="50%"/>
			<br/><br/>
			<input id="but1" class="input2" type="submit" value="Создать" title="Создать"/>
			</form>
		<jsp:include page="/modules/validationMessage.jsp" />
		</div>
	</section>