<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>employees List</title>
		<link href="styles/site.css" rel="stylesheet"/>
	</head>
	<body>
		<h2>employees List</h2>
		
		<a href="addEmployee">Add Employee</a>
		
		<c:choose>
			<c:when test="${employees eq null or employees.size() eq 0} }">
				<h3>No Records Found!</h3>
			</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>employees#</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Date ofBirth</th>
				</tr>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.empName}</td>
						<td>${employee.mobileNum }</td>
						<td>${employee.emailId }</td>
						<td>${employee.dob }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
		</c:choose>
	</body>
</html>
