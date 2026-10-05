<%@page import="metier.entities.Ingredient"%>
<%@page import="java.util.List"%>
<%@page import="metier.entities.Pizza"%>
<%@page import="java.util.ArrayList"%>
</body>
<head>
    <link rel="stylesheet" type="text/css" href="assets/pizzasStyle.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div id="corps">   
        <% List<Pizza> pizza = (ArrayList)request.getAttribute("pizzas"); 
            for(Pizza pizz : pizza)
            { %>
                <article class="pizza">
                    <a href="home?page=pizzaDetails&idPizz=<%=pizz.getId()%>">
                        <h2><%=pizz.getNom()%></h2>
                         <ul class="ingredients" id="ingredients1">
                         <%for(Ingredient ingredient : pizz.getIngredients())
                           {%>
                               <li><%=ingredient.getNom()%></li>
                          <%}%>
                         </ul>
                         <img src="<%=pizz.getImg()%>" alt="image"/>
                         <h3><%=pizz.getPrix()%></h3>
                    </a>
                </article>
            <% }%>
    </div>
    <%@ include file="footer.jsp" %>
