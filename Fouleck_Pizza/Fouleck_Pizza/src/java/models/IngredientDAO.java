/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Ingredient;

/**
 *
 * @author slx
 */
public class IngredientDAO extends DAO {
    public List<Ingredient> getIngredients(int idPizza)
    {
        List<Ingredient> ingredients = new ArrayList<>();
        List<String> args = new ArrayList<>();
        args.add("" + idPizza);
        ResultSet result = super.query("SELECT I.id, I.nom FROM ingredient AS I, ingredient_pizza AS IP "
                + "WHERE I.id = IP.idIngredient AND IP.idPizza = ?", args);
        
        try
        {
            while(result.next())
            {
                ingredients.add(new Ingredient(result.getInt("id"), result.getString("nom")));
            }
        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
        
        return ingredients;
    }
    
    public List<Ingredient> getIngredients()
    {
        List<Ingredient> ingredients = new ArrayList<>();
        ResultSet result = super.query("SELECT id, nom From ingredient");
        
        try
        {
            while(result.next())
            {
                ingredients.add(new Ingredient(result.getInt("id"), result.getString("nom")));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Erreur : " + e.getMessage());
        }
        
        return ingredients;
    }
    
    public void insertIngredients(String[] selected, int id)
    {
        for(int i = 0 ; i < selected.length ; i++)
        {
            List<String> args = new ArrayList<>();
            args.add("" + id);
            args.add(selected[i]);
            super.update("INSERT INTO ingredient_pizza (idPizza, idIngredient) VALUES ( ? , ? )", args);
        }
        
    }
}
