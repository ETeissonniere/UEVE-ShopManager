package UEVEZon.views;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import UEVEZon.models.*;

public class EmployeView extends JPanel {
	public EmployeView(Magasin mag) {
		super(new BorderLayout());

		JTable table = new JTable(new EmployeViewModel(mag));
		JScrollPane scroller = new JScrollPane(table);

		JPanel controls = new JPanel();
		controls.add(buildLicensierButton(table));
		controls.add(buildEngagerButton(table));

		add(controls, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}

	private JButton buildLicensierButton(JTable table) {
		JButton licensier = new JButton("Licensier");
		licensier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((EmployeViewModel)table.getModel()).removeRow(table.getSelectedRow());
			}
		});

		return licensier;
	}

	private JButton buildEngagerButton(JTable table) {
		JButton engager = new JButton("Engager");
		engager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});

		return engager;
	}

	private JPanel buildEngagerForm(JTable table) {
		JPanel engagerForm = new JPanel();
		Border border = engagerForm.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 10);
		engagerForm.setBorder(new CompoundBorder(border, margin));

		GridBagLayout panelGridBagLayout = new GridBagLayout();
		panelGridBagLayout.columnWidths = new int[] { 86, 86, 0 };
		panelGridBagLayout.rowHeights = new int[] { 20, 20, 20, 20, 20, 0 };
		panelGridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelGridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		engagerForm.setLayout(panelGridBagLayout);

		addLabelAndTextField("Nom :", 0, engagerForm);
		addLabelAndTextField("Prénom :", 1, engagerForm);
		addLabelAndTextField("Salaire :", 2, engagerForm);
		addLabelAndTextField("Role :", 3, engagerForm);

		return engagerForm;
	}

	private void addLabelAndTextField(String labelText, int yPos, Container containingPanel) {

		JLabel label = new JLabel(labelText);
		GridBagConstraints gridBagConstraintForLabel = new GridBagConstraints();
		gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
		gridBagConstraintForLabel.insets = new Insets(0, 0, 5, 5);
		gridBagConstraintForLabel.gridx = 0;
		gridBagConstraintForLabel.gridy = yPos;
		containingPanel.add(label, gridBagConstraintForLabel);

		JTextField textField = new JTextField();
		GridBagConstraints gridBagConstraintForTextField = new GridBagConstraints();
		gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
		gridBagConstraintForTextField.insets = new Insets(0, 0, 5, 0);
		gridBagConstraintForTextField.gridx = 1;
		gridBagConstraintForTextField.gridy = yPos;
		containingPanel.add(textField, gridBagConstraintForTextField);
		textField.setColumns(10);
	}

}