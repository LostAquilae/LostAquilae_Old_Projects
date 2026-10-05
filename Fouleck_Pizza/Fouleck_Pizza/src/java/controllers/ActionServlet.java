package controllers;

import controllers.actions.ConfigoAction;
import controllers.actions.AccueilAction;
import controllers.actions.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String page = request.getParameter("page");
        RequestDispatcher rd = null;
        String vue = null;
        Action action = null;
        
        if(page != null)
        {
            switch(page)
            {
                case "connexion":
                    action = new ConnexionAction();
                    break;
                    
               case "error":
                    action = new ErrorAction();
                    break;
                    
               case "pizzas":
                    action = new PizzasAction();
                    break;
                   
               case "pizzaDetails":
                    action = new PizzaDetailsAction();
                    break;
                   
               case "about":
                    action = new AboutAction();
                    break;
               
               case "configo":
                    action = new ConfigoAction();
                    break;

                default:
                    action = new AccueilAction();
            }
        }
        else
        {
            action = new AccueilAction();
        }
        
        vue = action.execute(request);
        rd = request.getRequestDispatcher(vue);
        rd.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}


