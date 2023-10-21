package présentation;

import metier.Coach;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModele_co extends AbstractTableModel {

    private List<Coach> liste_coach=new ArrayList<>();
    private String titres[]= {"id","nom","prenom","sexe","Date de naissance" , "Telephone" ,"diplome", "Date d'inscription"};


    public int getRowCount() {
        return liste_coach.size();
    }


    public int getColumnCount() {
        return titres.length;
    }

    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return titres[column];
    }

    public Object getValueAt(int l, int c) {
        switch(c)
        {
            case 0:return liste_coach.get(l).getId_coach();
            case 1:return liste_coach.get(l).getNom();
            case 2:return liste_coach.get(l).getPrenom();
            case 3:return liste_coach.get(l).getSexe();
            case 4:return liste_coach.get(l).getDatedenaissance_c();
            case 5:return liste_coach.get(l).getTelephone();
            case 6:return liste_coach.get(l).getDiplome();
            case 7:return liste_coach.get(l).getDatedembauche();
        }
        return null;
    }

    public void charger(List<Coach>lco)
    {
        this.liste_coach=lco;
        fireTableDataChanged();

    }

}

