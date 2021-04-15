<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 27/12/2020
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <br/>
        <h1>${message}</h1>
        <br/>

        <table class="table table-striped table-bordered">
            <tr>
                <td><b>Name </b>: ${userAccount.username}</td>
            </tr>
        </table>
        <br/>
        <p>
            <a> ${userAccount.username} est bien inscrit</a>
        </p>
        <br/>
        <form:form action="/library_exposition_war_exploded/login" method="post">
            <input class="nav-link"  type="submit" value="Vous pouvez vous connecter" />
        </form:form>
        <br/><br/>
        <p>
            <a href="<c:url value="/"/>">Retour à l'accueil</a>
        </p>
        <br/>
    </div>
</div>
</body>
</html>
