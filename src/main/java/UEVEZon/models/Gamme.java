package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;

public class Gamme {
    public Long codeBarre;
    public Double prix;
    public Double tva;

    public List<Produit> stock;
    public List<Produit> vendu;

    public Gamme(Long codeBarre, Double prix, Double tva) {
        this.codeBarre = codeBarre;
        this.prix = prix;
        this.tva = tva;

        this.stock = new ArrayList<Produit>();
        this.vendu = new ArrayList<Produit>();
    }

    public void enregistreProduit(Produit p) {
        stock.add(p);
    }

    /**
     * Bouge un produit du stock dans la liste des produits vendus
     * et renvoie celui-ci
     */
    public Produit vendProduit() {
        Produit p = stock.get(0); // Le produit le plus vieux en stock
        stock.remove(0);          // Retire du stock
        vendu.add(p);             // Enregistre comme vendu

        return p;
    }
}
