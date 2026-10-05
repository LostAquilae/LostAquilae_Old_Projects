package models;

import entities.Competition;
import entities.Vip;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VipDAO  extends DAO
{
    public List<Vip> getVips(int idFilm) // On récupère les vips d'un film
    {
        List<Vip> vips = new ArrayList<>();
        
        List<String> args = new ArrayList<String>();
        args.add("" + idFilm);
        ResultSet result = super.query("SELECT id, nom, prenom, idCompetition, idFilm FROM vip WHERE idFilm = ?", args);
        
        try 
        {
            while(result.next())
            {
                vips.add(new Vip(result.getInt("id"), result.getString("nom"), result.getString("prenom"), result.getInt("idCompetition"), result.getInt("idFilm")));
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return vips;
    }
    
    public Vip getVip(int idVip) // On récupère un VIP en fonction de son id
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idVip);
        ResultSet result = super.query("SELECT id, nom, prenom, idCompetition, idFilm FROM vip WHERE id = ?", args);
        
        try 
        {
            result.first();
            
            return new Vip(result.getInt("id"), result.getString("nom"), result.getString("prenom"), result.getInt("idCompetition"), result.getInt("idFilm"));
        } 
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return null;
    }
}
