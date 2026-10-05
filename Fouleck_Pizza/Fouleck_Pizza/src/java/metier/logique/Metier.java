package metier.logique;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metier.entities.Pizza;
import models.*;

public class Metier
{
    public boolean connexion(HttpServletRequest request, String login, String password)
    {
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        ResultSet rs = utilisateurDAO.getPassword(login);
        
        try
        {
            rs.first();
            
            if(rs.getString("password").equals(password))
            {
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                return true;
            }
            else
                return false;
        }
        catch(SQLException e)
        {
            return false;
        }
    }
    
    public void deconnexion(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        session.invalidate();
    }
    
    public void configo(String[] selected, String name, String desc, String prixPizz)
    {
        Pizza pizza = new Pizza();
        PizzaDAO pizzaDAO = new PizzaDAO();
        IngredientDAO ingredientDAO = new IngredientDAO();
        
        float prix = Float.parseFloat(prixPizz);
        pizza.setNom(name);
        pizza.setDescription(desc);
        pizza.setPrix(prix);
        
        pizzaDAO.insertPizza(pizza);
        
        int id = pizzaDAO.getLastInsert();
        
        ingredientDAO.insertIngredients(selected, id);
    }
}

