<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:root>
	<div class="row">
		<form class="col-sm-6 col-sm-offset-3 form-horizontal" role="form" action="register" method="POST">
			<h2>Sign up</h2>
			
			<fieldset class="form-group">
				<input type="number" name="id" class="form-control" placeholder="Campus ID" />
			</fieldset>
			
			<fieldset class="form-group row">
				<div class="col-sm-6">
					<input type="text" name="firstName" class="form-control" placeholder="Last Name" />
				</div>
				<div class="col-sm-6">
					<input type="text" name="lastName" class="form-control" placeholder="First Name" />
				</div>
			</fieldset>
			
			<fieldset class="form-group">
				<input type="email" name="email" class="form-control" placeholder="Email" />
			</fieldset>
			
			<fieldset class="form-group row">
				<div class="col-sm-6">
					<input type="password" name="primPassword" class="form-control" placeholder="Password" />
				</div>
				<div class="col-sm-6">
					<input type="password" name="secPassword" class="form-control" placeholder="Confirm Password" />
				</div>
			</fieldset>

			<button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">Register</button>
		</form>
	</div>
</t:root>