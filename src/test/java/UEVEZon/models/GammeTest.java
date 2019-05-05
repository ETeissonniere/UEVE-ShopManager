package UEVEZon.models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import UEVEZon.controllers.StatisticsListener;

public class GammeTest {
	@Test public void testEnregistre() {
		Produit p = new Produit(0);
		Gamme g = new Gamme(3546, 100.0, 0.2);
		assertEquals(g.stock.size(), 0);
		assertEquals(p.prix, 0.0, 0);

		g.enregistre(p);
		assertEquals(p.prix, 100.0, 0);
		assertEquals(g.stock.size(), 1);
		assertEquals(g.stock.get(0), p);
	}

	@Test public void testAcheteQuantiteOk() {
		Produit p = new Produit(42);
		Gamme g = new Gamme(3546, 100.0, 0.2);
		g.enregistre(p);

		List<Produit> achats = g.achete(1);
		assertEquals(achats.size(), 1);
		assertEquals(achats.get(0), p);
		assertEquals(g.stock.size(), 0);
	}

	// On veut une erreur!
	@Test(expected=IllegalArgumentException.class) public void testAcheteBadQuantite() {
		Gamme g = new Gamme(3546, 100.0, 0.2);
		g.achete(1);

		// Juste au cas où
		throw new RuntimeException();
	}

	@Test public void testSetListener() {
		Gamme g = new Gamme(3546, 100.0, 0.2);

		assertNull(g.listener);

		StatisticsListener listener = new StatisticsListener();
		g.setListener(listener);

		assertEquals(g.listener, listener);
	}
}
