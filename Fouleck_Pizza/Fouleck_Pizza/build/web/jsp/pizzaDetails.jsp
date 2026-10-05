<%@page import="metier.entities.Ingredient"%>
<%@page import="metier.entities.Pizza"%>
<%@ include file="header.jsp" %>

</body>
<head>
    <link rel="stylesheet" type="text/css" href="assets/detailPizzaStyle.css">
</head>
<body>
    <div id="corps">
        <% Pizza pizza = (Pizza)request.getAttribute("pizza"); %>
        <article class="texte" id="pizza">
            <h2><%= pizza.getNom() %></h2>
            <div class="pizza">
                <img src="assets/img/5.png" alt="La Fouleck">
                <div class="ingredients">
                    <h3>Ingredients</h3>
                    <ul class="La_Fouleck">
                    <% for(Ingredient ingredient : pizza.getIngredients())
                       {%>
                           <li><%= ingredient.getNom() %></li>
                      <% }
                    %>
                    </ul>
                </div>
            </div>
            <a href="home?page=error">Ajouter au panier</a>
            <p><%= pizza.getDescription() %></p>
        </article>
        <article class="texte" id="commentaires">
            <h2>Vos Meilleurs <strong>Commentaires</strong></h2>
            <ul>
                <li>
                    <h3>Le_meilleur_des_Foulecks</h3>
                    <h4>(28/12/2017 16:27)</h4>
                    <p>J'adore cette pizza, elle a un goût exceptionnel ! Je me sens plus <strong>Fouleck</strong> que jamais en me déléctant de cette délicieuse pâte garnie des meilleurs ingrédients !</p>
                </li><li>
                    <h3>Fouleck_pour_toujours</h3>
                    <h4>(29/12/2017 01:58)</h4>
                    <p>J'adore votre site ! En tant que <strong>Fouleck</strong> depuis mon plus jeune âge, ce site me réjouis et m'empèche de me sentir seul. Sinon, j'adore vos pizzas de <strong>Fouleck</strong>, eheh.</p>
                </li>
            </ul>
            <form action="enDeveloppement.html">
                <textarea placeholder="Un commentaire de Fouleck" rows="2" cols="40"></textarea>
                <button>Poste mon <strong>Fouleck</strong></button>
            </form>
        </article>
    </div>
<%@ include file="footer.jsp" %>