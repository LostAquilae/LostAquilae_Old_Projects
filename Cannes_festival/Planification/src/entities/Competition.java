package entities;

public class Competition {
    private int id;
    private String libelle;
    
    public Competition(int id, String libelle) // Permet de stocker les informations sur une compétition
    {
        this.id = id;
        this.libelle = libelle;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getLibelle()
    {
        return this.libelle;
    }
}
