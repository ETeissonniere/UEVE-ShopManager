package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;

public class Panier {
    public List<Produit> achats;

    public Panier() {
        achats = new ArrayList<Produit>();
    }

    public void ajoute(List<Produit> achatsSupplementaires) {
        achats.addAll(achatsSupplementaires);
    }
}
