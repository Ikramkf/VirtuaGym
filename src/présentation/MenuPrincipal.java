package présentation;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        // Création du logo
        ImageIcon image = new ImageIcon("C:\\Users\\fessi\\Documents\\2LM\\S2" +
                "\\App Java\\VirtuaGym\\VirtuaGym\\src\\Images\\Virtuagymlogo.jpeg");
        JLabel logo = new JLabel(image);
        logo.setPreferredSize(new Dimension(100, 100)); // Ajuster la taille du logo

        // Création du titre
        JLabel titreLabel = new JLabel("WELCOME TO VirtuaGym");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Changer la police et la taille du titre
        titreLabel.setHorizontalAlignment(JLabel.CENTER);

        // Création du menu horizontal
        JMenuBar menuBar = new JMenuBar();
        JMenu accueilMenu = new JMenu("Accueil");
        JMenu clientsMenu = new JMenu("Clients");
        JMenu coachsMenu = new JMenu("Coachs");
        JMenu calendrierMenu = new JMenu("Calendrier");
        JMenu deconnexionMenu = new JMenu("Déconnexion");
        menuBar.add(accueilMenu);
        menuBar.add(clientsMenu);
        menuBar.add(coachsMenu);
        menuBar.add(calendrierMenu);
        menuBar.add(Box.createHorizontalGlue()); // Pour aligner Déconnexion à droite
        menuBar.add(deconnexionMenu);

        // Ajout des éléments à la fenêtre
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(logo, BorderLayout.CENTER);
        getContentPane().add(titreLabel, BorderLayout.NORTH);
        setJMenuBar(menuBar);

        // Ajuster la taille de la fenêtre et la rendre visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal());
    }
}