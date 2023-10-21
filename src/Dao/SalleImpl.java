package Dao;

import metier.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleImpl implements ISalle{

    private Connection cx = SingletonConnection.getInstance();
    @Override
    public void ajouterClient(Client c ){
        try {
            PreparedStatement st = cx.prepareStatement("insert into client(nom,prenom,sexe," +
                    "datedenaissance,telephone,dateinscription) values(?,?,?,?,?,?)");
            st.setString(1,c.getNom());
            st.setString(2, c.getPrenom());
            st.setString(3, c.getSexe());
            st.setDate(4,(new java.sql.Date(c.getDatedenaissance().getTime())));
            st.setString(5,c.getTelephone());
            st.setDate(6,(new java.sql.Date(c.getDatedinscription().getTime())));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Client> getAllClient() {
        List<Client>liste = new ArrayList<>();
        try {
            PreparedStatement ps = cx.prepareStatement("select * from client ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setSexe(rs.getString(4));
                c.setDatedenaissance(rs.getDate(5));
                c.setTelephone(rs.getString(6));
                c.setDatedinscription(rs.getDate(7));
                liste.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
    @Override
    public List<Client> getClientPMC(String mc) {
        List<Client> liste = new ArrayList<>();
        try{
            PreparedStatement ps = cx.prepareStatement("select * from client " +
                    "where nom like ?");
            ps.setString(1,"%"+mc+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Client c = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5)
                        , rs.getString(6),rs.getDate(7));
                liste.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public Client getClientID(int id) {
        Client c = null ;
        try{
            PreparedStatement ps = cx.prepareStatement("select * from client " +
                    "where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c= new Client();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setSexe(rs.getString(4));
                c.setDatedenaissance(rs.getDate(5));
                c.setTelephone(rs.getString(6));
                c.setDatedinscription(rs.getDate(7));
            }

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        return c;
    }

    @Override
    public void modifierClient(Client c) {
        try{
            PreparedStatement st = cx.prepareStatement("update client set nom=? ,prenom=? ,sexe=? , datedenaissance=? ,telephone=?, " +
                    "dateinscription=? " +
                    "where id=?");
            st.setString(1,c.getNom());
            st.setString(2,c.getPrenom());
            st.setString(3,c.getSexe());
            st.setDate(4,(new java.sql.Date(c.getDatedenaissance().getTime())));
            st.setString(5,c.getTelephone());
            st.setDate(6,(new java.sql.Date(c.getDatedinscription().getTime())));
            st.setInt(7, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerClient(int id) {
        try{
            PreparedStatement st = cx.prepareStatement("delete from client where " +
                    "id=?");
            st.setInt(1,id);
            st.executeUpdate();

        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }

    }
}
