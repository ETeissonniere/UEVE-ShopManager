package UEVEZon.models;

import java.util.List;

public interface MagasinListener {
	void onMagasinEngage(Employe e);
	void onMagasinLicensie(Employe e);
	void onMagasinVend(String nom, Gamme g);
	void onMagasinAchete(Client acheteur, Employe vendeur, String gamme, List<Produit> achats);
}