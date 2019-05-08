package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import UEVEZon.models.*;

public class EmployeView extends JPanel {
	public EmployeView(Magasin mag) {
		super(new BorderLayout());

		JTable table = new JTable(new EmployeViewModel(mag));
		JScrollPane scroller = new JScrollPane(table);

		// Controles
		JPanel controls = new JPanel(new BorderLayout());
		JButton licensier = new JButton("Licensier");
		licensier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((EmployeViewModel)table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		controls.add(licensier);

		add(controls, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}
}