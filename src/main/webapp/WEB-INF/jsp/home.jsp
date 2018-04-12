<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

</head>
<body>
	<div class="container">
		<div class="starter-template">
			<h1>Sample Heroku Example</h1>
			<h2> ${message}</h2>
		</div>
        <p>Click <a href="<spring:url value='/hello' />">here</a> to see a greeting.</p>

	</div>

</body>

</html>
