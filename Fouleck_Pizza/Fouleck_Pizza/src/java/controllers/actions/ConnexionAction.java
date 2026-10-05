package controllers.actions;

import javax.servlet.http.HttpServletRequest;
import metier.logique.Metier;

public class ConnexionAction extends Action
{
    @Override
    public String execute(HttpServletRequest request)
    {
        String login = request.getParameter("login");
        Metier metier = new Metier();
        if(login != null)
        {
            String password = request.getParameter("password");
            if(metier.connexion(request, login, password))
            {
                return "jsp/accueil.jsp";
            }
        }
        else if(request.getParameter("deconnexion") != null)
        {
            metier.deconnexion(request);
        }
        
        return "jsp/connexion.jsp";
    }
}
