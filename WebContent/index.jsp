<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:root>
	<ul>
		<c:forEach items="${trips}" var="trip">
			<li>
				<c:out value="trip.origin.name" />
				->
				<c:out value="trip.destination.name" />
			</li>
		</c:forEach>
	</ul>
</t:root>