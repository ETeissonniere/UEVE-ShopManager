package UEVEZon.models;

import java.util.Date;

public class Produit {
    public Date entree;
    public Integer serie;

    public Produit(Integer identifiantProduit) {
        this.serie = identifiantProduit;
    }
}
