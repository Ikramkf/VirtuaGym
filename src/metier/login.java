package metier;

public class login {
    private String nom_utilisateur ;
    private String mot_de_passe ;

    public login(String nom_utilisateur  , String mot_de_passe){
        this.nom_utilisateur=nom_utilisateur;
        this.mot_de_passe= mot_de_passe;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
