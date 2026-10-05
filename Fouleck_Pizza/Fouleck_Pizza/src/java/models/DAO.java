package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class DAO
{
    private ResultSet requete(String sql, List<String> args, boolean isQuery)
    {
        PreparedStatement preStatement;
        ResultSet rs = null;
        
        try
        {
            Connexion.getInstance().getConnexion().setAutoCommit(false);
            preStatement = Connexion.getInstance().getConnexion().prepareStatement(sql);
        
            for(int i = 0; i < args.size(); i++)
            {
                preStatement.setString(i+1, args.get(i));
            }
            
            if(isQuery)
                rs = preStatement.executeQuery();
            else
                preStatement.executeUpdate();
            Connexion.getInstance().getConnexion().commit();
        }
        catch(SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            if (Connexion.getInstance().getConnexion() != null)
            {
                try
                {
                    System.err.print("Transaction is being rolled back");
                    Connexion.getInstance().getConnexion().rollback();
                }
                catch(SQLException excep)
                {
                    System.err.println("Error : " + excep.getMessage());
                }
            }
        }
        
        try
        {
            Connexion.getInstance().getConnexion().setAutoCommit(true);
        }
        catch (SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return rs;
    }
    
    protected void update(String sql, List<String> args)
    {
        try
        {
            requete(sql, args, false);
        }
        catch(Exception e)
        {
            System.err.println("Error : " + e.getMessage());
        }
    }
    
    protected void update(String sql)
    { update(sql, new ArrayList()); }
    
    protected ResultSet query(String sql, List<String> args)
    {
        ResultSet rs = null;
        
        try
        {
            rs = requete(sql, args, true);
        }
        catch(Exception e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        return rs;
    }
    
    protected ResultSet query(String sql)
    { return query(sql, new ArrayList()); }
}