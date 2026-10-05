<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/font-awesome-4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="assets/style.css">
        <title>Fouleck Pizza</title>
    </head>
    <body>
        <header>
            <section id="top">
                <a id="titre" href="home?page=accueil"><img src="assets/img/logo.png" alt="Logo" width=100><h1>Fouleck Pizza &</h1></a>
                <form id="search" action="home" method="GET">
                    <input type="hidden" name="page" value="pizzas" />
                    <input type="text" name="search" placeholder="Quelle pizza mon fouleck ?" />
                    <a href="home?page=pizzas"><i class="fa fa-search" aria-hidden="true"></i></a>
                </form>
                <aside id="user">
                    <% if(session.getAttribute("login") != null) { %>
                        <h3>Bonjour <%=session.getAttribute("login")%></h3>
                        <a class="button" href="home?page=connexion&deconnexion">Deconnexion</a>
                    <% } else { %>
                        <a href="home?page=connexion"><i class="fa fa-user-circle-o fa-5x" aria-hidden="true"></i></a>
                    <% } %>
                    <a href="home?page=error"><i class="fa fa-shopping-cart fa-5x" aria-hidden="true"></i></a>
                </aside>
            </section>
            <nav>
                <ul>
                    <li class="text">|</li>
                    <li class="text"><a href="home?page=pizzas">Pizzas</a></li>
                    <li class="icon"><a href="home?page=pizzas"><img src="assets/img/pizzas.ico" alt="Pizzas" width=40 /></a></li>
                    <li class="text">|</li>
                    <li class="text"><a href="home?page=configo">ConfigoFouleck</a></li>
                    <li class="icon"><a href="home?page=configo"><img src="assets/img/configoFouleck.png" alt="ConfigoFouleck" width=40 /></a></li>
                    <li class="text">|</li>
                    <li class="text"><a href="home?page=error">Sandwichs</a></li>
                    <li class="icon"><a href="home?page=error"><img src="assets/img/sandwichs.png" alt="Sandwichs" width=40 /></a></li>
                    <li class="text">|</li>
                    <li class="text"><a href="home?page=error">Boissons</a></li>
                    <li class="icon"><a href="home?page=error"><img src="assets/img/boissons.png" alt="Boissons" width=40 /></a></li>
                    <li class="text">|</li>
                </ul>
            </nav>
        </header>
