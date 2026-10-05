package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.entities.Ingredient;
import metier.entities.Pizza;

public class PizzaDAO extends DAO
{
    public List<Pizza> getPizzas()
    {
        IngredientDAO ingredientDAO = new IngredientDAO();
        List<Pizza> pizzas = new ArrayList<>();
        
        ResultSet rs = super.query("SELECT * FROM pizza");
        
        try
        {
            while(rs.next())
            {
                List<Ingredient> ingredients = ingredientDAO.getIngredients(rs.getInt("id"));
                pizzas.add(new Pizza(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getString("img"), rs.getFloat("prix"), ingredients));
            }
        }
        catch(SQLException e)
        {
            System.err.println("Erreur PizzaDAO : " + e.getMessage());
        }
        
        return pizzas;
    }
    
    public Pizza getPizza(int id)
    {        
        IngredientDAO ingredientDAO = new IngredientDAO();
        
        List<String> args = new ArrayList<>();
        args.add("" + id);
        ResultSet rs = super.query("SELECT * FROM pizza WHERE id = ?", args);
        
        try
        {
            rs.first();
            List<Ingredient> ingredients = ingredientDAO.getIngredients(id);
            return new Pizza(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getString("img"), rs.getFloat("prix"), ingredients);
        }
        catch(SQLException e)
        {
            System.err.println("Erreur PizzaDAO : " + e.getMessage());
        }
        
        return null;
    }
    
    public void insertPizza(Pizza pizza)
    {
        List<String> args = new ArrayList<>();
        args.add(pizza.getNom());
        args.add(pizza.getDescription());
        args.add("assets/img/2.png");
        args.add("" + pizza.getPrix());
        super.update("INSERT INTO pizza (nom, description, img, prix) VALUES ( ? , ? , ? , ? )", args);
    }
    
    public int getLastInsert()
    {
        ResultSet result = super.query("SELECT MAX(id) FROM pizza");
        
        try 
        {
            result.first();
            return result.getInt(1);
        } 
        catch (SQLException ex) 
        {
            System.err.println("Erreur PizzaDAO : " + ex.getMessage());
        }
        
        return -1;
    }
}
