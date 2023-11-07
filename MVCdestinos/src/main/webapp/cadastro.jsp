<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./CSS/styles.css">
    <link rel="stylesheet" href="./CSS/cadastro.css">

    <title>Cadastrar</title>
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
                    <li class="link-page"> <a href="ReadController" class="estilo-link">Destinos</a></li>
                </ul>
            </div>
        </div>
        <div class="item main">
            <section class="formulario">
                <h2 class="title-form">Formulario</h2>
                <form class="form-corpo" action="CreateController" method="post">
					<div class="form-group">
						<label for="nome">Destino:</label> <input type="text"
							class="form-control" id="nome" name="nome" required>
					</div>
                    <div class="form-group">
						<label for="pais">Pais:</label> <input type="text"
							class="form-control" id="pais" name="pais" required>
					</div>
					<button type="submit" class="btn">Cadastrar</button>
				</form>
            </section>
        </div>
        <div class="item footer">
            <h3 class="title">&copy; 2023 AgênciaViagens.com - Todos os direitos reservados.</h3>
        </div>
    </div>

</body>
</html>