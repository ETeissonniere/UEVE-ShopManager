package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;

public class Gamme {
    public Integer codeBarre;
    public Double prix;
    public Double tva;

    public List<Produit> stock;

    public Gamme(Integer codeBarre, Double prix, Double tva) {
        this.codeBarre = codeBarre;
        this.prix = prix;
        this.tva = tva;

        this.stock = new ArrayList<Produit>();
    }

    public void enregistre(Produit p) {
        stock.add(p);
    }

    public List<Produit> achete(Integer quantite) {
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
