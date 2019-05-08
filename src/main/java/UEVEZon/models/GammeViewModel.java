package UEVEZon.models;

import javax.swing.table.*;
import java.util.ArrayList;

public class GammeViewModel extends AbstractTableModel {
	String[] nomColonnes = {"Nom", "Code barre", "Prix", "TVA", "Quantité disponible"};
	Magasin magasin;

	public GammeViewModel(Magasin mag) {
		magasin = mag;
	}

	public String getColumnName(int col) {
		return nomColonnes[col];
	}

	public int getRowCount() {
		return magasin.gammes.size();
	}

	public int getColumnCount() {
		return nomColonnes.length;
	}

	public Object getValueAt(int row, int col) {
		// un LinkedHashMap à une itération déterministe
		String gammeKey = (String) (new ArrayList(magasin.gammes.keySet())).get(row);

		switch (col) {
			case 0:
				return gammeKey;
			case 1:
				return magasin.gammes.get(gammeKey).codeBarre;
			case 2:
				return magasin.gammes.get(gammeKey).prix;
			case 3:
				return magasin.gammes.get(gammeKey).tva;
			case 4:
				return magasin.gammes.get(gammeKey).stock.size();
			default:
				return null;
		}
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void refresh() {
		// Le problème des Map c'est que les changements ne sont pas forcément opérés ligne par ligne,
		// on peut avoir des choses insérées au milieu, au début... On doit donc tout recharger pour
		// être sur d'avoir une représentation correcte.

		fireTableDataChanged();
		fireTableStructureChanged();
	}

	/*public void removeRow(int row) {
		magasin.licensie(row);
		fireTableRowsDeleted(row, row);
	}

	public void addRow(String nom, String prenom, String role, double salaire) {
		magasin.engage(new Employe(nom, prenom, salaire, role));
		fireTableRowsInserted(0, magasin.employes.size() - 1);
	}*/
}