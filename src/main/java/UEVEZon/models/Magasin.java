package UEVEZon.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Magasin {
	public List<Employe> employes;
	public Map<String, Gamme> gammes;

	MagasinListener listener;

	public Magasin() {
		this.employes = new ArrayList<Employe>();
		this.gammes = new LinkedHashMap<String, Gamme>();
	}

	public void setListener(MagasinListener listener) {
		this.listener = listener;
	}

	public void engage(Employe e) {
		employes.add(e);

		if (listener != null) {
			listener.onMagasinEngage(e);
		}
	}

	public void licensie(Employe e) {
		employes.remove(e);

		if (listener != null) {
			listener.onMagasinLicensie(e);
		}
	}

	public void licensie(int id) {
		licensie(employes.get(id));
	}

	public void vend(String nom, Gamme g) {
		gammes.put(nom, g);

		if (listener != null) {
			listener.onMagasinVend(nom, g);
		}
	}

	public Panier achete(Client acheteur, Employe vendeur, String gamme, int quantite) {
		Panier p = new Panier();
		p.ajoute(gammes.get(gamme).achete(quantite));

		if (listener != null) {
			listener.onMagasinAchete(acheteur, vendeur, gamme, p);
		}

		return p;
	}
}