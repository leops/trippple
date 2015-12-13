<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:root>
	<form class="form-horizontal" role="form" action="register" method="POST">
		<h2>Sign up</h2>
		<p>${flash}</p>
		
		<fieldset class="form-group">
			<input type="number" name="id" class="form-control" placeholder="Campus ID" required />
		</fieldset>
		
		<fieldset class="form-group row">
			<div class="col-sm-6">
				<input type="text" name="firstName" class="form-control" placeholder="First Name" required />
			</div>
			<div class="col-sm-6">
				<input type="text" name="lastName" class="form-control" placeholder="Last Name" required />
			</div>
		</fieldset>
		
		<fieldset class="form-group">
			<input type="email" name="email" class="form-control" placeholder="Email" required />
		</fieldset>
		
		<fieldset class="form-group row">
			<div class="col-sm-6">
				<input type="password" name="primPassword" class="form-control" placeholder="Password" required />
			</div>
			<div class="col-sm-6">
				<input type="password" name="secPassword" class="form-control" placeholder="Confirm Password" required />
			</div>
		</fieldset>
		
		<fieldset class="form-group">
			<select name="campus" class="form-control c-select" required>
				<option selected disabled>Campus</option>
				<c:forEach items="${campuses}" var="campus">
					<option value="${campus.id}">${campus.name}</option>
				</c:forEach>
			</select>
		</fieldset>

		<button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">Register</button>
	</form>
</t:root>
