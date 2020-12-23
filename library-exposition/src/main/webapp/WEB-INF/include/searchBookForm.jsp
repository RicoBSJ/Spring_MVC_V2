<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <form:form modelAttribute="searchBook" action="/library_exposition_war_exploded/home/search" method="post">
        <br/>
        <p>Vous pouvez sélectionner vos critères de recherche via ce formulaire.</p>

        <p>
            <a href="<c:url value="/"/>">Retour à l'accueil</a>
        </p>

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
