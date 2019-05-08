package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import UEVEZon.models.*;

public class GammeView extends JPanel {
	public GammeView(Magasin mag) {
		super(new BorderLayout());

		JTable table = new JTable(new GammeViewModel(mag));
		JScrollPane scroller = new JScrollPane(table);

		JPanel controls = new JPanel();
		controls.add(buildAjouterProduit(table, mag));

		// Ajoute un produit
		// Ajoute une gamme
		// Supprime une gamme
		//controls.add(buildLicensierButton(table));
		//controls.add(buildEngagerButton(this, table));

		add(controls, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}

	private JButton buildAjouterProduit(JTable table, Magasin mag) {
		JButton ajouter = new JButton("Enregistrer un produit");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					int numSerie = -1;

					do {
						String numSerieStr = JOptionPane.showInputDialog(table, "Indiquez le numéro de série du nouveau produit", "Numéro de série", JOptionPane.QUESTION_MESSAGE);
						if (numSerieStr == null || numSerieStr.length() == 0) {
							return;
						}

						try {
							numSerie = Integer.valueOf(numSerieStr);
						} catch (NumberFormatException exeception) {
							// Ne crash pas
						}
					} while (numSerie <= 0);

					Gamme g = (Gamme) (new ArrayList(mag.gammes.values())).get(table.getSelectedRow());
					g.enregistre(new Produit(numSerie));
					
					((GammeViewModel)table.getModel()).refresh();
				}
			}
		});

		return ajouter;
	}
}