package présentation;

import Dao.ISalle;
import Dao.SalleImpl;
//import com.toedter.calendar.JDateChooser;

import metier.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Clientpage extends JFrame implements ActionListener {

    int id;
    JPanel p = new JPanel(new BorderLayout());//principale
    JPanel p0 = new JPanel(new FlowLayout());
    JLabel client = new JLabel(".....Client.....");
    JPanel p1= new JPanel(new BorderLayout());

    JPanel p11 = new JPanel(new FlowLayout());
    JPanel p12 = new JPanel(new BorderLayout());
    JPanel p21 = new JPanel(new FlowLayout());
    JPanel p22 = new JPanel(new FlowLayout());
    JPanel p23 = new JPanel(new FlowLayout());

    JPanel p13 = new JPanel(new FlowLayout());
    ImageIcon image = new ImageIcon("C:\\Users\\fessi\\Documents\\2LM\\S2" +
            "\\App Java\\VirtuaGym\\VirtuaGym\\src\\Images\\user.png");
    JLabel icon = new JLabel(image);
    JPanel p02 = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JButton Acceuil = new JButton("Acceuil");
    JButton clients = new JButton("Clients");
    JButton coachs = new JButton("Coachs");
    JButton Calendrier = new JButton("Calendrier");
    JButton logout = new JButton("Deconnexion");

    JPanel p2 = new JPanel(new BorderLayout());

    JLabel nom = new JLabel("Nom ");
    JTextField nt = new JTextField(15);
    JLabel prenom = new JLabel("Prenom ");
    JTextField pt = new JTextField(15);
    JLabel sexe = new JLabel("Sexe ");
    JRadioButton H = new JRadioButton("Homme");
    JRadioButton F = new JRadioButton("Femme");
    JLabel date_naiss = new JLabel("Date de naissance");

    //JDateChooser datenaissance = new JDateChooser();
    JLabel tel = new JLabel("Telephone ");
    JTextField telt = new JTextField(15);
    JLabel date_inscri = new JLabel("Date d'inscription");
    //JDateChooser dateinscription = new JDateChooser();
    JButton ajout = new JButton("Ajouter");
    JButton modif = new JButton("Modifier");
    JButton supp = new JButton("Supprimer");
    JButton annule = new JButton("Annuler");

    //liste
    JTable table = new JTable();
    TableModele_c tab_client = new TableModele_c();
    JScrollPane jsp = new JScrollPane(table);
    ISalle salle = new SalleImpl();
    //JPanel p31 = new JPanel(new GridLayout(1, 1));
    JLabel rechmc = new JLabel("Chercher par mot clé : ");
    JTextField rechmct = new JTextField(10);
    JButton rechmcb = new JButton("Rechercher par mc");

    //JPanel searchP = new JPanel(new FlowLayout());
    JLabel rechid = new JLabel("Chercher par id ");
    JTextField rechidt = new JTextField(10);
    JButton rechidb = new JButton("Rechercher par id ");
    JLabel idsupp = new JLabel("Donner l'id à supprimer  : ");
    JTextField idsuppt = new JTextField(10);
    JButton idsuppb = new JButton("Id à supp ");

    //JPanel p30 = new JPanel(new FlowLayout());
    JPanel p3 = new JPanel(new BorderLayout());


    public Clientpage() {
        setTitle("VirtuaGym_EspaceClient");
        this.setSize(1400, 800);
        //pack();
        this.setLocationRelativeTo(null);
        this.setContentPane(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //zone texte: client
        Font Font = new Font("Arial", java.awt.Font.BOLD | java.awt.Font.ITALIC, 42);
        client.setFont(Font);
        client.setHorizontalAlignment(JLabel.CENTER);
        client.setForeground(Color.decode("#10454F"));
        //p0.add(wlc);
        p11.add(client, BorderLayout.NORTH);
        p1.add(p11, BorderLayout.NORTH);
        p.add(p1, BorderLayout.CENTER);
        //icon
        //p11.add(icon);
        //icon.setSize(5,90);
        //icon.setPreferredSize(new Dimension(50, 90));
        p11.setBackground(Color.decode("#D2E8E3"));
        p1.setBackground(Color.decode("#D2E8E3"));
        p.setBackground(Color.decode("#D2E8E3"));


        //boutons
        Acceuil.setBackground(Color.decode("#D2E8E3"));
        Acceuil.setForeground(Color.decode("#023535"));

        clients.setBackground(Color.decode("#D2E8E3"));
        clients.setForeground(Color.decode("#023535"));
        coachs.setBackground(Color.decode("#D2E8E3"));
        coachs.setForeground(Color.decode("#023535"));
        Calendrier.setBackground(Color.decode("#D2E8E3"));
        Calendrier.setForeground(Color.decode("#023535"));

        logout.setBackground(Color.decode("#D2E8E3"));
        logout.setForeground(Color.decode("#023535"));

        //menu
        menuBar.add(Acceuil);
        menuBar.add(clients);
        menuBar.add(coachs);
        menuBar.add(Calendrier);
        menuBar.add(Box.createHorizontalGlue()); // Pour aligner Déconnexion à droite
        menuBar.add(logout);

        p02.add(menuBar);
        p.add(p02, BorderLayout.NORTH);
        setJMenuBar(menuBar);
        Acceuil.addActionListener(this::actionPerformed4);

        clients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientpage pageClient = new Clientpage();
                pageClient.setVisible(true);
                dispose();
            }
        });
        coachs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coachpage pageCoach = new Coachpage();
                pageCoach.setVisible(true);
                dispose();
            }
        });
        logout.addActionListener(e -> {
            try {
                new loginpage();
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });

        //zone saisie des donnees
        p21.add(nom);
        p21.add(nt);
        p21.add(prenom);
        p21.add(pt);
        p21.add(sexe);
        ButtonGroup bg = new ButtonGroup();
        bg.add(H);
        bg.add(F);
        p21.add(H);
        p21.add(F);

        p22.add(date_naiss);
       // p22.add(datenaissance);
        p22.add(tel);
        p22.add(telt);
        p22.add(date_inscri);
      //  p22.add(dateinscription);
       // datenaissance.setPreferredSize(new Dimension(100,20));
       // dateinscription.setPreferredSize(new Dimension(100,20));

        p23.add(ajout);
        p23.add(modif);
        //p23.add(supp);
        p23.add(annule);

        p12.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#8FC1B5"), 10)
                , "Informations Client "));
        p12.add(p21, BorderLayout.NORTH);
        p12.add(p22, BorderLayout.CENTER);
        p12.add(p23, BorderLayout.SOUTH);
        p1.add(p12, BorderLayout.CENTER);
        p.add(p1, BorderLayout.CENTER);

        //zone liste :

        p1.add(p13, BorderLayout.SOUTH);
        p13.add(rechmc);
        p13.add(rechmct);
        p13.add(rechmcb);
        // p13.add(rechid);
        // p13.add(rechidt);
        // p13.add(rechidb);
        p13.add(idsupp);
        p13.add(idsuppt);
        p13.add(idsuppb);

        //p3.add(searchP,BorderLayout.NORTH);
        p3.add(jsp);
        p.add(p3, BorderLayout.SOUTH);
        table.setModel(tab_client);
        tab_client.charger(salle.getAllClient());
        annule.addActionListener(this::actionPerformed3);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();

                    int row = target.getSelectedRow();

                    id = (int) target.getValueAt(row, 0);
                }
            }
        });

        // idsuppb.addActionListener(e ->
        // {
        //   salle.supprimerClient(Integer.parseInt(idsuppt.getText()));
        //   tab_client.charger(salle.getAllClient());
        //  });
        //   this.pack();
        //rechmcb.addActionListener(e ->

        //   tab_client.charger(salle.getClientPMC(rechmct.getText()));
        //});
        // rechidb.addActionListener(e->
        //  {
        //     tab_client.charger((List<Client>) salle.getClientID(Integer.parseInt(rechidt.getText())));
        //  });
        rechmcb.addActionListener(e ->
                tab_client.charger(salle.getClientPMC(rechmct.getText())));

        idsuppb.addActionListener(e ->
        {
            salle.supprimerClient(Integer.parseInt(idsuppt.getText()));
            tab_client.charger(salle.getAllClient());
        });
        ajout.addActionListener(this);
        modif.addActionListener(this::actionPerformed2);
        // rechidb.addActionListener(e -> tab_client.charger((List<Client>) salle.getClientID((rechidt.getX()))));

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Clientpage frame = new Clientpage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o instanceof JButton){
            if(H.isSelected())
            {
                salle.ajouterClient(new Client(nt.getText(),pt.getText(),H.getText() ,
                        new java.util.Date(datenaissance.getDate().getTime()), telt.getText() , new java.util.Date(dateinscription.getDate().getTime())));
                tab_client.charger(salle.getAllClient());
            } else if (F.isSelected())
            {
                salle.ajouterClient(new Client(nt.getText(),pt.getText(),F.getText() ,
                        new java.util.Date(datenaissance.getDate().getTime()), telt.getText() , new java.util.Date(dateinscription.getDate().getTime())));
                tab_client.charger(salle.getAllClient());
            }
        }

    }
    private void actionPerformed2(ActionEvent e) {
        Client client = salle.getClientID(id);

        client.setSexe((F.isSelected())? F.getText() : H.getText());
        client.setDatedenaissance(new Date(datenaissance.getDate().getTime()));
        client.setDatedinscription(new Date(dateinscription.getDate().getTime()));
        client.setTelephone(telt.getText());
        client.setPrenom(pt.getText());
        client.setNom(nt.getText());

        salle.modifierClient(client);
        tab_client.charger(salle.getAllClient());
    }
    private void actionPerformed3(ActionEvent e1){
        nt.setText("");
        pt.setText("");
        sexe.setText("");
        datenaissance.setDate(null);
        telt.setText("");
        dateinscription.setDate(null);
    }
    public void actionPerformed4(ActionEvent e) {
        new menupage();
        dispose();

    }

}



