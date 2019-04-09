import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Panier {
    public Date paiement;
    public Double valeur;

    public Map<Gamme, Integer> achats;

    public Panier() {
        this.paiement = new Date();
        this.achats = new HashMap<Gamme, Integer>();
    }

    public void achete(Gamme produits, Integer quantite) {
        achats.put(produits, quantite);
        valeur += produits.prix * quantite;
    }
}
