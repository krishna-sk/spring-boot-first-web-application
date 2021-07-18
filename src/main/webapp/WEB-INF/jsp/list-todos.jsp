<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container mt-5 col-6">
		<h3 class="d-flex justify-content-center">Your Todo's are</h3>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Description</th>
					<th scope="col">Date</th>
					<th scope="col">is Done</th>
					<th scope ="col"> Update</th>
					<th scope ="col"> Delete</th>
				</tr>
			</thead>
			<tbody>
			<c:set var="count" value="1" scope="page" />
				<c:forEach var="todo" items="${todos}">
					<tr>
						<th scope="row">${count}</th>
						<c:set var="count" value="${count + 1}" scope="page"/>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value ="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a class="btn btn-success" href="update-todo?id=${todo.id}">Update</a></td>
						<td><a class="btn btn-danger" href="delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<div>
			<a class="btn btn-primary" href="/add-todo">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>