<%--
  Created by IntelliJ IDEA.
  User: Deivid
  Date: 10/03/2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Usuários</title>
    <s:url value="/static/css/bootstrap.css" var="css"/>
    <link type="text/css" rel="stylesheet" href="${css }">
</head>
<body>
<div class="container">
    <h1>Lista de Usuários</h1>
    <hr>
    <div>
        <s:url value="/usuario/cadastro" var="cadastro"/>
        <a class="btn btn-primary" href="${cadastro }">Novo Usuário</a>
    </div>
    <hr>
    <div>
        <div>
            <s:url value="/usuario/sexo" var="act_sexo"/>
            <form action="${act_sexo }" method="get">
                <div class="form-group">
                    <label for="tipoSexo">Busca por Sexo</label>
                    <select id="tipoSexo" name="tipoSexo" class="form-control">
                        <c:forEach var="sexo" items="${sexos}">
                            <option value="${sexo.desc}">${sexo.desc}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Localizar</button>
                </div>
            </form>
        </div>

        <div>
            <s:url var="act_nome" value="/usuario/nome"/>
            <form action="${act_nome}" method="get">
                <div class="form-group">
                    <label for="nome">Busca por Nome ou Sobrenome</label>
                    <input id="nome" name="nome" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Localizar</button>
                </div>
            </form>
        </div>

    </div>

    <div class="card-body">
        <div class="card-header">
            <span class="alert-success">${message == null ? '&nbsp;' : message}</span>
        </div>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOME</th>
                    <th>Data Nascimento</th>
                    <th>AÇÃO</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios }">
                    <tr>
                        <td>${usuario.id }</td>
                        <td>${usuario.nome } ${usuario.sobreNome }</td>
                        <td>
                            <f:parseDate var="date" value="${usuario.dtNascimento }" pattern="yyyy-MM-dd" type="date"/>
                            <f:formatDate value="${date }" pattern="dd/MM/yyyy" type="date"/>
                        </td>
                        <td>${usuario.sexo.desc}</td>
                        <td>
                            <s:url value="/usuario/update/${usuario.id }" var="update"/>
                            <a class="btn btn-primary" href="${update }" >Editar</a>
                            <s:url value="/usuario/delete/${usuario.id }" var="delete"/>
                            <a class="btn btn-danger" href="${delete }" >Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>
