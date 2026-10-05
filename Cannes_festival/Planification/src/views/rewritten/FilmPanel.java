package views.rewritten;

import controllers.DAOController;
import entities.Film;
import entities.Vip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import metier.ChangeHoraire;
import views.MainView;

public class FilmPanel extends JPanel
{
    public void setGroupLayout()
    {
        filmPanelLayout = new GroupLayout(this);
        setLayout(filmPanelLayout);
        filmPanelLayout.setHorizontalGroup(
            filmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(vLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descFilmPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titreFilmPanel, GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        filmPanelLayout.setVerticalGroup(
            filmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titreFilmPanel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(vLine)
                    .addComponent(descFilmPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        titreFilmPanelLayout = new GroupLayout(titreFilmPanel);
        titreFilmPanel.setLayout(titreFilmPanelLayout);
        titreFilmPanelLayout.setHorizontalGroup(
            titreFilmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titreFilmPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(filmBouton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filmLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        
        titreFilmPanelLayout.setVerticalGroup(
            titreFilmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titreFilmPanelLayout.createSequentialGroup()
                .addComponent(filmLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, titreFilmPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(filmBouton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        descFilmPanelLayout = new GroupLayout(descFilmPanel);
        ParallelGroup horizontalGroup = descFilmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for(JLabel temp : equipe)
        {
            horizontalGroup.addComponent(temp);
        }
        
        descFilmPanel.setLayout(descFilmPanelLayout);
        descFilmPanelLayout.setHorizontalGroup(
            descFilmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(descFilmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(descFilmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pays)
                    .addComponent(realTitre)
                    .addComponent(equipeTitre)
                    .addGroup(descFilmPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(horizontalGroup
                            .addComponent(realisateurLabel)
                             .addComponent(tempsFilm))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        SequentialGroup verticalGroup = descFilmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pays)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempsFilm)
                .addGap(18, 18, 18)
                .addComponent(realTitre)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(realisateurLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(equipeTitre)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        
        for(JLabel temp : equipe)
        {
            verticalGroup.addComponent(temp);
        }
        
        descFilmPanelLayout.setVerticalGroup(
            descFilmPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(verticalGroup
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    public FilmPanel(int idFilm)
    {
        this.idFilm = idFilm;
        InitComponents();
    }
    
    public void InitComponents()
    {
        daoController = new DAOController();
        
        Film film = daoController.getFilm(idFilm);
        ChangeHoraire change = new ChangeHoraire(film.getDuree());
        
        List<Vip> vips = daoController.getVips(idFilm);
        
        Vip realisateur = null;
        
        for(int i = 0 ; i < vips.size() ; i++)
        {
            if(film.getIdRealisateur() == vips.get(i).getId())
            {
                realisateur = vips.get(i);
                vips.remove(i);
            }
        }
        
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        titreFilmPanel = new JPanel();
        
        filmLabel = new JLabel();
        filmLabel.setFont(new java.awt.Font("Dialog", 1, (int)(220 / film.getTitre().length())));
        filmLabel.setText(film.getTitre());
        
        filmBouton = new JButton();
        filmBouton.setFont(new java.awt.Font("Dialog", 1, 20));
        filmBouton.setText("+");
        filmBouton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!isPanelOpen)
                {
                    isPanelOpen = true;
                    filmBouton.setText("-");
                    size = 220;
                    
                    if(vips.size() > 0)
                    {
                        size += 30 + 25 * vips.size();
                    }
                }
                else
                {
                    isPanelOpen = false;
                    filmBouton.setText("+");
                    size = 63;
                }
                
                MainView.getInstance().displayFilmPanels();
            }
        });
        
        descFilmPanel = new JPanel();
        
        vLine = new JSeparator();
        vLine.setOrientation(SwingConstants.VERTICAL);
        vLine.setFont(new java.awt.Font("Dialog", 1, 18));
        
        paysTitre = new JLabel();
        paysTitre.setFont(new java.awt.Font("Dialog", 1, 18));
        paysTitre.setText("Pays");
        
        pays = new JLabel();
        pays.setFont(new java.awt.Font("Dialog", 1, 18));
        pays.setText(film.getPays());
        
        tempsFilm = new JLabel();
        tempsFilm.setFont(new java.awt.Font("Dialog", 0, 18));
        tempsFilm.setText("" + change.getHeures() + "H" + "" + change.getMinutes());
        
        realTitre = new JLabel();
        realTitre.setFont(new java.awt.Font("Dialog", 1, 18));
        realTitre.setText("Réalisateur");
        
        realisateurLabel = new JLabel();
        realisateurLabel.setFont(new java.awt.Font("Dialog", 0, 16));
        realisateurLabel.setText(realisateur.getNom()+" "+realisateur.getPrenom());
        
        equipeTitre = new JLabel();
        equipe = new ArrayList<JLabel>();
        if(vips.size() > 0)
        {
            equipeTitre.setFont(new java.awt.Font("Dialog", 1, 18));
            equipeTitre.setText("Equipe Film");

            for(Vip vip : vips)
            {
                JLabel temp = new JLabel();
                temp.setFont(new java.awt.Font("Dialog", 0, 16));
                temp.setText(vip.getNom()+" "+vip.getPrenom());
                equipe.add(temp);
            }
        }
        
        setGroupLayout();
    }
    
    private int idFilm;
    private JLabel paysTitre;
    private JLabel pays;
    private JPanel descFilmPanel;
    private List<JLabel> equipe;
    private JLabel equipeTitre;
    private JButton filmBouton;
    private JLabel filmLabel;
    private JSeparator vLine;
    private JPanel titreFilmPanel;
    private JLabel tempsFilm;
    private JLabel realTitre;
    private JLabel realisateurLabel;
    private GroupLayout filmPanelLayout;
    private GroupLayout titreFilmPanelLayout;
    private GroupLayout descFilmPanelLayout;
    private boolean isPanelOpen = false;
    private int size = 63;
    private DAOController daoController;
    
    public String getTitre()
    { return filmLabel.getText(); }
    
    public int getIdFilm()
    {
        return this.idFilm;
    }
    
    public int getPanelSize()
    { return size; }
}
