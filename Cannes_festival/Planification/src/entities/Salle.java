package entities;

public class Salle
{

    public Salle(int id, String libelle)// Permet de stocker les informations sur une salle
    {
        this.id = id;
        this.libelle = libelle;
    }
    private int id;
    private String libelle;

    public int getId()
    { return id; }

    public String getLibelle()
    { return libelle; }
}
