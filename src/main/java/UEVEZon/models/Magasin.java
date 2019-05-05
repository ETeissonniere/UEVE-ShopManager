package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Magasin {
	public List<Employe> employes;
	public Map<String, Gamme> gammes;

	public Magasin() {
		this.employes = new ArrayList<Employe>();
		this.gammes = new HashMap<String, Gamme>();
	}

	public void engage(Employe e) {
		this.employes.add(e);
	}

	public void licensie(Employe e) {
		this.employes.remove(e);
	}

	public void licensie(int id) {
		this.employes.remove(id);
	}

	public void vend(String nom, Gamme g) {
		this.gammes.put(nom, g);
	}

	public List<Produit> achete(Client acheteur, Employe vendeur, String gamme, int quantite) {
		// TODO: enregistre acheteur pour stats
		// TODO: enregistre vendeur pour stats
		return gammes.get(gamme).achete(quantite);
	}
}