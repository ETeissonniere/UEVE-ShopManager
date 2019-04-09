import java.util.Date;

public class Livraison {
    public Date depart;
    public Date reception;
    public StatutLivraison statut;

    public Livraison() {
        this.statut = StatutLivraison.PREPARATION;
    }
}
