package controllers.actions;

import javax.servlet.http.HttpServletRequest;

public abstract class Action
{
    public abstract String execute(HttpServletRequest request);
}
