<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My Application</title>
<link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center">
			<div class="card" style="width: 30rem;">
				<div class="card-body">
					<h3 class="card-title d-flex justify-content-center">Login</h3>
				</div>
				<div class="text-danger">${errorMessage}</div>
				<form:form method="post" action="/user">
						<!-- Check for login error -->
					<c:if test="${param.error != null}">
						<div class="alert alert-danger"> Invalid Credentials</div>
					</c:if>
					
					<div class="form-group mb-3">
						<label for="Username">Username</label> <input type="text"
							name="username" class="form-control mt-1" id="Username"
							placeholder="Enter Username">
					</div>
					<div class="form-group mt-3 mb-3">
						<label for="password">Password</label> 
						<input type="password" name="password" class="form-control mt-1" id="Password"
							placeholder="Enter Password">
					</div>

					<div class="d-flex justify-content-between">
						<div>
							<a href="" class="btn btn-success mt-1"
								style="width: 5rem;">SignUp</a>
						</div>
						<div>
							<input type="submit" class="btn btn-primary mt-1"
								style="width: 5rem;" value="Login">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
</body>

</html>