package Dao;

import metier.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeImpl implements IEquipe{
    private Connection cx = SingletonConnection.getInstance();
    @Override
    public void ajouterCoach(Coach c ){
        try {
            PreparedStatement st = cx.prepareStatement("insert into coach(nom,prenom,sexe,datedenaissance_c,telephone,diplome,datedembauche) values(?,?,?,?,?,?,?)");

            st.setString(1,c.getNom());
            st.setString(2,c.getPrenom());
            st.setString(3,c.getSexe());
            st.setDate(4, new java.sql.Date(c.getDatedenaissance_c().getTime()));
            st.setString(5,c.getTelephone());
            st.setString(6,c.getDiplome());
            st.setDate(7, new java.sql.Date(c.getDatedembauche().getTime()));
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du coach: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Coach> getAllCoachs() {
        List<Coach> liste_co = new ArrayList<>();
        try {
            PreparedStatement ps = cx.prepareStatement("select * from coach ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Coach co = new Coach();
                co.setId_coach(rs.getInt(1));
                co.setNom(rs.getString(2));
                co.setPrenom(rs.getString(3));
                co.setSexe(rs.getString(4));
                co.setDatedenaissance_c(rs.getDate(5));
                co.setTelephone(rs.getString(6));
                co.setDiplome(rs.getString(7));
                co.setDatedembauche(rs.getDate(8));
                liste_co.add(co);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste_co;

    }
    @Override
    public List<Coach> getCoachPMC(String mc) {
        List<Coach> liste = new ArrayList<>();
        try{
            PreparedStatement ps = cx.prepareStatement("select * from coach " +
                    "where nom like ?");
            ps.setString(1,"%"+mc+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Coach c = new Coach(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5)
                        , rs.getString(6),rs.getString(7),rs.getDate(7));
                liste.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
    @Override
    public Coach getCoachID(int id) {
        Coach co = null ;
        try{
            PreparedStatement ps = cx.prepareStatement("select * from coach where id_coach=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                co= new Coach();
                co.setId_coach(rs.getInt(1));
                co.setNom(rs.getString(2));
                co.setPrenom(rs.getString(3));
                co.setSexe(rs.getString(4));
                co.setDatedenaissance_c(rs.getDate(5));
                co.setTelephone(rs.getString(6));
                co.setDiplome(rs.getString(7));
                co.setDatedembauche(rs.getDate(8));
            }

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        return co;
    }
    @Override
    public void modifierCoach(Coach co) {
        try{
            PreparedStatement st = cx.prepareStatement("UPDATE coach set nom=? ,prenom=? ,sexe=? , datedenaissance_c=? ,telephone=? ,diplome=?, datedembauche=? where id_coach=?");
            st.setString(1,co.getNom());
            st.setString(2,co.getPrenom());
            st.setString(3,co.getSexe());
            st.setDate(4,(new java.sql.Date(co.getDatedenaissance_c().getTime())));
            st.setString(5,co.getTelephone());
            st.setString(6, co.getDiplome());
            st.setDate(7,(new java.sql.Date(co.getDatedembauche().getTime())));
            st.setInt(8, co.getId_coach());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void supprimerCoach(int id) {
        try{
            PreparedStatement st = cx.prepareStatement("delete from coach where id_coach=?" );
            st.setInt(1,id);
            st.executeUpdate();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

}

