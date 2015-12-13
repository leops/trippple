<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:root>
	<div class="card">
		<div class="card-block">
			<h4 class="card-title">Trips in your bag</h4>
		</div>
		<ul class="list-group list-group-flush">
			<c:forEach items="${user.bag}" var="trip">
				<li class="list-group-item">${trip.origin.name} <i class="fa fa-arrow-right"></i> ${trip.destination.name}</li>
			</c:forEach>
		</ul>
		<div class="card-block">
			<a href="api/bag/clear" class="btn btn-danger">Clear</a>
			<a href="api/bag/order" class="btn btn-success">Confirm</a>
		</div>
	</div>
</t:root>
