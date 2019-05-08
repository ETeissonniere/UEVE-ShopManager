package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import UEVEZon.models.*;

public class EmployeView extends JPanel {
	public EmployeView(Magasin mag) {
		super(new BorderLayout());

		JTable table = new JTable(new EmployeViewModel(mag));
		JScrollPane scroller = new JScrollPane(table);

		JPanel controls = new JPanel();
		controls.add(buildLicensierButton(table));
		controls.add(buildEngagerButton(this, table));

		add(controls, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}

	private JButton buildLicensierButton(JTable table) {
		JButton licensier = new JButton("Licensier");
		licensier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					((EmployeViewModel)table.getModel()).removeRow(table.getSelectedRow());
				}
			}
		});

		return licensier;
	}

	private JButton buildEngagerButton(JPanel window, JTable table) {
		JButton engager = new JButton("Engager");
		engager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = JOptionPane.showInputDialog(window, "Choisissez le nom du nouvel employé", "Nom", JOptionPane.QUESTION_MESSAGE);
				if (nom == null || nom.length() == 0) {
					return;
				}

				String prenom = JOptionPane.showInputDialog(window, "Choisissez le prénom du nouvel employé", "Prenom", JOptionPane.QUESTION_MESSAGE);
				if (prenom == null || prenom.length() == 0) {
					return;
				}

				String role = JOptionPane.showInputDialog(window, "Choisissez le role du nouvel employé", "Role", JOptionPane.QUESTION_MESSAGE);
				if (role == null || role.length() == 0) {
					return;
				}

				double salaire = 0.0;

				do {
					String salaireStr = JOptionPane.showInputDialog(window, "Choisissez le salaire du nouvel employé", "Salaire", JOptionPane.QUESTION_MESSAGE);
					if (salaireStr == null || salaireStr.length() == 0) {
						return;
					}

					try {
						salaire = Double.parseDouble(salaireStr);
					} catch (NumberFormatException exception) {
						// Handle, will ask again
					}
				} while (salaire <= 0.0);

				((EmployeViewModel)table.getModel()).addRow(nom, prenom, role, salaire);
			}
		});

		return engager;
	}
}