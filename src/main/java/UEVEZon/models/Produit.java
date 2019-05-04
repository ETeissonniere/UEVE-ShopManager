package UEVEZon.models;

import java.util.Date;

public class Produit {
    public Date entree;
    public Long serie;

    public Produit(Long identifiantProduit) {
        this.serie = identifiantProduit;
    }
}
