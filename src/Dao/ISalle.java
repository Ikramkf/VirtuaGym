package Dao;

import metier.Client;

import java.util.List;

public interface ISalle {

    public void ajouterClient(Client c);

    public List<Client> getAllClient();

    public List<Client> getClientPMC(String mc);

    public Client getClientID(int id);

    public void modifierClient(Client c);

    public void supprimerClient(int id);

}
