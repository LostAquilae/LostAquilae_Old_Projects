package entities;

public class Vip {
    private int id;
    private String nom;
    private String prenom;
    private int idCompetition;
    private int idFilm;
    
    public Vip(int id, String nom, String prenom, int idCompetition, int idFilm)// Permet de stocker les informations sur un VIP
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idCompetition = idCompetition;
        this.idFilm = idFilm;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getNom()
    {
        return this.nom;
    }
    
    public String getPrenom()
    {
        return this.prenom;
    }
    
    public int getIdCompetition()
    {
        return this.idCompetition;
    }
    
    public int getIdFilm()
    {
        return this.idFilm;
    }   
}
