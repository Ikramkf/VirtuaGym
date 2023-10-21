package présentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menupage extends JFrame implements ActionListener{

    JPanel p = new JPanel(new BorderLayout());
    JPanel p0 = new JPanel(new FlowLayout());
    JLabel wlc = new JLabel("WELCOME TO VIRTUAGYM ");

    JPanel p1 = new JPanel(new BorderLayout());

    JPanel p11 = new JPanel(new FlowLayout());
    ImageIcon image = new ImageIcon("C:\\Users\\fessi\\Documents\\2LM\\S2" +
            "\\App Java\\VirtuaGym\\VirtuaGym\\src\\Images\\Virtuagymlogo.jpeg");
    JLabel logo = new JLabel(image);

    JPanel p12 = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JButton Acceuil = new JButton("Acceuil");
    JButton clients = new JButton("Clients");
    JButton coachs = new JButton("Coachs");
    JButton Calendrier = new JButton("Calendrier");
    JButton logout = new JButton("Deconnexion");


    public menupage() {
        setTitle("VirtuaGym");
        this.setSize(1400, 800);
        //pack();
        this.setLocationRelativeTo(null);
        this.setContentPane(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Font Font = new Font("Bree Serif", java.awt.Font.BOLD | java.awt.Font.ITALIC, 48);
        wlc.setFont(Font);
        wlc.setHorizontalAlignment(JLabel.CENTER);
        //p0.add(wlc);
        p.add(wlc, BorderLayout.CENTER);

        //logo
        p11.add(logo);
        logo.setSize(500, 900);
        // logo.setPreferredSize(new Dimension(500, 900));
        p11.setBackground(Color.decode("#D2E8E3"));
        p1.add(p11, BorderLayout.SOUTH);
        p1.setBackground(Color.decode("#D2E8E3"));
        p.add(p1, BorderLayout.SOUTH);
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
        p12.add(menuBar);
        p1.add(p12, BorderLayout.WEST);
        setJMenuBar(menuBar);

        Acceuil.addActionListener(this);

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

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menupage frame = new menupage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        new menupage();
        dispose();

    }
}

