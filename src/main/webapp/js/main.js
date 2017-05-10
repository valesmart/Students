/**
 * Created by Валера on 09.03.2017.
 */

function progressStudents(value) {

    //alert(value);//проверка работы функции

    var items = $("input[name=studentid]:checked");//ищет на странице все выбранные чекбоксы
    if (items.length == 0) {//спрашиваем длину
        alert("Выберете студента");
        return;//
    }
    if (items.length > 1) {
        alert("Можно выбрать только одного студента");
        return;
    }

    $('#firstform').submit();//нажимает кнопку сабмит на фоорме по ид '#firstform'

}


function disciplines(value) {

    var items1 = $("input[name=disid]:checked");
    if (items1.length == 0) {
        alert("Выбирите дисцыплину");
        return;
    }
    if (items1.length > 1) {
        alert("Можно выбрать только одну дисцыплину");
        return;
    }

    $('#twoform').submit();

}

function pageDisciplines(value) {
    var items = $("input[name=disid]:checked");
    if (items.length == 0) {
        alert("Выберете дисциплину");
        return;
    }
    $("#twoform").attr("action", "/discipline-list");

    $('#twoform').submit();

}

function deleteStudents(value) {

    var items = $("input[name=studentid]:checked");
    if (items.length == 0) {
        alert("Выберете студента");
        return;
    }
    $('#firstform').submit();

}


function termModif(value) {

    $("#forform").attr("action", "/term-modify");

    $('#forform').submit();

}

function termDelete(value) {

    $("#forform").attr("action", "/terms-list");

    $('#forform').submit();

}


function termCreate(value) {

    var items = $("select[name=choice]:selected");
    if (items.length == 0) {
        alert("Выберете хотя бы одну дисцыплину");
        return;//
    }
    $('#forform').submit();

}

function StudentProg(value) {

    var items = $("input[name=studentid]:checked");
    if (items.length == 0) {
        alert("Выберете студента");
        return;//
    }
    if (items.length > 1) {
        alert("Можно выбрать только одного студента");
        return;
    }

    $("#firstform").attr("action", "/student-progress");

    $('#firstform').submit();

}