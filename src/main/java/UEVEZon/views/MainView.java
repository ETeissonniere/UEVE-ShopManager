package UEVEZon.views;

import javax.swing.*;
import UEVEZon.models.*;

public class MainView {
	JFrame window;

	public MainView(Magasin mag) {
		window = new JFrame();
		JTabbedPane tabs = new JTabbedPane();

		window.add(tabs);
		window.setSize(1200,800);
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void show() {
		window.setVisible(true);
	}
}