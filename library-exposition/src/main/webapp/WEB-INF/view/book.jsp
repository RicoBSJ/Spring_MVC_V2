<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 05/12/2020
  Time: 23:09
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
    <title>Liste des livres</title>
</head>
<body>
<div class="container">
    <br/>
    <h1>Espace utilisateur</h1>
    <br/>
    <p>
        <a href="<c:url value="/"/>">Retour à l'accueil</a>
    </p>
    <br/>
    <table class="table">
        <tr>
            <th>Titre</th>
            <th>Nombre d'exemplaire</th>
            <th>Auteur</th>
            <th>Emprunt</th>
        </tr>
        <c:forEach var="book" items="${books}">
        <tr class="table">
            <td>${book.title}</td>
            <td>${book.quantity}</td>
            <td>${book.bookAuthor.firstName} ${book.bookAuthor.lastName}</td>
            <%--<td><a href="<c:url value="${'./home/borrowing'}" />">Emprunt</a></td>--%>
            <td><c:if test="${book.quantity > 0}">
                    <form:form modelAttribute="book" action="${pageContext.request.contextPath}/home/borrowing" method="post">
                        <input type="hidden" id="bookId" name="bookId" value="${book.bookId}" />
                        <input type="submit" name="tag" value="Disponible" />
                    </form:form>
            </c:if>
            <c:if test="${book.quantity == 0}">
                    <form:form modelAttribute="book" action="${pageContext.request.contextPath}/home/borrowing" method="post">
                        <input type="submit" name="tag" value="Non Disponible" />
                    </form:form>
            </c:if>
            </td>
        </tr>
        </c:forEach>
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
