<%@ include file="header.jsp" %>
</body>
<head>
    <link rel="stylesheet" type="text/css" href="assets/connexionStyle.css">
</head>
<body>
    <div id="corps">   
        <section class="texte" id="head">
            <h2>Connexion de <strong>Fouleck</strong> !</h2>
            <h4 class="petit">(t'es un vrai petit <strong>Fouleck</strong> toi)</h4>
        </section>
        <section id="invité">
            <form action="home" method="post">
                <input type="hidden" name="page" value="connexion" />
                <div class="form">
                    <label for="login">Nom d'utilisateur</label>
                        <input type="text" id="login" name="login" placeholder="Ton pseudo digne de Florent Duclos ! <3">
                    <label for="password">Mot de passe</label>
                        <input type="password" id="password" name="password" placeholder="Ton mot de passe ultra secure !">
                </div>
                <input type="submit" class="button" value="Let's go !">
            </form>
        </section>
    </div>
<%@ include file="footer.jsp" %>