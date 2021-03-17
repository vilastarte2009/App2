<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/JSP/header.jspf"%>

<form action="/login" method="post">
	${message}
	<div>
		User Name <input type="text" name="uname" />
	</div>
	<br>
	<div>
		Password &nbsp &nbsp<input type="password" name="pass" />
	</div>
	<br>
	<div>
		<input type="submit" Value="Login">
	</div>
</form>

</body>

</html>