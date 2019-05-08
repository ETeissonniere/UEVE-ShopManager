package UEVEZon.models;

import java.util.Date;

public class Produit {
    public Date entree;
    public int serie;
    public double prix; // Configuré par Gamme, utilisé par Panier

    public Produit(int identifiantProduit) {
        this.serie = identifiantProduit;
    }

    public Produit(int identifiantProduit, double prix) {
    	this.serie = identifiantProduit;
    	this.prix = prix;
    }

    public void setPrix(double prix) {
    	this.prix = prix;
    }
}
