public class Produit {
    public Date entree;
    public Long serie;

    public Produit(Long identifiantProduit) {
        this.serie = identifiantProduit;
    }
}
