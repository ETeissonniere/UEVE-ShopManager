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
		controls.add(buildAjouterGamme(table, mag));
		controls.add(buildAjouterProduit(table, mag));

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
							numSerie = Integer.parseInt(numSerieStr);
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

	private JButton buildAjouterGamme(JTable table, Magasin mag) {
		JButton ajouter = new JButton("Enregistrer une nouvelle Gamme");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom;
				String codeBarreStr;
				String prixStr;

				int codeBarre = 0;
				double prix = 0.0;

				do {
					nom = JOptionPane.showInputDialog(table, "Indiquez le nom de la gamme (doit être unique)", "Nom", JOptionPane.QUESTION_MESSAGE);
					if (nom == null || nom.length() == 0) {
						return;
					}
				} while (nom.length() == 0 || mag.gammes.containsKey(nom));

				do {
					codeBarreStr = JOptionPane.showInputDialog(table, "Code barre de la gamme de produits", "Code barre", JOptionPane.QUESTION_MESSAGE);
					if (codeBarreStr == null || codeBarreStr.length() == 0) {
						return;
					}

					try {
						codeBarre = Integer.parseInt(codeBarreStr);
					} catch (NumberFormatException exception) {
						// Ne crash pas
					}
				} while (codeBarre <= 0);

				do {
					prixStr = JOptionPane.showInputDialog(table, "Prix des produits de la gamme", "Prix", JOptionPane.QUESTION_MESSAGE);
					if (prixStr == null || prixStr.length() == 0) {
						return;
					}

					try {
						prix = Double.parseDouble(prixStr);
					} catch (NumberFormatException exception) {
						// Ne crash pas
					}
				} while (prix <= 0);

				Gamme g = new Gamme(codeBarre, prix, 0.2);
				mag.vend(nom, g);

				((GammeViewModel)table.getModel()).refresh();
			}
		});

		return ajouter;
	}
}