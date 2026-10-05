package models;

import entities.Film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmDAO extends DAO
{
    public List<Film> getFilms() // On récupère tout les films
    {
        List<Film> films = new ArrayList<Film>();
        
        ResultSet result = super.query("SELECT id, titre, duree, pays, idRealisateur FROM film");
        
        try
        {
            while(result.next())
            {
                films.add(new Film(result.getInt("id"), result.getString("titre"), result.getInt("duree"), result.getString("pays"), result.getInt("idRealisateur")));
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return films;
    }
    
    public Film getFilm(int idFilm) // On récupère un film en fonction de son id
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idFilm);
        ResultSet result = super.query("SELECT id, titre, duree, pays, idRealisateur FROM film WHERE id = ?", args);
        
        try 
        {
            result.first();
            
            return new Film(result.getInt("id"), result.getString("titre"), result.getInt("duree"), result.getString("pays"), result.getInt("idRealisateur"));
        } 
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return null;
    }
    
    public List<Film> getFilms(int idCompetition) // On récupère tous les films d'une competition
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idCompetition);
        
        List<Film> films = new ArrayList<>();
        
        ResultSet result = super.query("SELECT F.id, titre, duree, pays, idRealisateur FROM film AS F, vip AS V "
                                        + "WHERE V.idCompetition = ? AND F.idRealisateur = V.id", args);
        
        try 
        {
            while(result.next())
            {
                films.add(new Film(result.getInt("id"), result.getString("titre"), result.getInt("duree"), result.getString("pays"), result.getInt("idRealisateur")));
            }
        } 
        catch (SQLException e) 
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return films;
    }
}
