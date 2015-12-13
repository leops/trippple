<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page import="com.traveloid.trippple.entity.User" %>
<%@ page import="com.traveloid.trippple.entity.Campus" %>
<t:root>
	<form class="form-horizontal" role="form" action="profile" method="POST">
		<h2>Profile Details</h2>
		
		<fieldset class="form-group">
			<label class="col-sm-2 control-label" for="email">Email</label>
			<div class="col-sm-10">
				<input type="email" name="email" class="form-control" value="${user.email}" required>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-sm-2 control-label" for="lastName">Last Name</label>
			<div class="col-sm-10">
				<input type="text" name="lastName" class="form-control" value="${user.lastName}" required>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-sm-2 control-label" for="firstName">First Name</label>
			<div class="col-sm-10">
				<input type="text" name="firstName" class="form-control" value="${user.firstName}" required>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-sm-2 control-label" for="primPassword">Password</label>
			<div class="col-sm-10">
				<input type="text" name="primPassword" class="form-control">
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-sm-2 control-label" for="secPassword">Confirm Password</label>
			<div class="col-sm-10">
				<input type="text" name="secPassword" class="form-control">
			</div>
		</fieldset>
		
		<fieldset class="form-group">
			<label class="col-sm-2 control-label" for="campus">Campus</label>
			<div class="col-sm-10">
				<select name="campus" class="form-control c-select" required value="${user.campus.id}">
					<c:forEach items="${campuses}" var="campus">
						<option value="${campus.id}" ${campus.id == user.campus.id ? "selected" : ""}>${campus.name}</option>
					</c:forEach>
				</select>
			</div>
		</fieldset>
		
		<fieldset class="btn-group pull-right">
			<a href="profile" class="btn btn-warning">Cancel</a>
			<button type="submit" class="btn btn-primary">Save</button>
		</fieldset>
	</form>
</t:root>
