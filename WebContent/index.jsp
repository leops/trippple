<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:root>
	<div class="row">
		<div class="col-sm-6">
			<div class="card card-block">
				<h3 class="card-title">
					Login or <a href="register">Sign up</a>
				</h3>
				<hr>
				<form action="login" autocomplete="off" method="POST">
					<div class="form-group input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="number" class="form-control" name="id" placeholder="Campus id">
					</div>
		
					<div class="form-group input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="password" class="form-control" name="password" placeholder="Password">
					</div>
		
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>
				<h4 class="card-title dede">
					Welcome !
				</h4>
				<p class="card-text">
					Trippple is an online travel agency.<br>
					Here you will find the list of our trips, by campuses.<br>
					If you already have an account, juste login using this form.<br>
					Otherwise, click on "Signup" and create your account !
				</p>
			</div>
		</div>
	
		<div class="col-sm-6">
			<div class="card card-block">
				<h3 class="card-title">Statistics</h3>
				<p class="card-text">Number of users: ${users.size()}</p>
				<p class="card-text">Number of trips: ${trips.size()}</p>
			</div>
		</div>
	</div>
</t:root>
