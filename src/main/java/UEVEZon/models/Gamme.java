package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;

public class Gamme {
    public int codeBarre;
    public double prix;
    public double tva;

    public List<Produit> stock;

    public Gamme(int codeBarre, double prix, double tva) {
        this.codeBarre = codeBarre;
        this.prix = prix;
        this.tva = tva;

        this.stock = new ArrayList<Produit>();
    }

    public void enregistre(Produit p) {
        stock.add(p);
        p.setPrix(this.prix);
    }

    public List<Produit> achete(int quantite) {
        if (quantite > stock.size()) {
            throw new IllegalArgumentException("pas assez de stock");
        }

        List<Produit> achats = new ArrayList<Produit>();
        for (int i = 0; i < quantite; i++) {
            achats.add(stock.get(0));
            stock.remove(0);
        }

        return achats;
    }
}
