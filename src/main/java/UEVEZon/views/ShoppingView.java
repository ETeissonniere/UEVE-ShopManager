package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import UEVEZon.models.*;
import UEVEZon.controllers.*;

public class ShoppingView extends JPanel {
	public ShoppingView(Magasin mag, StatisticsListener stats) {
		super(new BorderLayout());

		JTable table = new JTable(new GammeViewModel(mag, stats, true));
		JScrollPane scroller = new JScrollPane(table);

		JPanel controls = new JPanel();
		controls.add(buildAjouterButton(table, mag));

		add(controls, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}

	private JButton buildAjouterButton(JTable table, Magasin mag) {
		JButton ajouter = new JButton("Acheter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					Gamme g = (Gamme) (new ArrayList(mag.gammes.values())).get(table.getSelectedRow());
					String gammeName = (String) (new ArrayList(mag.gammes.keySet())).get(table.getSelectedRow());

					int quantite = 0;

					do {
						String quantiteStr = JOptionPane.showInputDialog(null, "Quelle quantité souhaitez vous ?", "Quantité", JOptionPane.QUESTION_MESSAGE);
						if (quantiteStr == null || quantiteStr.length() == 0) {
							return;
						}

						try {
							quantite = Integer.parseInt(quantiteStr);
						} catch (NumberFormatException exeception) {
							// Ne crash pas
						}
					} while (quantite <= 0 || quantite > g.stock.size());

					Client acheteur = askAcheteur();
					if (acheteur == null) {
						return;
					}

					Employe vendeur = askVendeur(mag);
					if (vendeur == null) {
						return;
					}

					Panier p = mag.achete(acheteur, vendeur, gammeName, quantite);

					recapPanier(p);
				}
			}
		});

		return ajouter;
	}

	private Client askAcheteur() {
		String nom = JOptionPane.showInputDialog(null, "Quel est votre nom ?", "Nom", JOptionPane.QUESTION_MESSAGE);
		if (nom == null || nom.length() == 0) {
			return null;
		}

		String prenom = JOptionPane.showInputDialog(null, "Quel est votre prénom ?", "Prénom", JOptionPane.QUESTION_MESSAGE);
		if (prenom == null || prenom.length() == 0) {
			return null;
		}

		String mail = JOptionPane.showInputDialog(null, "Quel est votre adresse mail ?", "Mail", JOptionPane.QUESTION_MESSAGE);
		if (mail == null || mail.length() == 0) {
			return null;
		}

		return new Client(nom, prenom, mail);
	}

	private Employe askVendeur(Magasin mag) {
		ArrayList<String> choices = new ArrayList<String>();

		Iterator iterator = mag.employes.iterator();
		while(iterator.hasNext()) {
			Employe e = (Employe) iterator.next();
			choices.add(String.format("%s %s - %s", e.nom, e.prenom, e.role));
		}

		String choosen = (String) JOptionPane.showInputDialog(
			null,
			"Qui est le vendeur ?",
			"Vendeur",
			JOptionPane.QUESTION_MESSAGE,
			null, // Icone par défaut
			choices.toArray(),
			choices.get(0)
		);

		return mag.employes.get(choices.indexOf(choosen));
	}

	private void recapPanier(Panier p) {
		String recap = String.format(
			"Vous avez acheté %d produits pour une valeur totale de %g €.\nAu plaisir de vous revoir.",
			p.achats.size(),
			p.valeur()
		);

		JOptionPane.showMessageDialog(null, recap, "Reçu", JOptionPane.INFORMATION_MESSAGE);
	}
}
