<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Usuários</title>
    <s:url value="/static/css/bootstrap.css" var="css"/>
    <link type="text/css" rel="stylesheet" href="${css }">
</head>
<body>
    <div class="container">
        <h1>Cadastro de Usuários</h1>
        <hr>

        <div>
            <s:url value="/usuario/todos" var="home"/>
            <a class="btn-primary" href="${home }">Home</a>
        </div>
        <hr>
        <div>
            <s:url value="${usuario.id == null ? '/usuario/save' : '/usuario/update'}" var="save"/>
            <form:form modelAttribute="usuario" action="${save }" method="post">

                <form:hidden path="id"/>

                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <form:input path="nome" cssClass="form-control"/>
                    <form:errors path="nome" cssClass="label alert-danger"/>
                </div>

                <div class="form-group">
                    <label for="sobreNome">Sobre Nome:</label>
                    <form:input path="sobreNome" cssClass="form-control"/>
                    <form:errors path="sobreNome" cssClass="label alert-danger"/>
                </div>

                <div class="form-group">
                    <label for="dtNascimento">Data Nascimento:</label>
                    <form:input path="dtNascimento" type="date" cssClass="form-control"/>
                    <form:errors path="dtNascimento" cssClass="label alert-danger"/>
                </div>

                <div class="form-group">
                    <label for="sexo">Sexo:</label>
                    <form:select path="sexo" cssClass="form-control">
                        <form:options items="${sexos }" itemLabel="desc" />
                    </form:select>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
