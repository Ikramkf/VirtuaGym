package présentation;


import metier.Client;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModele_c extends AbstractTableModel {
    private List<Client> liste_client=new ArrayList<>();
    private String titres[]= {"id","nom","prenom","sexe","Date de naissance" , "Telephone" , "Date d'inscription"} ;


    @Override
    public int getRowCount() {
        return liste_client.size();
    }

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return titres[column];
    }

    @Override
    public Object getValueAt(int l, int c) {
        switch(c)
        {
            case 0:return liste_client.get(l).getId();
            case 1:return liste_client.get(l).getNom();
            case 2:return liste_client.get(l).getPrenom();
            case 3:return liste_client.get(l).getSexe();
            case 4:return liste_client.get(l).getDatedenaissance();
            case 5:return liste_client.get(l).getTelephone();
            case 6:return liste_client.get(l).getDatedinscription();
        }
        return null;
    }

    public void charger(List<Client> l)
    {
        this.liste_client=l;
        fireTableDataChanged();
    }

}
