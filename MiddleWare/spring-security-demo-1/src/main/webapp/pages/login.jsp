<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<title>
	Home
</title>
<base href="/"/> 

</head>

<body bgcolor="pink">
<h1>Login</h1>
<form action="login" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<c:if test="${param.err eq true}">
<p><strong>Incorrect Username or password</strong>
</p>
</c:if>
<label>User Name: <input type="text" name="unm"/></label>
<label>Password: <input type="password" name="pwd"/></label>
<button>Sign in</button>

</form>
</body>


</html>