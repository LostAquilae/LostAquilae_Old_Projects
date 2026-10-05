package models;

import entities.Competition;
import entities.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDAO extends DAO
{
    public List<Competition> getCompetitions() // on recupère toutes les compétitions
    {
        List<Competition> competitions = new ArrayList<Competition>();
        
        ResultSet result = super.query("SELECT id, libelle FROM competition");
        
        try
        {
            while(result.next())
            {
                competitions.add(new Competition(result.getInt("id"), result.getString("libelle")));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return competitions;
    }
    
    public Competition getCompetition(int idCompetition) // On récupère une compétition
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idCompetition);
        ResultSet result = super.query("SELECT id, libelle FROM competition WHERE id = ?", args);
        
        try 
        {
            result.first();
            return new Competition(result.getInt("id"), result.getString("libelle"));
        } 
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return null;
    }
            
}
