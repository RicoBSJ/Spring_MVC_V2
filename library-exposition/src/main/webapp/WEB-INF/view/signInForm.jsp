<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 24/12/2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <form:form modelAttribute="userAccount" method="post" action="/library_exposition_war_exploded/login">
        <br/>
        <p>Vous pouvez vous connecter via ce formulaire.</p>
        <br/>
        <p>
            <a href="<c:url value="/"/>">Retour à l'accueil</a>
        </p>
        <br/>
        <div class="form-group row">
            <div class="col-sm-6">
                <form:label path="username">Nom</form:label>
                <form:input path="username" placeholder="Entrez votre nom"/>
                <br/>
            </div>
            <div class="col-sm-6">
                <form:label path="password">Mot de passe</form:label>
                <form:password path="password" placeholder="Entrez votre mot de passe"/>
                <br/>
            </div>
        </div>
        <br/>
        <input type="submit" value="Connexion">
    </form:form>
</div>
