<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 10/12/2020
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="<c:url value="../include/style.css" />" />
    <title>Recherche de livre</title>
</head>
<body>
    <div class="container">
        <c:import url="../include/menu.jsp"></c:import>
        <form:form modelAttribute="searchBook" action="searchBook" method="post">
            <br/><p>Vous pouvez sélectionner vos critères de recherche via ce formulaire.</p>

            <div class="form-group row">
                <div class="col-sm-6">
                    <form:label path="searchBookTitle">Recherche de livre par titre</form:label>
                    <form:input path="searchBookTitle" placeholder="Entrer le titre"/>
                </div>
                <div class="col-sm-6">
                    <form:label path="searchBookAuthorName">Recherche de livre par auteur</form:label>
                    <form:input path="searchBookAuthorName" placeholder="Entrer l'auteur"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6">
                    <form:label path="searchBookPublishingHouse">Recherche de livre par édition</form:label>
                    <form:input path="searchBookPublishingHouse" placeholder="Entrer l'édition"/>
                </div>
                <div class="col-sm-6">
                    <form:label path="searchBookReleaseDate">Recherche de livre par date</form:label>
                    <form:input path="searchBookReleaseDate" placeholder="Entrer la date"/>
                </div>
            </div>
            <input type="submit" value="Valider">
        </form:form>
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