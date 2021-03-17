<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>First Web Application</title>
<link
	href="http://localhost:8080/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Add/Update Employee</h1>
		<form:form method="POST" action="/finalAddOrUpdate"
			modelAttribute="command1">
			<form:hidden path="secretValue" value="${command1.id}" />
			<fieldset class="form-group">
				<form:label path="id">ID </form:label>
				<form:input path="id" type="number" class="form-control" />
				<form:errors path="id" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="name">Name </form:label>
				<form:input path="name" type="text" class="form-control" />
				<form:errors path="name" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="salary">Salary </form:label>
				<form:input path="salary" type="number" class="form-control" />
				<form:errors path="salary" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="bdate">Birth Date </form:label>
				<form:input path="bdate" type="text"  class="form-control" />
				<form:errors path="bdate" cssClass="text-warning" />
			</fieldset>

			<input type="submit" class="btn btn-success">
			<a type="button" class="btn btn-warning" href="/home"> Back</a>
		</form:form>
	</div>

<script
	src="webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
<script>
$('#bdate').datepicker({
	format : 'dd/mm/yyyy'
});
</script>
	<%@ include file="/WEB-INF/JSP/footer.jspf"%>