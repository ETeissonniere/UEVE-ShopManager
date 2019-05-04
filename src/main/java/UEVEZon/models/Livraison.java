package UEVEZon.models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Livraison {
    public Date depart;
    public Date reception;
    public StatutLivraison statut;
    public List<Produit> coffre;

    public Livraison() {
        this.statut = StatutLivraison.PREPARATION;
        this.coffre = new ArrayList<Produit>();
    }

    public void ajoute(Produit p) {
        this.coffre.add(p);
    }

    public void demarre() {
        this.statut = StatutLivraison.TRANSIT;
    }
}
