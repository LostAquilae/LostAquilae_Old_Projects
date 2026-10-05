package controllers.actions;

import javax.servlet.http.HttpServletRequest;

public class ErrorAction extends Action
{
    @Override
    public String execute(HttpServletRequest request)
    {
        return "jsp/error.jsp";
    }
}
