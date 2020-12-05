<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 05/12/2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <table>
                <tr>
                    <th>Titre</th>
                    <th>Quantité</th>
                    <th>Année</th>
                    <th>Auteur</th>
                    <th>Category</th>
                    <th>Edition</th>
                </tr>
                <c:forEach items="${ books }" var="books">
                    <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                        <td><c:out value="${ book.title }"></c:out></td>
                        <td><c:out value="${ book.quantity }"></c:out></td>
                        <td><c:out value="${ book.yearBook }"></c:out></td>
                        <td><c:out value="${ book.bookAuthor.lastName }"></c:out></td>
                        <td><c:out value="${ book.bookCategory.nameCategory }"></c:out></td>
                        <td><c:out value="${ book.bookEdition.nameEdition }"></c:out></td>

                            <%--<td><c:if test="${message.statut == null }">
                                <form action="accepterDemande" method="post">
                                    <input type="hidden" value="${ message.topo.id }" name="idTopo">
                                    <input type="hidden" value="${ message.id }" name="id">
                                    <input type="submit" name="tag" value="Accepter la demande de réservation"/>
                                </form>
                                <form action="refuserDemande" method="post">
                                    <input type="hidden" value="${ message.topo.id }" name="idTopo">
                                    <input type="hidden" value="${ message.id }" name="id">
                                    <input type="submit" name="tag" value="Refuser la demande de réservation"/>
                                </form></c:if>
                            </td>
                            <td>
                                <c:if test="${message.statut == null}">
                                    <p>En attente</p>
                                </c:if>
                                <c:if test="${message.statut == true}">
                                    <p>Acceptée</p>
                                </c:if>
                            </td>
                            <td><c:if test="${message.statut == true}">
                                <c:out value="${ message.emetteur.email }"></c:out>
                            </c:if>
                            </td>--%>
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
