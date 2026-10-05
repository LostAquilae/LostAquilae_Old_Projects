package views.rewritten;

import controllers.DAOController;
import entities.Film;
import entities.Projection;
import entities.Vip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import views.MainView;

public class FilmBlock extends JPanel implements MouseListener
{
    private void setGroupLayout(int h)
    {
        filmBlockLayout = new GroupLayout(this);
        setLayout(filmBlockLayout);
        filmBlockLayout.setHorizontalGroup(
            filmBlockLayout.createSequentialGroup()
                .addGap(2)
                .addGroup(filmBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titreFilm, 132, 132, 132)
                    .addComponent(realisateur)
                    .addComponent(duree))
                .addGap(2)
        );
        filmBlockLayout.setVerticalGroup(
            filmBlockLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(filmBlockLayout.createSequentialGroup()
                .addComponent(titreFilm)
                .addComponent(realisateur)
                .addComponent(duree))
            .addGap(h)
        );
    }
           
    public FilmBlock(int idProjection)
    {
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        DAOController daoController = new DAOController();
        Projection projection = daoController.getProjection(idProjection);
        Film film = daoController.getFilm(projection.getIdFilm());
        
        this.idProjection = idProjection;
        
        /* --- Position --- */
        int h = (int)(film.getDuree() * 5 / 6);
        
        int xPos = 60 + (projection.getIdSalle() - 1) * 167;
        
        int min = (int)TimeUnit.MILLISECONDS.toMinutes((int)projection.getHeure().getTime()) + 60;
        
        if(min < 180) // Entre 0 et 2H59
        {
            min += 1440;
        }
        min -= 480;
        int yPos = min * 5 / 6; // - 8H
        
        setLocation(xPos, yPos);
        setMinimumSize(new Dimension(136, h));
        /* ---- */
        
        /* --- Text --- */
        titreFilm = new JLabel(film.getTitre());
        titreFilm.setFont(new java.awt.Font("Dialog", 1, (int)(250 / film.getTitre().length())));
        duree = new JLabel("" + film.getDuree() / 60 + "H" + film.getDuree() % 60);
        duree.setFont(new java.awt.Font("Dialog", 1, 15));
        
        Vip real = daoController.getVip(film.getIdRealisateur());
        realisateur = new JLabel(real.getNom() + " " + real.getPrenom());
        realisateur.setFont(new java.awt.Font("Dialog", 1, 12));
        
        addMouseListener(this);
        
        setGroupLayout(h);
        /* ---- */
    }
    
    private int idProjection;
    private JLabel titreFilm;
    private JLabel realisateur;
    private JLabel duree;
    
    private GroupLayout filmBlockLayout;
    
    public int getIdProjection()
    { return idProjection; }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        MainView.getInstance().setBlockSelected(idProjection);
        setBackground(Color.CYAN);
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
