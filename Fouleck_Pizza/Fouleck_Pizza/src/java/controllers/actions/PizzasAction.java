package controllers.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.entities.Pizza;
import models.PizzaDAO;

public class PizzasAction extends Action
{
    @Override
    public String execute(HttpServletRequest request)
    {
        PizzaDAO pizzaDAO = new PizzaDAO();
        List<Pizza> pizzas = pizzaDAO.getPizzas();
        
        request.setAttribute("pizzas", pizzas);
        
        return "jsp/pizzas.jsp";
    }
}
