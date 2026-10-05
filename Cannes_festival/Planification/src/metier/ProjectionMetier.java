/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier;

import entities.Competition;
import entities.Film;
import entities.Projection;
import entities.Vip;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import models.CompetitionDAO;
import models.FilmDAO;
import models.ProjectionDAO;
import models.SalleDAO;
import models.VipDAO;

/**
 *
 * @author Rutabaga
 */
public class ProjectionMetier
{
    public void createProjection(int idFilm, int heure, int minute, int numJour, int idSalle)
    {
        FilmDAO filmDAO = new FilmDAO();
        Film film = filmDAO.getFilm(idFilm);
        
        ProjectionDAO projectionDAO = new ProjectionDAO();
        List<Projection> projections = projectionDAO.getProjections(numJour);
        
        int erreur = 0;
        int count = 0;
        
        for(Projection projection : projections)
        {
            if(projection.getIdSalle() == idSalle)
            {
                int temps = heure * 60 + minute;
                int debut = (int)TimeUnit.MILLISECONDS.toMinutes(projection.getHeure().getTime());
                Film f = filmDAO.getFilm(projection.getIdFilm());
                if(!(temps + film.getDuree() < debut || temps > debut + f.getDuree()))
                {
                    erreur = 1;
                }
                else
                {
                    VipDAO vipDAO = new VipDAO();
                    Vip real = vipDAO.getVip(film.getIdRealisateur());
                    Vip r = vipDAO.getVip(f.getIdRealisateur());
                    
                    if(real.getIdCompetition() == r.getIdCompetition())
                    {
                        count++;
                        if(count >= 3 && real.getIdCompetition() == 1)
                            erreur = 2;
                        if(count >= 4 && real.getIdCompetition() == 2)
                            erreur = 3;
                    }
                }
            }
        }
        
        if(erreur != 0)
        {
            if(erreur == 1)
                new JOptionPane().showMessageDialog(null, "Deux projections se chevauchent !", "Attention", JOptionPane.WARNING_MESSAGE);
            else if(erreur == 2)
                new JOptionPane().showMessageDialog(null, "Pas plus de 3 projections par jour pour les Longs Métrages !", "Attention", JOptionPane.WARNING_MESSAGE);
            else if(erreur == 3)
                new JOptionPane().showMessageDialog(null, "Pas plus de 4 projections par jour pour les Un Certain Regard !", "Attention", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            projectionDAO.createProjection(idFilm, heure, minute, numJour, idSalle);
        }
    }
}
