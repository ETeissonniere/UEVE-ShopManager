package UEVEZon.views;

import javax.swing.*;
import java.awt.GridLayout;
import UEVEZon.models.*;

public class MainView {
	JFrame window;

	public MainView(Magasin mag) {
		JTabbedPane tabs = new JTabbedPane();
		tabs.add("Employes", new EmployeView(mag));
		tabs.add("mock", new EmployeView(mag));

		window = new JFrame();
		window.setSize(1200, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(new GridLayout(1, 1));
		window.getContentPane().add(tabs);
	}

	public void show() {
		window.setVisible(true);
	}
}