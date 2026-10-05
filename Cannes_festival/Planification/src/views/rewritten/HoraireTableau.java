package views.rewritten;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class HoraireTableau extends JTable
{
    public HoraireTableau()
    {
        setColumnSelectionAllowed(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setDragEnabled(true);
        setName("");
        setRequestFocusEnabled(false);
        setRowHeight(50);
        getTableHeader().setReorderingAllowed(false);
        getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (getColumnModel().getColumnCount() > 0)
        {
            getColumnModel().getColumn(0).setMinWidth(45);
            getColumnModel().getColumn(0).setPreferredWidth(45);
            getColumnModel().getColumn(0).setMaxWidth(45);
            getColumnModel().getColumn(1).setResizable(false);
            getColumnModel().getColumn(2).setResizable(false);
            getColumnModel().getColumn(3).setResizable(false);
            getColumnModel().getColumn(4).setResizable(false);
            getColumnModel().getColumn(5).setResizable(false);
        }
    }
    
    private static final String[] COLUMN_NAMES = new String[] {"Heure", "Le Grand Théâtre Lumière", "La salle Debussy", "La salle Buñuel", "La salle du Soixantième", "La salle Bazin"};
    private static final Class[] COLUMN_TYPES = new Class[] {String.class, String.class, String.class,  String.class, String.class, String.class};
    
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
    String[][] tab = new String[][]
            {
                {"8h", null, null, null, null, null},
                {"9h", null, null, null, null, null},
                {"10h", null, null, null, null, null},
                {"11h", null, null, null, null, null},
                {"12h", null, null, null, null, null},
                {"13h", null, null, null, null, null},
                {"14h", null, null, null, null, null},
                {"15h", null, null, null, null, null},
                {"16h", null, null, null, null, null},
                {"17h", null, null, null, null, null},
                {"18h", null, null, null, null, null},
                {"19h", null, null, null, null, null},
                {"20h", null, null, null, null, null},
                {"21h", null, null, null, null, null},
                {"22h", null, null, null, null, null},
                {"23h", null, null, null, null, null},
                {"00h", null, null, null, null, null},
                {"01h", null, null, null, null, null},
                {"02h", null, null, null, null, null}
            };
    
    @Override
    public int getRowCount() {
        return 19;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return COLUMN_TYPES [columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return tab[rowIndex][columnIndex];
    }
    
    @Override public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }
}
    

