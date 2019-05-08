package UEVEZon.models;

import javax.swing.table.*;

public class EmployeViewModel extends AbstractTableModel {
	String[] nomColonnes = {"Nom", "Prenom", "Salaire", "Role"};
	Magasin magasin;

	public EmployeViewModel(Magasin mag) {
		magasin = mag;
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