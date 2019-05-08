package UEVEZon.controllers;

import java.util.Map;
import java.util.HashMap;

import UEVEZon.models.*;

public class StatisticsListener implements MagasinListener, GammeListener {
	public Map<Employe, Double> valeurVendue;
	public Map<Employe, Integer> ventes;
	public Map<Client, Double> valeurAchete;
	public Map<Client, Integer> achats;
	public Map<String, Integer> ventesGamme;

	public int nombreEmployes;
	public int nombreGammesEnVente;
	public int nombreAchats;
	public int nombreVentes;
	public int nombreProduitsEnregistre;
	public double valeurTotaleMagasin;

	public StatisticsListener() {
		valeurVendue = new HashMap<Employe ,Double>();
		ventes = new HashMap<Employe, Integer>();

		valeurAchete = new HashMap<Client, Double>();
		achats = new HashMap<Client, Integer>();

		ventesGamme = new HashMap<String, Integer>();
	}

	public void onMagasinEngage(Employe e) {
		nombreEmployes++;

		valeurVendue.put(e, 0.0);
		ventes.put(e, 0);
	}

	public void onMagasinLicensie(Employe e) {
		nombreEmployes--;
	}

	public void onMagasinVend(String nom, Gamme g) {
		nombreGammesEnVente++;
	}

	public void onMagasinAchete(Client acheteur, Employe vendeur, String gamme, Panier panier) {
		valeurAchete.put(acheteur, valeurAchete.getOrDefault(acheteur, 0.0) + panier.valeur());
		achats.put(acheteur, achats.getOrDefault(acheteur, 0) + panier.achats.size());

		valeurVendue.put(vendeur, valeurVendue.getOrDefault(vendeur, 0.0) + panier.valeur());
		ventes.put(vendeur, ventes.getOrDefault(vendeur, 0) + 1);

		ventesGamme.put(gamme, ventesGamme.getOrDefault(gamme, 0) + panier.achats.size());

		nombreAchats += panier.achats.size();
		nombreVentes++;
	}

	public void onGammeEnregistre(Produit p) {
		nombreProduitsEnregistre++;
		valeurTotaleMagasin += p.prix;
	}
}
