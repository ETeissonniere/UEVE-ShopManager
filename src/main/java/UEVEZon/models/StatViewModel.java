package UEVEZon.models;

import javax.swing.table.*;
import UEVEZon.controllers.*;

public class StatViewModel extends AbstractTableModel {
    String[] nomColonnes = {"Type", "Nombre"};
    String[] firstColumn = {"Employe", "Gamme en vente", "Achats", "Ventes", "Produits", "Valeur totale magasin"};
    StatisticsListener stats;

    public StatViewModel(StatisticsListener statistics) {
        stats = statistics;
    }

    public String getColumnName(int col) {
        return nomColonnes[col];
    }

    public int getRowCount() {
        return firstColumn.length; 
    }

    public int getColumnCount() {
        return nomColonnes.length;
    }


    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return firstColumn[row];
            case 1:
                switch (row) {
                    case 0:
                        return stats.nombreEmployes;
                    case 1:
                        return stats.nombreGammesEnVente;
                    case 2:
                        return stats.nombreAchats;
                    case 3:
                        return stats.nombreVentes;
                    case 4:
                        return stats.nombreProduitsEnregistre;
                    case 5:
                        return stats.valeurTotaleMagasin;
                    default:
                        return null;
                }
            default:
                return null;
        }
    }


    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
