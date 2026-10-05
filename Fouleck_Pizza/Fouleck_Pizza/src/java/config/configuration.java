package config;

public class configuration
{
    /* --- DAO Connection --- */
    public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public final static String BD_NAME = "fouleck";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/" + BD_NAME + "?zeroDateTimeBehavior=convertToNull";
    
    public final static String username = "root";
    public final static String password = "";
}
