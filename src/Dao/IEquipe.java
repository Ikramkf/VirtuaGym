package Dao;

import metier.Coach;

import java.util.List;

public interface IEquipe{

    public void ajouterCoach(Coach co );
    public List<Coach> getAllCoachs();
    public List<Coach> getCoachPMC(String mc);
    public Coach getCoachID (int id);
    public void modifierCoach(Coach co );
    public void supprimerCoach(int id );

}
