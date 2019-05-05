package UEVEZon.models;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import UEVEZon.controllers.StatisticsListener;

public class MagasinTest {
	@Test public void testEngage() {
		Magasin mag = new Magasin();
		assertEquals(mag.employes.size(), 0);

		mag.engage(new Employe("test", "test", 1.0, "tester"));
		assertEquals(mag.employes.size(), 1);
		assertEquals(mag.employes.get(0).nom, "test");
		assertEquals(mag.employes.get(0).prenom, "test");
		assertEquals(mag.employes.get(0).role, "tester");
		assertEquals(mag.employes.get(0).salaire, 1.0, 0);
	}

	@Test public void testLicensieSameObject() {
		Employe tester = new Employe("test", "test", 1.0, "tester");

		Magasin mag = new Magasin();
		mag.engage(tester);
		mag.licensie(tester);

		assertEquals(mag.employes.size(), 0);
	}

	@Test public void testLicensieDifferentObject() {
		Employe tester1 = new Employe("test", "test", 1.0, "tester");
		Employe tester2 = new Employe("test", "test", 1.0, "tester");

		Magasin mag = new Magasin();
		mag.engage(tester1);
		mag.licensie(tester2);

		// Objet différent donc pas de suppression
		assertEquals(mag.employes.size(), 1);
	}

	@Test public void testLicensieId() {
		Employe tester = new Employe("test", "test", 1.0, "tester");

		Magasin mag = new Magasin();
		mag.engage(tester);
		mag.licensie(0);

		assertEquals(mag.employes.size(), 0);
	}

	@Test public void testVend() {
		Magasin mag = new Magasin();
		assertEquals(mag.gammes.size(), 0);

		Gamme g = new Gamme(45678, 100.0, 0.2);
		mag.vend("mock", g);

		assertEquals(mag.gammes.size(), 1);
		assertEquals(mag.gammes.get("mock"), g);
	}

	@Test public void testAchete() {
		Magasin mag = new Magasin();
		Gamme g = new Gamme(45678, 100.0, 0.2);
		g.enregistre(new Produit(1));

		mag.vend("mock", g);
		List<Produit> achats = mag.achete(new Client("", "", ""), new Employe("", "", 0.0, ""), "mock", 1);
		assertEquals(achats.get(0).serie, 1);
	}

	@Test public void testSetListener() {
		Magasin mag = new Magasin();

		assertNull(mag.listener);

		StatisticsListener listener = new StatisticsListener();
		mag.setListener(listener);

		assertEquals(mag.listener, listener);
	}
}
