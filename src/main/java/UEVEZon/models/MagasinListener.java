package UEVEZon.models;

public interface MagasinListener {
	void onMagasinEngage(Employe e);
	void onMagasinLicensie(Employe e);
	void onMagasinVend(String nom, Gamme g);
	void onMagasinAchete(Client acheteur, Employe vendeur, String gamme, Panier panier);
}