package UEVEZon.models;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Panier {
    public Date paiement;
    public Double valeur;
    public Client acheteur;

    public Map<Gamme, Integer> achats;
    public Livraison livraison;

    public Panier() {
        this.paiement = new Date();
        this.achats = new HashMap<Gamme, Integer>();
    }

    public void achete(Gamme produits, Integer quantite) {
        achats.put(produits, quantite);
        valeur += produits.prix * quantite;
    }

    public void declencheLivraison() {
        this.livraison = new Livraison();

        // Itere achats
        for (Gamme g : achats.keySet()) {
            Integer quantite = achats.get(g);

            for (int i = 0; i < quantite; i++) {
                this.livraison.ajoute(g.vendProduit());
            }
        }

        this.livraison.demarre();
    }
}
