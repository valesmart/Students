<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html
		charset=UTF-8"/>
		<title>Система управления студентами</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="https://code.jquery.com/jquery-3.1.0.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="/js/main.js"></script>
		<style>
			#login{

				width: 26%;
				height: 30%;
				margin-left:30%;
				margin-top:10%;
			}
			#b10{
				width: 50%;
			}


		</style>
	</head>
	<body>
	<header><p id="p">Система управления студентами и их успеваемостью</p></header>
	<div id="logout"><a href="/logout">Logout </a></div>

		<jsp:include page="${page}"/>


	</body>
</html>