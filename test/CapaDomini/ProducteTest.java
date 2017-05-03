package CapaDomini;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProducteTest {

	private static Producte p1;
	private static Producte p2;

	@BeforeClass
	public static void TestProducte() {
		try {
			p1 = new Producte(4, "sucre", 1.45f);
			p2 = new Producte(5, "sal", 0.44f);
		} catch (Exception e){
			fail ("Error Vendatest: " + e.getMessage());
		}
	}	
	
	@Test
	public void testProducteIdNoValid() {
		try {
			new Producte(-5, "error", 8.02f);
			fail("Eror testProducteIdNoValid");
		} catch (Exception e) {
			assertEquals("Error Producte: l'identificador ha de ser un enter més gran que zero",e.getMessage());
		}
	}	
	
	@Test
	public void testEqualsObjectIguals() {
		assertTrue(p1.equals(p1));
	}
	
	@Test
	public void testEqualsObjectDiferents() {
		assertTrue(! p1.equals(p2));
	}

	@Test
	public void testProducteIdRepe() {
		try {
			new Producte(5, "error", 8.02f);
			fail("Eror testProducteIdRepe");
		} catch (Exception e) {
			assertEquals("Error Producte: Ja existeix un producte amb aquest identificador.",e.getMessage());
		}
	}	
	
	@Test
	public void testProducteDescripcioNull() {
		try {
			new Producte(8, null, 8.02f);
			fail("Eror testProducteDescripcioNull");
		} catch (Exception e) {
			assertEquals("Error Producte: La descripció ha de tenir com a mínim 3 caracters.",e.getMessage());
		}
	}	
	
	@Test
	public void testProducteDescripcioBuida() {
		try {
			new Producte(8, "", 8.02f);
			fail("Eror testProducteDescripcioBuida");
		} catch (Exception e) {
			assertEquals("Error Producte: La descripció ha de tenir com a mínim 3 caracters.",e.getMessage());
		}
	}
	
	@Test
	public void testProducteDescripcioMenysDeTres() {
		try {
			new Producte(8, "Pi", 8.02f);
			fail("Eror testProducteDescripcioMenysDeTres");
		} catch (Exception e) {
			assertEquals("Error Producte: La descripció ha de tenir com a mínim 3 caracters.",e.getMessage());
		}
	}
	
	@Test
	public void testProductePreuZero() {
		try {
			new Producte(8, "Patates", 0.00f);
			fail("Eror testProductePreuZero");
		} catch (Exception e) {
			assertEquals("Error Producte: El preu ha de ser més gran que zero.",e.getMessage());
		}
	}
	
	@Test
	public void testProductePreuNegativa() {
		try {
			new Producte(8, "Patates", -0.01f);
			fail("Eror testProductePreuNegativa");
		} catch (Exception e) {
			assertEquals("Error Producte: El preu ha de ser més gran que zero.",e.getMessage());
		}
	}

	@Test
	public void testProducteToString() {
		try {
			assertEquals ("Article: sucre. Preu = 1.45. ID Article = 4",p1.toString());
		} catch (Exception e) {
			fail("Eror testProducteToString");
		}
		
	}	
}