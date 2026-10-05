package models;

import entities.Salle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDAO extends DAO
{
    public Salle getSalle(int idSalle) // Permet de récuperer une salle en fonction de son id
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idSalle);
        ResultSet result = super.query("SELECT id, libelle FROM salle WHERE id = ?", args);
        
        try 
        {
            result.first();
            
            return new Salle(result.getInt("id"), result.getString("libelle"));
        } 
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return null;
    }
}
