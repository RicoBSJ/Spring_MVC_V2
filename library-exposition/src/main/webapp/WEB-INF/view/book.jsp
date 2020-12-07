<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 05/12/2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"/>
    <title>Liste des livres</title>
</head>
<body>
<div class="container">
    <%--<c:import url="/include/menu.jsp"></c:import>--%>
    <div id="corps">
        <fieldset>
            <legend>Liste des livres</legend>
            <%--<c:if test="${!empty sessionScope.sessionUtilisateur}">--%>
            <table >
                <tr>
                    <th>Titre</th>
                    <th>Quantité</th>
                    <th>Année</th>
                    <th>Auteur</th>
                    <th>Catégorie</th>
                    <th>Edition</th>
                </tr>
                <c:forEach var="books" items="${books}">
                    <tr>
                        <td>${books.title}</td>
                        <td>${books.quantity}</td>
                        <td>${books.yearBook}</td>
                        <td>${books.bookAuthor.lastName}</td>
                        <td>${books.bookCategory.nameCategory}</td>
                        <td>${books.bookEdition.nameEdition}</td>
                    </tr>
                </c:forEach>
            </table>
            <%--</c:if>--%>
        </fieldset>
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
