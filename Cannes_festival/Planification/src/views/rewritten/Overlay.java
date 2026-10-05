package views.rewritten;

import java.awt.Component;
import java.awt.Container;
import javax.swing.OverlayLayout;

public class Overlay extends OverlayLayout
{

    public Overlay(Container target)
    {
        super(target);
    }
    
    @Override
    public void layoutContainer(Container target)
    {
        int nChildren = target.getComponentCount();
        for (int i = 0; i < nChildren; i++)
        {
            Component c = target.getComponent(i);
            c.setBounds(c.getLocation().x, c.getLocation().y, 
            c.getPreferredSize().width, c.getPreferredSize().height);
        }
    }
}
