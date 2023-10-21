package metier;

import java.util.Date;

public class Coach {
    private int id_coach ;
    private String nom ;
    private String prenom ;
    private String sexe ;
    private Date datedenaissance_c ;
    private String telephone ;

    private String diplome ;
    private Date datedembauche ;

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDatedenaissance_c() {
        return datedenaissance_c;
    }

    public void setDatedenaissance_c(Date datedenaissance_c) {
        this.datedenaissance_c = datedenaissance_c;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Date getDatedembauche() {
        return datedembauche;
    }

    public void setDatedembauche(Date datedembauche) {
        this.datedembauche = datedembauche;
    }


    public Coach(int id_coach , String nom, String prenom, String sexe , Date datedenaissance_c
            , String telephone , String string, Date datedembauche) {
        super();
        this.id_coach = id_coach;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datedenaissance_c = datedenaissance_c;
        this.telephone = telephone ;
        this.diplome=diplome;
        this.datedembauche=datedembauche;
    }
    public Coach(String nom, String prenom, String sexe, Date datedenaissance_c, String telephone, String diplome, Date datedembauche){
        super();
    }
    public Coach() {
        super();

        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datedenaissance_c = datedenaissance_c;
        this.telephone = telephone ;
        this.diplome=diplome;
        this.datedembauche=datedembauche;
    }
}
