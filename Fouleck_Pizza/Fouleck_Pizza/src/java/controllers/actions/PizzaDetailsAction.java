package controllers.actions;

import javax.servlet.http.HttpServletRequest;
import metier.entities.Pizza;
import models.PizzaDAO;

public class PizzaDetailsAction extends Action{

     @Override
    public String execute(HttpServletRequest request)
    {
        int idPizz = Integer.parseInt(request.getParameter("idPizz"));
        PizzaDAO pizzaDAO = new PizzaDAO();
        Pizza pizza = pizzaDAO.getPizza(idPizz);
        request.setAttribute("pizza", pizza);
        return "jsp/pizzaDetails.jsp";
    }

}
