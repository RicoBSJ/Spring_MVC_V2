<%--
  Created by IntelliJ IDEA.
  User: AUBRUNE
  Date: 08/12/2020
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="<c:url value="../include/style.css" />" />
    <title>Page d'accueil de la bibliothèque</title>
</head>
<body>
    <div class="container">
        <c:import url="../include/menu.jsp"></c:import>
        <form>
            <br/><p>Vous pouvez sélectionner vos critères de recherche via ce formulaire.</p>

            <div class="form-group row">
                <div class="col-sm-6">
                    <label for="titre">Recherche de livre par titre</label>
                    <input type="text" class="form-control" id="titre" value="<c:out value="${searchBook.searchBookTitle}"/>" placeholder="Entrer le titre">
                </div>
                <div class="col-sm-6">
                    <label for="auteur">Recherche de livre par auteur</label>
                    <input type="text" class="form-control" id="auteur" value="<c:out value="${searchBook.searchBookAuthorName}"/>" placeholder="Entrer l'auteur">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6">
                    <label for="edition">Recherche de livre par édition</label>
                    <input type="text" class="form-control" id="edition" value="<c:out value="${searchBook.searchBookPublishingHouse}"/>" placeholder="Entrer l'édition">
                </div>
                <div class="col-sm-6">
                    <label for="date">Recherche de livre par date</label>
                    <input type="text" class="form-control" id="date" value="<c:out value="${searchBook.searchBookReleaseDate}"/>" placeholder="Entrer la date">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Valider</button>
        </form>
    </div>
    <div class="container">
        <br/><h2>Liste des livres</h2>
        <table class="table" data-url="/book">
            <tr>
                <th>Titre</th>
                <th>Quantité</th>
                <th>Année</th>
                <th>Auteur</th>
                <th>Catégorie</th>
                <th>Edition</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr class="table" data-url="/book">
                    <td>${book.title}</td>
                    <td>${book.quantity}</td>
                    <td>${book.yearBook}</td>
                    <td>${book.bookAuthor.lastName}</td>
                    <td>${book.bookCategory.nameCategory}</td>
                    <td>${book.bookEdition.nameEdition}</td>
                </tr>
            </c:forEach>
        </table>
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