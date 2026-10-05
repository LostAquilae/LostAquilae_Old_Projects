package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO extends DAO
{
    public ResultSet getPassword(String login)
    {
        List<String> args = new ArrayList<>();
        args.add(login);
        
        return super.query("SELECT password FROM utilisateur WHERE login = ?", args);
    }
}
