package entities;

import java.sql.Time;

public class Projection
{
    public Projection(int id, int idFilm, int idSalle, int numJour, Time heure)// Permet de stocker les informations sur une projection
    {
        this.id = id;
        this.idFilm = idFilm;
        this.idSalle = idSalle;
        this.numJour = numJour;
        this.heure = heure;
    }
    
    private int id;
    private int idFilm;
    private int idSalle;
    private int numJour;
    private Time heure;

    public int getId()
    { return id; }

    public int getIdFilm()
    { return idFilm; }

    public int getIdSalle()
    { return idSalle; }

    public int getNumJour()
    { return numJour; }

    public Time getHeure()
    { return heure; }
}
