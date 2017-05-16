package CapaDomini;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class VendaTest {
	
	private static Producte p1;
	private static Producte p2;

	@BeforeClass
	public static void TestVenda() {
		try {
		 p1 = new Producte(1, "arròs", 1.02f);
         p2 = new Producte(2, "llet semi", 1.22f);
		} catch (Exception e){
			fail ("Error Vendatest: " + e.getMessage());
		}
	}	
	
	@Test
	public void testVendaAfegirArticleNull() {
		try {
			Venda v = new Venda ();
			v.afegirArticle(null, 1);
			fail("Eror: testVendaAfegirArticleNull" );
		} catch (Exception e) {
			assertEquals ("Error afegir article: el producte no pot ser nul", e.getMessage());
		}		
	}
	
	@Test
	public void testVendaAfegirArticleQuantitatZero() {
		try {
			Venda v = new Venda ();
			v.afegirArticle(p1, 0);
			fail("Eror: testVendaAfegirArticleQuantitatZero" );
		} catch (Exception e) {
			assertEquals ("Error afegir article: La quantitat ha de ser un enter positiu", e.getMessage());
		}		
	}
	
	@Test
	public void testVendaAfegirArticleQuantitatNegativa() {
		try {
			Venda v = new Venda ();
			v.afegirArticle(p1, -1);
			fail("Eror:  testVendaAfegirArticleQuantitatNegativa" );
		} catch (Exception e) {
			assertEquals ("Error afegir article: La quantitat ha de ser un enter positiu", e.getMessage());
		}		
	}

	@Test
	public void testVendaImportTotal() {
		try {
			Venda v = new Venda ();
			v.afegirArticle(p2, 1);
			v.afegirArticle(p1, 1);
			v.afegirArticle(p2, 1);
			assertEquals (3.46f, v.importTotal(),0.001);
		} catch (Exception e) {
			fail("Eror: testVendaImportTotal " + e.getMessage());
		}		
	}

	@Test
	public void testVendaNumArticlesVenuts() {
		try {
			Venda v = new Venda ();
			v.afegirArticle(p2, 1);
			v.afegirArticle(p1, 1);
			v.afegirArticle(p2, 1);
			assertEquals ("2", v.numArticlesVenuts());
		} catch (Exception e) {
			fail("Eror: testVendaNumArticlesVenuts " + e.getMessage());
		}
	}
	
	@Test
	public void testVendaImportTotalCapProducte() {
		Venda v = new Venda ();
		assertEquals (0.00f, v.importTotal(),0.001);
	}
	
	@Test
	public void testVendaNumArticlesVenutsCapProducte() {
		Venda v = new Venda ();
		assertEquals ("0", v.numArticlesVenuts());
	}
	
	@Test
	public void testVendaImportTotalCanviantPreuProducte() {
		try {
			Venda v = new Venda ();
			v.afegirArticle(p2, 1);
			v.afegirArticle(p1, 1);
			v.afegirArticle(p2, 1);
			p2.canviarPreu (1.40f);
			assertEquals (3.46f, v.importTotal(),0.001);
		} catch (Exception e) {
			fail("Eror: testVendaImportTotalCanviantPreuProducte " + e.getMessage());
		}	
	}
}