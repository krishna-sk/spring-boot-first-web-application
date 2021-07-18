<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container mt-5">
		<div class="row mt-3">
			<div class="col-5">
				<form:form method="post" modelAttribute="todo">
					<form:hidden path="id" />
					<div class="form-group mb-3">
						<form:label path="desc" for="Description">
							<strong>Description</strong>
						</form:label>
						<form:input type="text" path="desc" class="form-control mt-1"
							id="Description" placeholder="Enter Description"
							required="required" />
						<form:errors path="desc" class="text-danger"></form:errors>
					</div>

					<div class="form-group mb-3">
						<form:label path="targetDate" for="TargetDate">
							<strong>TargetDate</strong>
						</form:label>
						<form:input type="text" path="targetDate"
							class="form-control mt-1" id="TargetDate"
							placeholder="Enter Date" required="required" />
						<form:errors path="targetDate" class="text-danger"></form:errors>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</form:form>
			</div>
			<div class="col-4"></div>
			<div class="col-3"></div>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>