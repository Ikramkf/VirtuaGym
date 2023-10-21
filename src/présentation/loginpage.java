package présentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginpage extends JFrame implements ActionListener {
    JPanel p = new JPanel(new BorderLayout());
    JPanel p0 = new JPanel(new FlowLayout());
    JLabel Vi = new JLabel("VirtuaGym", JLabel.CENTER);

    ImageIcon image = new ImageIcon("C:\\Users\\fessi\\Documents\\2LM\\S2" +
            "\\App Java\\VirtuaGym\\VirtuaGym\\src\\Images\\Virtuagymlogo.jpeg");
    JLabel logo = new JLabel(image);
    JPanel p2 = new JPanel(new BorderLayout());
    JPanel p21 = new JPanel(new GridLayout(2, 1));
    JPanel p12 = new JPanel(new GridLayout(3,1));
    JPanel p22 = new JPanel(new GridLayout(3,1));
    JLabel nom = new JLabel("Entrer votre nom : ");
    JTextField nt = new JTextField(15);


    JLabel mdp = new JLabel("Entrer votre mot de passe ");
    JPasswordField mdpt = new JPasswordField(15);

    JPanel p3 = new JPanel(new FlowLayout());
    JButton ok = new JButton("Entrer");
    JButton annule = new JButton("Annuler");

    public loginpage() throws FontFormatException {
        setTitle("Login");
        setSize(1200,550);
        //pack();
        setLocationRelativeTo(null);
        setContentPane(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //partie nom du salle
        Font Font = new Font("Arial", java.awt.Font.BOLD | java.awt.Font.ITALIC, 32);
        Vi.setFont(Font);
        Vi.setForeground(Color.decode("#001542"));
        p0.setBackground(Color.decode("#DEEFE7"));
        p0.add(Vi);
        p.add(p0, BorderLayout.NORTH);
        p.setBackground(Color.decode("#D2E8E3"));
        nt.setPreferredSize(new Dimension(20, 30));
        nom.setForeground(Color.decode("#10454F"));
        mdpt.setPreferredSize(new Dimension(200, 30));
        mdp.setForeground(Color.decode("#10454F"));
        //partie logo
        p.add(logo, BorderLayout.WEST);
        p.setBackground(Color.decode("#D2E8E3"));
        //partie coordonnees
        Font f1 = new Font("Arial", Font.BOLD, 25);
        p12.add(nom);
        nom.setFont(f1);
        mdp.setFont(f1);
        p12.add(nt);
        p12.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#D2E8E3"), 10)));
        p22.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#D2E8E3"), 10)));
        p22.add(mdp);
        p22.add(mdpt);
        p21.add(p12);
        p21.add(p22);
        p2.add(p21, BorderLayout.CENTER);
        p2.setBackground(Color.decode("#D2E8E3"));
        p3.setBackground(Color.decode("#D2E8E3"));
        p21.setBackground(Color.decode("#D2E8E3"));
        p.add(p2, BorderLayout.CENTER);

        p3.add(ok);
        ok.setBackground(Color.decode("#589A8D"));
        annule.setBackground(Color.decode("#E3371E"));
        p3.add(annule);
        p.add(p3, BorderLayout.SOUTH);
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ok.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gymapp", "root", "admin");
            Statement stmt = con.createStatement();
            String username = nt.getText();
            String password = new String(mdpt.getPassword());
            String sql = "SELECT * FROM logingym WHERE nom_utilisateur='" + username + "' AND mot_de_passe='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Vérification des informations de connexion
            if (rs.next()) {
                // Accès autorisé
                JOptionPane.showMessageDialog(null, "Login successful!");
                // Ouverture de la page d'accueil
                new menupage();
                // Fermeture de la page de connexion
                dispose();
            } else {
                // Accès refusé
                JOptionPane.showMessageDialog(null, "Invalid login credentials.");
            }
            // Fermeture de la connexion à la base de données
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginpage frame = new loginpage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }}








