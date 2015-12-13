<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:root>
	<div class="row">
		<form class="col-sm-6 col-sm-offset-3 form-horizontal" role="form" action="profile" method="POST">
			<h2>Profile Details</h2>
			
			<fieldset class="form-group">
				<label class="col-sm-2 control-label" for="textinput">Email</label>
				<div class="col-sm-10">
					<input type="email" name="email" class="form-control" value="${user.email}">
				</div>
			</fieldset>

			<fieldset class="form-group">
				<label class="col-sm-2 control-label" for="textinput">Last Name</label>
				<div class="col-sm-10">
					<input type="text" name="lastName" class="form-control"
						value="${user.lastName}">
				</div>
			</fieldset>

			<fieldset class="form-group">
				<label class="col-sm-2 control-label" for="textinput">First Name</label>
				<div class="col-sm-10">
					<input type="text" name="firstName" class="form-control" value="${user.firstName}">
				</div>
			</fieldset>

			<fieldset class="form-group">
				<label class="col-sm-2 control-label" for="textinput">Password</label>
				<div class="col-sm-10">
					<input type="text" name="primPassword" class="form-control">
				</div>
			</fieldset>

			<fieldset class="form-group">
				<label class="col-sm-2 control-label" for="textinput">Confirm Password</label>
				<div class="col-sm-10">
					<input type="text" name="secPassword" class="form-control">
				</div>
			</fieldset>
			
			<fieldset class="btn-group pull-right">
				<a href="profile" class="btn btn-warning">Cancel</a>
				<button type="submit" class="btn btn-primary">Save</button>
			</fieldset>
		</form>
	</div>
</t:root>
