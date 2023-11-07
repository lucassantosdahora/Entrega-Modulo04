<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/styles.css">
    <link rel="stylesheet" href="./CSS/destinos.css">

    <title>Destinos</title>
</head>

<body>
    <div class="contentor">
        <div class="item header">

            <div class="corpo-logo">
                <h2 class="logo-name">viagens.com</h2>
                <img src="./IMG/logo.png" alt="" class="logo">
            </div>

            <div class="navv-list">
                <ul class="link-page">
                    <li class="link-page"><a href="index.html" class="estilo-link">Home</a></li>
                    <li class="link-page"> <a href="cadastro.jsp" class="estilo-link">Cadastro</a></li>
                </ul>
            </div>
        </div>
        <div class="item main">
            <section class="lista-destinos">
            <a href="ReadController" class="btn btn-restore">Restore</a>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Destino</th>
                            <th>PAÍS</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${destino}" var="destino">
                            <tr>
                                <td>${destino.id}</td>
                                <td>${destino.nome}</td>
                                <td>${destino.pais}</td>
                                <td>
                                    <div class="btn-container">
                                        <a href="UpdateController?id=${destino.id}" class="btn btn-success">Editar</a>
                                        <a href="DeleteController?id=${destino.id}" class="btn btn-danger">Excluir</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
        <div class="item footer">
            <h3 class="title">&copy; 2023 AgênciaViagens.com - Todos os direitos reservados.</h3>
        </div>
    </div>

</body>
</html>