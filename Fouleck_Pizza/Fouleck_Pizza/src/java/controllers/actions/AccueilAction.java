package controllers.actions;

import javax.servlet.http.HttpServletRequest;

public class AccueilAction extends Action
{
    @Override
    public String execute(HttpServletRequest request)
    {
        return "jsp/accueil.jsp";
    }
}
