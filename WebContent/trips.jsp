<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:root>
	<ul class="list-group" data-reactid=".0">
		<c:forEach items="${trips}" var="trip">
			<li class="list-group-item" data-reactid=".0.$${trip.id}">
				<span data-reactid=".0.$${trip.id}.0">${trip.origin.name}</span>
				<span data-reactid=".0.$${trip.id}.1"> </span>
				<i class="fa fa-arrow-right" data-reactid=".0.$${trip.id}.2"></i>
				<span data-reactid=".0.$${trip.id}.3"> </span>
				<span data-reactid=".0.$${trip.id}.4">${trip.destination.name}</span>
				<a href="api/bag/add?id=${trip.id}" class="btn btn-default btn-sm pull-right" data-reactid=".0.$${trip.id}.5">
					<i class="fa fa-cart-arrow-down" data-reactid=".0.$${trip.id}.5.0"></i>
				</a>
			</li>
		</c:forEach>
	</ul>
</t:root>
