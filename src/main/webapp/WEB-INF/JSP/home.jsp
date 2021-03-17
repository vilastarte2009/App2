<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/JSP/header.jspf"%>


<div class="container">
	<table class="table table-striped">
		<caption>Employee List</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name
				<th>Salary</th>
				<th>Birth Date</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emp_list}" var="emp">

				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.salary}</td>
					<td><fmt:formatDate value="${emp.bdate}" pattern="dd/MM/yyyy"/></td>
					<td><a type = "button" class = "btn btn-warning" href="/update-emp/${emp.id}">Update</a></td>
					<td><a type = "button" class = "btn btn-warning" href="/delete-emp/${emp.id}">Delete</a></td>
				</tr>

			</c:forEach>

		</tbody>


	</table>
	<div>
		
			<a type = "button" class = "btn btn-success" href="/aadEmp">Add New Employee</a>
		
	</div>
</div>


<%@ include file="/WEB-INF/JSP/footer.jspf"%>
