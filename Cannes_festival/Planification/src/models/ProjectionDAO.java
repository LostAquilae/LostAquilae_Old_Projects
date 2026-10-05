package models;

import entities.Projection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectionDAO extends DAO
{
    public Projection getProjection(int idProjection) // On récupère une seule projection en fonction de son id
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idProjection);
        ResultSet result = super.query("SELECT id, idFilm, idSalle, numJour, heure FROM projection WHERE id = ?", args);
        
        try 
        {
            result.first();
            
            return new Projection(result.getInt("id"), result.getInt("idFilm"), result.getInt("idSalle"), result.getInt("numJour"), result.getTime("heure"));
        } 
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return null;
    }
    
    public List<Projection> getProjections(int numJour) // On récupère toutes les projections pour un jour donné
    {
        List<String> args = new ArrayList<>();
        args.add("" + numJour);
        ResultSet result = super.query("SELECT P.id, P.idFilm, P.idSalle, P.numJour, P.heure FROM projection AS P, film AS F, vip AS V "
                + "WHERE P.idFilm = F.id AND F.idRealisateur = V.id AND P.numJour = ?", args);
        
        List<Projection> projections = new ArrayList<>();
        
        try
        {
            while(result.next())
            {
                projections.add(new Projection(result.getInt("id"), result.getInt("idFilm"), result.getInt("idSalle"), result.getInt("numJour"), result.getTime("heure")));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return projections;
    }
    
    public List<Projection> getProjections(int idCompetition, int numJour) //On récupère les projections pour une competition et un jour donné
    {
        List<String> args = new ArrayList<>();
        args.add("" + idCompetition);
        args.add("" + numJour);
        ResultSet result = super.query("SELECT P.id, P.idFilm, P.idSalle, P.numJour, P.heure FROM projection AS P, film AS F, vip AS V "
                + "WHERE P.idFilm = F.id AND F.idRealisateur = V.id AND V.idCompetition = ? AND P.numJour = ?", args);
        
        List<Projection> projections = new ArrayList<>();
        
        try
        {
            while(result.next())
            {
                projections.add(new Projection(result.getInt("id"), result.getInt("idFilm"), result.getInt("idSalle"), result.getInt("numJour"), result.getTime("heure")));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return projections;
    }
    
    public void supprimerProjection(int idProjection) // Permet de supprimer une projection
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idProjection);
        super.update("DELETE FROM projection WHERE id = ?", args);
    }
    
    public void createProjection(int idFilm, int heure, int minute, int numJour, int idSalle)
    {
        List<String> args = new ArrayList<String>();
        args.add("" + idFilm);
        args.add("" + idSalle);
        args.add("" + numJour);
        args.add("" + heure + ":" + minute + ":00");
        super.update("INSERT INTO projection (idFilm, idSalle, numJour, heure) VALUES ( ? , ? , ? , ? )", args);
    }
}
