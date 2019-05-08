package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import UEVEZon.models.*;

public class GammeView extends JPanel {
	public GammeView(Magasin mag) {
		super(new BorderLayout());

		JTable table = new JTable(new GammeViewModel(mag));
		JScrollPane scroller = new JScrollPane(table);

		JPanel controls = new JPanel();
		// Ajoute un produit
		// Ajoute une gamme
		// Supprime une gamme
		//controls.add(buildLicensierButton(table));
		//controls.add(buildEngagerButton(this, table));

		add(controls, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}
}