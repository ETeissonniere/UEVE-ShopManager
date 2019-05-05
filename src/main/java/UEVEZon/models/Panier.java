package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Panier {
    public List<Produit> achats;

    public Panier() {
        achats = new ArrayList<Produit>();
    }

    public void ajoute(List<Produit> achatsSupplementaires) {
        achats.addAll(achatsSupplementaires);
    }

    public double valeur() {
    	double prixTotal = 0.0;

    	Iterator produits = achats.iterator();
    	while (produits.hasNext()) {
    		Produit p = (Produit) produits.next();
    		prixTotal += p.prix;
    	}

    	return prixTotal;
    }
}
