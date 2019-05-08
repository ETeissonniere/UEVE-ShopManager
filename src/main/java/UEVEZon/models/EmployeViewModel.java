package UEVEZon.models;

import javax.swing.table.*;
import UEVEZon.controllers.*;

public class EmployeViewModel extends AbstractTableModel {
    String[] nomColonnes = {"Nom", "Prenom", "Salaire", "Role", "Nombre de vente", "Valeur des ventes"};
    Magasin magasin;
    StatisticsListener statistiques;

    public EmployeViewModel(Magasin mag, StatisticsListener stats) {
        magasin = mag;
        statistiques = stats;
    }

    public String getColumnName(int col) {
        return nomColonnes[col];
    }

    public int getRowCount() {
        return magasin.employes.size();
    }

    public int getColumnCount() {
        return nomColonnes.length;
    }

    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return magasin.employes.get(row).nom;
            case 1:
                return magasin.employes.get(row).prenom;
            case 2:
                return magasin.employes.get(row).salaire;
            case 3:
                return magasin.employes.get(row).role;
            case 4:
                return statistiques.ventes.get(magasin.employes.get(row));
            case 5:
                return statistiques.valeurVendue.get(magasin.employes.get(row));
            default:
                return null;
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void removeRow(int row) {
        magasin.licensie(row);
        fireTableRowsDeleted(row, row);
    }

    public void addRow(String nom, String prenom, String role, double salaire) {
        magasin.engage(new Employe(nom, prenom, salaire, role));
        fireTableRowsInserted(magasin.employes.size() - 1, magasin.employes.size() - 1);
    }
}
