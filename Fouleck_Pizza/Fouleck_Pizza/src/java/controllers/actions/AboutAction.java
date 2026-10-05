package controllers.actions;

import javax.servlet.http.HttpServletRequest;

public class AboutAction extends Action
{
    @Override
    public String execute(HttpServletRequest request)
    {
        return "jsp/about.jsp";
    }
    
}
