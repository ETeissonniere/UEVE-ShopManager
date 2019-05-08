package UEVEZon.controllers;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

import UEVEZon.models.*;

public class StatisticsListenerTest {
	@Test public void testOnMagasinEngageInit0() {
		Employe e = new Employe("", "", 0.0, "");
		StatisticsListener stats = new StatisticsListener();
		assertFalse(stats.valeurVendue.containsKey(e));
		assertFalse(stats.ventes.containsKey(e));

		stats.onMagasinEngage(e);
		assertTrue(stats.valeurVendue.containsKey(e));
		assertTrue(stats.ventes.containsKey(e));
		assertEquals(stats.valeurVendue.get(e), 0.0, 0);
		assertEquals(stats.ventes.get(e), new Integer(0));
	}

	@Test public void testOnMagasinEngageIncrementCounter() {
		StatisticsListener stats = new StatisticsListener();
		assertEquals(stats.nombreEmployes, 0);

		stats.onMagasinEngage(new Employe("", "", 0.0, ""));
		assertEquals(stats.nombreEmployes, 1);
	}

	@Test public void testOnMagasinLicensie() {
		// Garde les stats mais réduit le compteur
		Employe e = new Employe("", "", 0.0, "");
		StatisticsListener stats = new StatisticsListener();
		stats.onMagasinEngage(e);
		assertEquals(stats.nombreEmployes, 1);

		stats.onMagasinLicensie(e);
		assertEquals(stats.nombreEmployes, 0);
		assertTrue(stats.valeurVendue.containsKey(e));
		assertTrue(stats.ventes.containsKey(e));
	}

	@Test public void testOnMagasinVend() {
		StatisticsListener stats = new StatisticsListener();
		assertEquals(stats.nombreGammesEnVente, 0);

		stats.onMagasinVend("", new Gamme(0, 0.0, 0.0));
		assertEquals(stats.nombreGammesEnVente, 1);		
	}

	@Test public void testOnMagasinAchete() {
		StatisticsListener stats = new StatisticsListener();
		assertEquals(stats.nombreVentes, 0);
		assertEquals(stats.nombreAchats, 0);

 		Client acheteur = new Client("", "", "");
		Employe vendeur = new Employe("", "", 0.0, "");
		Panier panier = new Panier();
		panier.ajoute(Arrays.asList(new Produit(1, 10.0), new Produit(2, 5.0)));

		stats.onMagasinAchete(acheteur, vendeur, "", panier);
		assertEquals(stats.nombreAchats, 2);
		assertEquals(stats.nombreVentes, 1);
		assertEquals(stats.valeurVendue.get(vendeur), 15.0, 0.0);
		assertEquals(stats.valeurAchete.get(acheteur), 15.0, 0.0);
		assertEquals(stats.ventes.get(vendeur), new Integer(1));
		assertEquals(stats.achats.get(acheteur), new Integer(2));
		assertEquals(stats.ventesGamme.get(""), new Integer(2));
	}

	@Test public void testOnGammeEnregistre() {
		StatisticsListener stats = new StatisticsListener();
		assertEquals(stats.nombreProduitsEnregistre, 0);
		assertEquals(stats.valeurTotaleMagasin, 0.0, 0);

		stats.onGammeEnregistre(new Produit(1, 100.0));
		assertEquals(stats.nombreProduitsEnregistre, 1);
		assertEquals(stats.valeurTotaleMagasin, 100.0, 0);
	}
}