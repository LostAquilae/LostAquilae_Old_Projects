package views.rewritten;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import views.MainView;

public class DragNDrop extends TransferHandler
{    
    @Override
    protected Transferable createTransferable(JComponent c)
    {
        MainView.getInstance().setDraggingPanel(((FilmPanel)c).getIdFilm());
        return new StringSelection(((FilmPanel)c).getTitre());
    }
    
    @Override
    public int getSourceActions(JComponent C)
    {
        return MOVE;
    }
}
