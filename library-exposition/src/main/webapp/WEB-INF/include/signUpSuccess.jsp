<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 27/12/2020
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h1>${message}</h1>
        <hr/>

        <table class="table table-striped table-bordered">
            <tr>
                <td><b>Name </b>: ${userAccount.username}</td>
            </tr>
            <tr>
                <td><b>Email </b>: ${userAccount.email}</td>
            </tr>
            <tr>
                <td><b>Role </b> : ${userAccount.roles}</td>
            </tr>
        </table>
        <br/>
        <p>
            <a href="<c:url value="/"/>">Retour à l'accueil</a>
        </p>
        <br/>
    </div>
</div>
</body>
</html>
