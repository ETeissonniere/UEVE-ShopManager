package UEVEZon.models;

import java.util.List;

public class StatisticsListener implements MagasinListener, GammeListener {
	public void onMagasinEngage(Employe e) {}
	public void onMagasinLicensie(Employe e) {}
	public void onMagasinVend(String nom, Gamme g) {}
	public void onMagasinAchete(Client acheteur, Employe vendeur, String gamme, List<Produit> achats) {}
	public void onGammeEnregistre(Produit p) {}
}