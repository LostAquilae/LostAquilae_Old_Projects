package controllers.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.entities.Ingredient;
import metier.logique.Metier;
import models.IngredientDAO;

public class ConfigoAction extends Action
{
    public String execute(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("login") == null)
        {
            return new AccueilAction().execute(request);
        }
        
        String[] selected = request.getParameterValues("idIngredient");
        String nom = request.getParameter("nomPizz");
        String desc = request.getParameter("descPizz");
        String prix = request.getParameter("prixPizz");
        Metier metier = new Metier();
        
        if(selected != null && selected.length != 0)
        {
            if(nom.length() != 0 && prix.length() != 0)
            {
                metier.configo(selected, nom, desc, prix);
                return new PizzasAction().execute(request);
            }
        }
        
        IngredientDAO ingredientDAO = new IngredientDAO();
        List<Ingredient> ingredients = ingredientDAO.getIngredients();
        request.setAttribute("ingredients", ingredients);

        return "jsp/configo.jsp";
    }
}
