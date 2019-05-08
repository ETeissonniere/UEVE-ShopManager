package UEVEZon;

import UEVEZon.models.*;
import UEVEZon.controllers.StatisticsListener;
import UEVEZon.views.MainView;

public class App {
    public static void main(String[] args) {
    	StatisticsListener stats = new StatisticsListener();

        Magasin mag = new Magasin();
        mag.setListener(stats);
    	mag.engage(new Employe("Teissonniere", "Eliott", 10000.0, "PDG"));
    	mag.engage(new Employe("Gayda", "Yann", 10000.0, "PDG"));
    	mag.engage(new Employe("Dupont", "Robert", 1000.0, "caissier"));

    	Gamme pcs = new Gamme(23456, 400.0, 0.2);
    	pcs.setListener(stats);
    	pcs.enregistre(new Produit(3456));
    	pcs.enregistre(new Produit(5678));
    	pcs.enregistre(new Produit(2345));

    	Gamme macbooks = new Gamme(42424242, 1500.0, 0.2);
    	macbooks.setListener(stats);
    	macbooks.enregistre(new Produit(5618));
    	macbooks.enregistre(new Produit(2315));

    	mag.vend("PCs moyen", pcs);
    	mag.vend("Apple MacBooks", macbooks);

    	MainView window = new MainView(mag, stats);
    	window.show();
    }
}
