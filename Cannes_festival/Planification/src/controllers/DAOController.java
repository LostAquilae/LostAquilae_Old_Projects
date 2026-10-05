package controllers;

import entities.*;
import java.util.List;
import metier.ProjectionMetier;
import models.*;

public class DAOController
{
    public List<Competition> getCompetitions()
    {
        return new CompetitionDAO().getCompetitions();
    }

    public Competition getCompetition(int idCompetition)
    {
        return new CompetitionDAO().getCompetition(idCompetition);
    }

    public List<Film> getFilms()
    {
        return new FilmDAO().getFilms();
    }
    
    public Film getFilm(int idFilm)
    {
        return new FilmDAO().getFilm(idFilm);
    }

    public List<Vip> getVips(int idFilm)
    {
        return new VipDAO().getVips(idFilm);
    }

    public Vip getVip(int idVip)
    {
        return new VipDAO().getVip(idVip);
    }

    public Projection getProjection(int idProjection)
    {
        return new ProjectionDAO().getProjection(idProjection);
    }
    public List<Film> getFilms(int idCompetition)
    {
        return new FilmDAO().getFilms(idCompetition);
    }
    
    public List<Projection> getProjections(int idCompetition, int numJour)
    {
        return new ProjectionDAO().getProjections(idCompetition, numJour);
    }
    
    public void supprimerProjection(int idProjection)
    {
        new ProjectionDAO().supprimerProjection(idProjection);
    }
    
    public void createProjection(int idFilm, int heure, int minute, int numJour, int idSalle)
    {
        new ProjectionMetier().createProjection(idFilm, heure, minute, numJour, idSalle);
    }
}
