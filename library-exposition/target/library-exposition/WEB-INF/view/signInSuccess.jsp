<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 27/12/2020
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <br/>
        <h1>${message}</h1>
        <br/>
        <hr/>

        <table class="table table-striped table-bordered">
            <tr>
                <td><b>Name </b>: ${userAccount.username}</td>
            </tr>
        </table>
        <br/>
        <p>
            <a> ${userAccount.username} est bien connecté</a>
        </p>
        <br/>
        <p>
            <a href="<c:url value="/"/>">Retour à l'accueil</a>
        </p>
        <br/>
    </div>
</div>
</body>
</html>
