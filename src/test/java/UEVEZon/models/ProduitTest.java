package UEVEZon.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProduitTest {
	@Test public void testSetPrix() {
		Produit p = new Produit(0);
		assertEquals(p.prix, 0.0, 0);

		// Utilisé par Gamme
		p.setPrix(100.0);
		assertEquals(p.prix, 100.0, 0);
	}
}
