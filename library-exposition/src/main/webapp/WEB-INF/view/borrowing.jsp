<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 31/01/2021
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Liste des emprunts</title>
</head>
<body>
<div class="container">
    <br/>
    <h1>Liste des emprunts de ${sessionScope.userAccount.username}</h1>
    <br/>
    <p>
        <a href="<c:url value="/"/>">Retour à l'accueil</a>
    </p>
    <br/>
    <%--<c:if test="${!empty sessionScope.userAccount.username}">--%>
        <%--${sessionScope.userAccount.username == borrowing.userAccountBorrowing.username}--%>
    <table class="table">
        <tr>
            <th>Titre</th>
            <th>Nombre d'exemplaire</th>
            <th>Auteur</th>
            <th>Date de fin d'emprunt</th>
            <th>Emprunt</th>
        </tr>
        <c:forEach var="borrowing" items="${borrowings}">
        <tr class="table">
            <td>${borrowing.bookBorrowing.title}</td>
            <td>${borrowing.bookBorrowing.quantity}</td>
            <td>${borrowing.bookBorrowing.bookAuthor.firstName} ${borrowing.bookBorrowing.bookAuthor.lastName}</td>
            <td>${borrowing.endDate}</td>
            <td><c:if test="${borrowing.bookBorrowing.quantity > 0}">
                <form:form modelAttribute="borrowing" action="${pageContext.request.contextPath}/borrowing" method="post">
                    <input type="hidden" id="bookId" name="bookId" value="${borrowing.bookBorrowing.bookId}" />
                    <input type="submit" name="tag" value="Renouveler" />
                </form:form>
            </c:if>
                <c:if test="${borrowing.bookBorrowing.quantity == 0}">
                    <p>Non disponible</p>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </table>
    <%--</c:if>--%>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>