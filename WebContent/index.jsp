<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Trippple</title>
	</head>
	<body>
		<ul>
			<c:forEach items="${trips}" var="trip">
				<li>
					<c:out value="trip.origin.name" />
					->
					<c:out value="trip.destination.name" />
				</li>
			</c:forEach>
		</ul>
	</body>
</html>