package views.rewritten;

import entities.Competition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import views.MainView;

public class MenuBouton extends JButton
{
    public MenuBouton(JDesktopPane menuPanel, JDesktopPane planningPanel, Competition competition)
    {
        idCompetition = competition.getId();
        
        setFont(new Font("Dialog", 1, 36));
        setText(competition.getLibelle());
        
        addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                planningPanel.setVisible(true);
                menuPanel.setVisible(false);
                MainView.getInstance().changeCompetition(idCompetition);
                MainView.getInstance().setIdCompetition(idCompetition);
            }
        });
    }
    
    private int idCompetition;
}
