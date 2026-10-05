package views.rewritten;

import controllers.DAOController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import views.MainView;

public class TableDragNDrop extends TransferHandler
{
    JTable table;
    public TableDragNDrop(JTable table)
    {
        this.table = table;
    }
    
    @Override
    public boolean canImport(TransferSupport info)
    {
        return true;
    }
    
    public boolean importData(TransferSupport support)
    {
        JTable.DropLocation dl = (JTable.DropLocation)support.getDropLocation();
        int row = dl.getRow();
        int column = dl.getColumn();
        
        int heures = row + 8;
        if(heures > 23)
            heures -= 24;
        
        String minStr = JOptionPane.showInputDialog("La projection débutera à " + heures + "H et combien de minutes ?");
        int min = Integer.parseInt(minStr);
        if(min < 61 && min > -1 && column > 0)
        {
            DAOController daoController = new DAOController();
            daoController.createProjection(MainView.getInstance().getDraggingPanel().getIdFilm(), heures, min, MainView.getInstance().getNumJour(), column);

            MainView.getInstance().refresh();
            return true;
        }
        else
        {
            return false;
        }
    }    
}
