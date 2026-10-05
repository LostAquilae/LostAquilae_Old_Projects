package views;

import java.awt.Dimension;
import views.rewritten.*;
import controllers.*;
import entities.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public class MainView extends JFrame
{
    // Constructeur
    public MainView()
    {
        initComponents();
    }

    private void initComponents()
    {
        setTitle("Festival de Cannes - Planning");

        /* --- Initialisations composants --- */
        planningPanel = new JDesktopPane();
        genererPlanningBouton = new JButton();
        suppProjectionBouton = new JButton();
        jourBoutonBar = new JPanel();
        jourBouton13 = new JToggleButton();
        jourBouton14 = new JToggleButton();
        jourBouton15 = new JToggleButton();
        jourBouton16 = new JToggleButton();
        jourBouton17 = new JToggleButton();
        jourBouton18 = new JToggleButton();
        jourBouton19 = new JToggleButton();
        jourBouton20 = new JToggleButton();
        jourBouton21 = new JToggleButton();
        jourBouton22 = new JToggleButton();
        jourBouton23 = new JToggleButton();
        jourBouton24 = new JToggleButton();
        jourBouton25 = new JToggleButton();
        jourGroup = new ButtonGroup();
        jourGroup.add(jourBouton13);
        jourGroup.add(jourBouton14);
        jourGroup.add(jourBouton15);
        jourGroup.add(jourBouton17);
        jourGroup.add(jourBouton16);
        jourGroup.add(jourBouton18);
        jourGroup.add(jourBouton19);
        jourGroup.add(jourBouton20);
        jourGroup.add(jourBouton21);
        jourGroup.add(jourBouton22);
        jourGroup.add(jourBouton23);
        jourGroup.add(jourBouton24);
        jourGroup.add(jourBouton25);
        logo = new JLabel();
        retourBouton = new JButton();
        filmsScrollPanel = new JScrollPane();
        filmsPanel = new JPanel();
        filmPanels = new ArrayList<FilmPanel>();
        planningTabScrollPanel = new JScrollPane();
        planningTabPanel = new JPanel();
        planningTabOverlay = new JTable();
        menuPanel = new JDesktopPane();
        titreMenu = new JLabel();
        logoMenu = new JLabel();
        daoController = new DAOController();
        competitionBoutons = new ArrayList<>();
        planningTabGeneralPanel = new JPanel(new BorderLayout());
        LayoutManager overlay = new Overlay(planningTabPanel);
        idCompetition = 0;
        selectedCompetition = new JLabel();
        selectedCompetition.setFont(new java.awt.Font("Dialog", 1, 30));
        filmBlocks = new ArrayList<FilmBlock>();

        /* --------------------------- */

        /* --- IHM --- */
        ajoutFilm = new JButton("+");
        ajoutFilm.setFont(new java.awt.Font("Dialog", 1, 14));
        suppFilm = new JButton("-");
        suppFilm.setFont(new java.awt.Font("Dialog", 1, 14));

        planningPanel.setVisible(false);
        menuPanel.setVisible(true);

        List<Competition> competitions = daoController.getCompetitions();
        for(Competition competition : competitions)
        {
            competitionBoutons.add(new MenuBouton(menuPanel, planningPanel, competition));
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        genererPlanningBouton.setFont(new java.awt.Font("Dialog", 1, 24));
        genererPlanningBouton.setText("Génerer le planning");

        suppProjectionBouton.setFont(new java.awt.Font("Dialog", 1, 18));
        suppProjectionBouton.setText("Supprimer projection");
        suppProjectionBouton.setVisible(false);
        suppProjectionBouton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                daoController.supprimerProjection(blockSelected);
                refresh();
                blockSelected = 0;
                suppProjectionBouton.setVisible(false);
            }
        });

        jourBoutonBar.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jourBouton13.setText("13");
        jourBouton13.setSelected(true);
        jourBouton13.addActionListener(new ActJourBouton(13));

        jourBouton14.setText("14");
        jourBouton14.addActionListener(new ActJourBouton(14));

        jourBouton15.setText("15");
        jourBouton15.addActionListener(new ActJourBouton(15));

        jourBouton16.setText("16");
        jourBouton16.addActionListener(new ActJourBouton(16));

        jourBouton17.setText("17");
        jourBouton17.addActionListener(new ActJourBouton(17));

        jourBouton18.setText("18");
        jourBouton18.addActionListener(new ActJourBouton(18));

        jourBouton19.setText("19");
        jourBouton19.addActionListener(new ActJourBouton(19));

        jourBouton20.setText("20");
        jourBouton20.addActionListener(new ActJourBouton(20));

        jourBouton21.setText("21");
        jourBouton21.addActionListener(new ActJourBouton(21));

        jourBouton22.setText("22");
        jourBouton22.addActionListener(new ActJourBouton(22));

        jourBouton23.setText("23");
        jourBouton23.addActionListener(new ActJourBouton(23));

        jourBouton24.setText("24");
        jourBouton24.addActionListener(new ActJourBouton(24));

        jourBouton25.setText("25");
        jourBouton25.addActionListener(new ActJourBouton(25));

        GroupLayout jourBoutonBarLayout = new GroupLayout(jourBoutonBar);
        jourBoutonBar.setLayout(jourBoutonBarLayout);
        jourBoutonBarLayout.setHorizontalGroup(
            jourBoutonBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jourBoutonBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jourBouton13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jourBouton14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton15, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton16, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton17, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton18, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton19, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton20, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton21, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton22, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton23, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton24, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jourBouton25, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jourBoutonBarLayout.setVerticalGroup(
            jourBoutonBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jourBoutonBarLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jourBoutonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jourBouton13)
                    .addComponent(jourBouton23)
                    .addComponent(jourBouton24)
                    .addComponent(jourBouton25)
                    .addComponent(jourBouton21)
                    .addComponent(jourBouton22)
                    .addComponent(jourBouton20)
                    .addComponent(jourBouton19)
                    .addComponent(jourBouton18)
                    .addComponent(jourBouton17)
                    .addComponent(jourBouton16)
                    .addComponent(jourBouton15)
                    .addComponent(jourBouton14))
                .addContainerGap())
        );

        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon(getClass().getResource("/images/logo.png")));
        logo.setFocusable(false);

        retourBouton.setFont(new java.awt.Font("Dialog", 1, 18));
        retourBouton.setIcon(new ImageIcon(getClass().getResource("/images/arrow.png")));
        retourBouton.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                planningPanel.setVisible(false);
                menuPanel.setVisible(true);
            }
        });

        filmsScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        filmsScrollPanel.setViewportView(filmsPanel);

        planningTabScrollPanel.setHorizontalScrollBar(null);

        planningTabOverlay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
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
            },
            new String []
            {
                "Heure", "Le Grand Théâtre Lumière", "La salle Debussy", "La salle Buñuel", "La salle du Soixantième", "La salle Bazin"
            }
        ) {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        planningTabOverlay.setColumnSelectionAllowed(true);
        planningTabOverlay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        planningTabOverlay.setDragEnabled(true);
        planningTabOverlay.setName("");
        planningTabOverlay.setRequestFocusEnabled(false);
        planningTabOverlay.setRowHeight(50);
        planningTabOverlay.getTableHeader().setReorderingAllowed(false);
        planningTabScrollPanel.setViewportView(planningTabPanel);
        planningTabOverlay.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (planningTabOverlay.getColumnModel().getColumnCount() > 0)
        {
            planningTabOverlay.getColumnModel().getColumn(0).setMinWidth(45);
            planningTabOverlay.getColumnModel().getColumn(0).setPreferredWidth(45);
            planningTabOverlay.getColumnModel().getColumn(0).setMaxWidth(45);
            planningTabOverlay.getColumnModel().getColumn(1).setResizable(false);
            planningTabOverlay.getColumnModel().getColumn(2).setResizable(false);
            planningTabOverlay.getColumnModel().getColumn(3).setResizable(false);
            planningTabOverlay.getColumnModel().getColumn(4).setResizable(false);
            planningTabOverlay.getColumnModel().getColumn(5).setResizable(false);
        }

        planningPanel.setLayer(genererPlanningBouton, JLayeredPane.DEFAULT_LAYER);
        planningPanel.setLayer(suppProjectionBouton, JLayeredPane.DEFAULT_LAYER);
        planningPanel.setLayer(jourBoutonBar, JLayeredPane.DEFAULT_LAYER);
        planningPanel.setLayer(logo, JLayeredPane.DEFAULT_LAYER);
        planningPanel.setLayer(retourBouton, JLayeredPane.DEFAULT_LAYER);
        planningPanel.setLayer(filmsScrollPanel, JLayeredPane.DEFAULT_LAYER);
        planningPanel.setLayer(planningTabGeneralPanel, JLayeredPane.DEFAULT_LAYER);

        planningTabPanel.setLayout(overlay);

        planningTabPanel.add(planningTabOverlay);
        planningTabOverlay.setTransferHandler(new TableDragNDrop(planningTabOverlay));

        planningTabOverlay.setPreferredSize(new Dimension(880, 950));

        planningTabOverlay.setEnabled(false);

        planningTabGeneralPanel.add(planningTabOverlay.getTableHeader(), BorderLayout.NORTH);
        planningTabGeneralPanel.add(planningTabScrollPanel, BorderLayout.CENTER);

        titreMenu.setFont(new java.awt.Font("Dialog", 1, 60));
        titreMenu.setText("Gestion du planning");

        logoMenu.setHorizontalAlignment(SwingConstants.CENTER);
        logoMenu.setIcon(new ImageIcon(getClass().getResource("/images/logo.png")));
        logoMenu.setFocusable(false);

        menuPanel.setLayer(titreMenu, JLayeredPane.DEFAULT_LAYER);
        menuPanel.setLayer(logoMenu, JLayeredPane.DEFAULT_LAYER);

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);

        /* Horizontal Group */

        GroupLayout.ParallelGroup groupHorizontalCompetitionBoutons = menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        for(MenuBouton competitionBouton : competitionBoutons)
        {
            groupHorizontalCompetitionBoutons.addComponent(competitionBouton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE);
        }

        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addComponent(titreMenu)
                        .addGap(40, 40, 40)
                        .addComponent(logoMenu, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGroup(groupHorizontalCompetitionBoutons)
                        .addGap(426, 426, 426))))
        );

        /* ----- */

        /* Vertical group */
        GroupLayout.SequentialGroup groupVerticalCompetitionBoutons = menuPanelLayout.createSequentialGroup();
        groupVerticalCompetitionBoutons.addGap(42, 42, 42);
        groupVerticalCompetitionBoutons.addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(logoMenu, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addComponent(titreMenu)
                        .addGap(39, 39, 39)));
        for(int i = 0; i < competitionBoutons.size() - 1; i++)
        {
            groupVerticalCompetitionBoutons.addComponent(competitionBoutons.get(i));
            groupVerticalCompetitionBoutons.addGap(18, 18, 18);
        }
        groupVerticalCompetitionBoutons.addComponent(competitionBoutons.get(competitionBoutons.size() - 1));
        groupVerticalCompetitionBoutons.addContainerGap(80, Short.MAX_VALUE);

        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(groupVerticalCompetitionBoutons));

        /* ------ */

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1261, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menuPanel)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(planningPanel)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menuPanel)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(planningPanel)
                    .addContainerGap()))
        );

        /* ------------------------------------------------ */

        setSize(1215, 700);
        setResizable(true);
    }

    // Main
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                instance = new MainView();
                instance.setVisible(true);
            }
        });
    }

    // Singleton
    public static MainView getInstance()
    { return instance; }

    /* --- Drag --- */
    public FilmPanel getDraggingPanel()
    {
        for(FilmPanel filmPanel : filmPanels)
        {
            if(filmPanel.getIdFilm() == draggingPanel)
                return filmPanel;
        }
        return null;
    }

    public void setDraggingPanel(int draggingPanel)
    { this.draggingPanel = draggingPanel; }
    /* ------------ */

    /* --- selection --- */
    public void setBlockSelected(int idProjection)
    {
        suppProjectionBouton.setVisible(true);
        for(FilmBlock filmBlock : filmBlocks)
        {
            filmBlock.setBackground(UIManager.getColor("Panel.background"));
        }
        blockSelected = idProjection;
    }
    /* ----------------- */

    public void changeCompetition(int idCompetition)
    {
        this.idCompetition = idCompetition;
        selectedCompetition.setText(daoController.getCompetition(idCompetition).getLibelle());
        refresh();
    }

    /* --- UI --- */
    public void refresh()
    {
        filmPanels.clear();
        filmBlocks.clear();
        planningTabPanel.removeAll();
        filmsPanel.removeAll();

        List<Film> films = daoController.getFilms(idCompetition);
        for(Film film : films)
        {
            FilmPanel filmPanel = new FilmPanel(film.getId());
            filmPanels.add(filmPanel);
            filmPanel.setTransferHandler(new DragNDrop());
            filmPanel.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent me)
                {
                    JComponent comp = (JComponent)me.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, me, TransferHandler.MOVE);
                }
            });
        }

        List<Projection> projections = daoController.getProjections(idCompetition, numJour);
        for(Projection projection : projections)
        {
            FilmBlock filmBlock = new FilmBlock(projection.getId());
            filmBlocks.add(filmBlock);
            planningTabPanel.add(filmBlock);
        }
        planningTabPanel.add(planningTabOverlay);

        displayFilmPanels();
    }

    public void changeJour(int numJour)
    {
        planningTabPanel.removeAll();
        filmBlocks.clear();

        List<Projection> projections = daoController.getProjections(idCompetition, numJour);
        for(Projection projection : projections)
        {
            FilmBlock filmBlock = new FilmBlock(projection.getId());
            filmBlocks.add(filmBlock);
            planningTabPanel.add(filmBlock);
        }

        planningTabPanel.add(planningTabOverlay);

        displayFilmPanels();
    }

    public void displayFilmPanels()
    {
        filmsPanelLayout = new GroupLayout(filmsPanel);
        ParallelGroup group = filmsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false);
        for(FilmPanel panel : filmPanels)
        {
            group.addComponent(panel, GroupLayout.DEFAULT_SIZE, 210, 210);
        }

        filmsPanel.setLayout(filmsPanelLayout);
        filmsPanelLayout.setHorizontalGroup(
            filmsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(filmsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        SequentialGroup verticalGroup = filmsPanelLayout.createSequentialGroup();
        verticalGroup.addContainerGap();
        for(FilmPanel panel : filmPanels)
        {
            verticalGroup.addComponent(panel, GroupLayout.PREFERRED_SIZE, panel.getPanelSize(), GroupLayout.PREFERRED_SIZE);
            verticalGroup.addGap(15);
        }

        filmsPanelLayout.setVerticalGroup(
            filmsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(verticalGroup)
        );

        planningPanelLayout = new GroupLayout(planningPanel);
        planningPanel.setLayout(planningPanelLayout);
        planningPanelLayout.setHorizontalGroup(
            planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(planningPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(planningPanelLayout.createSequentialGroup()
                                .addComponent(retourBouton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(300))
                            .addGroup(GroupLayout.Alignment.TRAILING, planningPanelLayout.createSequentialGroup()
                                .addComponent(suppProjectionBouton)
                                .addGap(30))
                            .addGroup(GroupLayout.Alignment.TRAILING, planningPanelLayout.createSequentialGroup()
                                .addComponent(selectedCompetition)
                                .addGap(25)))
                        .addGap(50)
                        .addComponent(genererPlanningBouton)
                        .addGap(163, 163, 163)
                        .addComponent(logo, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addGroup(planningPanelLayout.createParallelGroup()
                            .addGroup(planningPanelLayout.createSequentialGroup()
                                .addComponent(suppFilm)
                                .addComponent(ajoutFilm))
                            .addComponent(filmsScrollPanel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jourBoutonBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(planningTabGeneralPanel))))
                .addContainerGap())
        );
        planningPanelLayout.setVerticalGroup(
            planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(planningPanelLayout.createSequentialGroup()
                .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(selectedCompetition))
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(genererPlanningBouton))
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(planningPanelLayout.createSequentialGroup()
                                .addComponent(retourBouton)
                                .addGap(4, 4, 4)
                                .addComponent(suppProjectionBouton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addComponent(logo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addComponent(jourBoutonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(planningTabGeneralPanel, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addGroup(planningPanelLayout.createParallelGroup()
                            .addComponent(ajoutFilm)
                            .addComponent(suppFilm))
                        .addGap(5)
                        .addComponent(filmsScrollPanel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }
    /* -------------------------- */

    /* --- Variables --- */
    public void setNumJour(int numJour)
    {
        this.numJour = numJour;
    }

    public void setIdCompetition(int idCompetition)
    {
        this.idCompetition = idCompetition;
    }

    public int getNumJour()
    {
        return this.numJour;
    }

    private List<FilmPanel> filmPanels;
    private JPanel filmsPanel;
    private JScrollPane filmsScrollPanel;
    private JButton genererPlanningBouton;
    private JToggleButton jourBouton13;
    private JToggleButton jourBouton14;
    private JToggleButton jourBouton15;
    private JToggleButton jourBouton16;
    private JToggleButton jourBouton17;
    private JToggleButton jourBouton18;
    private JToggleButton jourBouton19;
    private JToggleButton jourBouton20;
    private JToggleButton jourBouton21;
    private JToggleButton jourBouton22;
    private JToggleButton jourBouton23;
    private JToggleButton jourBouton24;
    private JToggleButton jourBouton25;
    private JPanel jourBoutonBar;
    private JLabel logo;
    private JLabel logoMenu;
    private JDesktopPane menuPanel;
    private JDesktopPane planningPanel;
    private JTable planningTabOverlay;
    private JScrollPane planningTabScrollPanel;
    private JPanel planningTabPanel;
    private JPanel planningTabGeneralPanel;
    private JButton suppProjectionBouton;
    private JLabel titreMenu;
    private ButtonGroup jourGroup;
    private static MainView instance;
    private GroupLayout filmsPanelLayout;
    private JButton retourBouton;
    private List<MenuBouton> competitionBoutons;
    private DAOController daoController;
    private int idCompetition;
    private JLabel selectedCompetition;
    private int blockSelected;
    private List<FilmBlock> filmBlocks;
    private GroupLayout planningPanelLayout;
    private int numJour = 13;
    private int draggingPanel;
    private JButton ajoutFilm;
    private JButton suppFilm;
    /* ----------------- */
}
