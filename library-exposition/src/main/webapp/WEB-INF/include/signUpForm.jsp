<%--
  Created by IntelliJ IDEA.
  User: ricobsj
  Date: 24/12/2020
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container">
    <form:form modelAttribute="userAccount" method="post" action="/library_exposition_war_exploded/home/registration">
        <br/>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>
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
                <form:label path="email">Email</form:label>
                <form:input path="email" placeholder="Entrez votre email"/>
                <br/>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-6">
                <form:label path="password">Mot de passe</form:label>
                <form:password path="password" placeholder="Entrez votre mot de passe"/>
                <br/>
            </div>
            <div class="col-sm-6">
                <label>
                    <p>Sélectionnez votre rôle : </p>
                    <select path="roles" items="${userAccount.roles}">
                        <option value="NONE">--- Select ---</option>
                        <option value="ROLE_USER">ROLE_USER</option>
                        <option value="ROLE_MODERATOR">ROLE_MODERATOR</option>
                        <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                    </select>
                </label>
            </div>
                <%--<div class="col-sm-6">
                    <form:label path="roleDtos">Role</form:label>
                    <form:input path="roleDtos" placeholder="Entrez votre role"/>
                    <br/>
                </div>--%>
        </div>
        <br/>
        <input type="submit" value="Inscription"/>
    </form:form>
</div>
