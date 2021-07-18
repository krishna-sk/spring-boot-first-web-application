<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container mt-5">
	<div class="row">
		<div class="col-2"></div>
		<div class="col-8">
			<div class="card text-dark bg-light">
				<div class="card-header ">
					<h2><strong>Access Denied</strong></h2>
				</div>
				<div class="card-body">
					<h4 class="card-title">Your are not authorized</h4>
					<ul>
						<li class="card-text"><h5>Employees Can't Update and Delete the Todo</h5></li>
						<li class="card-text"><h5> Manager Can't Delete the Todo </h5></li>
					</ul>
					
					<a href="/list-todos" class="btn btn-primary">Go Back</a>
				</div>
			</div>
		</div>
		<div class="col-2"></div>

	</div>
</div>
<%@ include file="common/footer.jspf"%>