package UEVEZon.models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class PanierTest {
	@Test public void testAjoute() {
		Panier p = new Panier();
		assertEquals(p.achats.size(), 0);

		Produit prod1 = new Produit(1);
		Produit prod2 = new Produit(2);
		p.ajoute(Arrays.asList(prod1, prod2));

		assertEquals(p.achats.size(), 2);
		assertEquals(p.achats.get(0), prod1);
		assertEquals(p.achats.get(1), prod2);
	}

	@Test public void testValeur() {
		Panier p = new Panier();
		Produit prod1 = new Produit(1);
		Produit prod2 = new Produit(2);

		prod1.setPrix(10.0);
		prod2.setPrix(5.0);

		p.ajoute(Arrays.asList(prod1, prod2));

		assertEquals(p.valeur(), 15.0, 0);
	}
}
