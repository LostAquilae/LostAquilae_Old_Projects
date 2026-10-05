package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion
{
    private Connection connexion;
    private static Connexion INSTANCE;
    
    private Connexion()
    {
        try
        {
            Class.forName(config.configuration.JDBC_DRIVER);
            connexion = DriverManager.getConnection(config.configuration.DB_URL, config.configuration.username, config.configuration.password);
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static Connexion getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new Connexion();
        return INSTANCE;
    }
    
    public Connection getConnexion()
    { return connexion; }
}
