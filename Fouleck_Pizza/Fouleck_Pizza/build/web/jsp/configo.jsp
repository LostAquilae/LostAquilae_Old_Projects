<%@page import="metier.entities.Ingredient"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>

</body>
<head>
    <link rel="stylesheet" type="text/css" href="assets/connexionStyle.css">
</head>
<body>
    <div id="corps">   
        <% List<Ingredient> ingredients = (List<Ingredient>)request.getAttribute("ingredients"); %>
        <article class="texte" id="head">
            <h2>Bienvenue dans le <strong>ConfigoFouleck !</strong></h2>
            <p>Parce que l'on est jamais mieux servis que par soi-même, c'est ici que tu peux venir créer ta propre pizza de <strong>Fouleck</strong> afin de faire ressortir ta <strong>Fouleckitude</strong> comme jamais !</p>
            <p>Épatez-nous avec vos plus belles configs de pizza, et les meilleurs pourront même figurer dans la carte à l'avenir !</p>
            <p class="grand"><strong>À vos clavier !</strong></p>
        </article>
        <form method="post" action="home">
            <article class="form ingredients">
                <h3>Quelles ingrédients veut-tu mon <strong>Fouleck ?</strong></h3>
                <input type="hidden" name="page" value="configo" />
                <ul>
                    <% for(Ingredient ingredient : ingredients)
                    { %>
                    <li><label for="<%= ingredient.getNom() %>"><span><%= ingredient.getNom() %></span></label><input name="idIngredient" value="<%= ingredient.getId() %>" type="checkbox" id="<%= ingredient.getNom() %>"></li>
                 <% } %>
                </ul>
            </article>
            <div class="form">
                <label for="nom">Nom de votre pizza</label>
                    <input type="text" name="nomPizz" placeholder="Choisi le meilleur nom pour ta pizza mon Fouleck !" id="nom" />
                <label for="description">Description de votre pizza</label>
                    <input type="textarea" name="descPizz" placeholder="Ici tu expliques pourquoi c'est la meilleure !" id="description" />
                <label for="prix">Le prix</label>
                    <input type="text" name="prixPizz" placeholder="Entre le prix de ta pizza mon Fouleck !" id="prix" />
            </div>
            <input class="button" type="submit" value="valider" />
        </form>
    </div>
<%@ include file="footer.jsp" %>