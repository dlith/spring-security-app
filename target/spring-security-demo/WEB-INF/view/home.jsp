<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <title>Company Home Page</title>
</head>

<body>
    <h2>Company Home Page</h2>
    <hr>
    <p>
        User: <security:authentication property="principal.username"/>
        <br>
        <br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <hr>
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
            (Only for Manager peeps)
        </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">Admin info</a>
            (Only for Admin peeps)
        </p>
    </security:authorize>

    <hr>
    <p>Welcome to the company home page!</p>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>
</body>

</html>