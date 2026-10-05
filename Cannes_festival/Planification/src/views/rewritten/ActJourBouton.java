/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.rewritten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.MainView;

/**
 *
 * @author slx
 */
public class ActJourBouton implements ActionListener
{
    public ActJourBouton(int numJour)
    {
        this.numJour = numJour;
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        MainView.getInstance().setNumJour(numJour);
        System.out.println(MainView.getInstance().getNumJour());
        MainView.getInstance().changeJour(numJour);
    }
    
    private int numJour;
}
