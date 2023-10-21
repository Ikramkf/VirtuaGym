package metier;

import java.util.Date;

public class Client {
    private int id ;
    private String nom ;
    private String prenom ;
    private String sexe ;
    private Date datedenaissance ;
    private String telephone ;
    private Date datedinscription ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDatedinscription() {
        return datedinscription;
    }

    public void setDatedinscription(Date datedinscription) {
        this.datedinscription = datedinscription;
    }

    public Client(int id, String nom, String prenom,String sexe , Date datedenaissance
            , String telephone , Date datedinscription) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datedenaissance = datedenaissance;
        this.telephone = telephone ;
        this.datedinscription = datedinscription ;
    }

    public Client (){
        super();
    }

    public Client(String nom, String prenom, String sexe , Date datedenaissance
            , String telephone , Date datedinscription) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datedenaissance = datedenaissance;
        this.telephone = telephone ;
        this.datedinscription = datedinscription ;
    }


}
