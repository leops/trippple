<%@ tag pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<title>Trippple</title>
		<link rel="stylesheet" href="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/main.css">
	</head>
	<body>
		<nav class="navbar navbar-fixed-top navbar-dark bg-primary">
			<a class="navbar-brand" href="#">Trippple</a>
			<form class="form-inline navbar-form pull-left" method="POST" action="/search">
				<div class="input-group">
					<input type="search" class="form-control" placeholder="Search">
					<span class="input-group-btn">
						<button class="btn btn-secondary-outline" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</form>
			<ul class="nav navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Profile</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Order</a>
				</li>
			</ul>
			<ul class="nav navbar-nav pull-right">
				<li class="nav-item">
					<a class="nav-link" href="#">Bag <span class="label label-pill label-info">5</span></a>
				</li>
			</ul>
		</nav>
		<main class="container-fluid">
			<jsp:doBody />
		</main>
		<footer class="container-fluid">
			<p class="text-muted">
				Footer
			</p>
		</footer>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js"></script>
	</body>
</html>
