package entities;

public class Film
{
    private int id;
    private String titre;
    private int duree;
    private String pays;
    private int idRealisateur;
    
    public Film(int id, String titre, int duree, String pays, int idRealisateur)// Permet de stocker les informations sur un film
    {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.pays = pays;
        this.idRealisateur = idRealisateur;
    }

    public int getId()
    { return id; }

    public String getTitre()
    { return titre; }

    public int getDuree()
    { return duree; }

    public String getPays()
    { return pays; }

    public int getIdRealisateur()
    { return idRealisateur; }
}
