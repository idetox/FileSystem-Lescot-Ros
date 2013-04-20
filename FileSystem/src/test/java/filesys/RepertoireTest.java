package filesys;

import static org.junit.Assert.*;
import org.junit.*;

import exceptions.*;

public class RepertoireTest {
	@Test
	public void testNom() throws FileSystemNomException {
		String nom="abc";
		Repertoire doc = new Repertoire(nom);
		Assert.assertEquals(nom,doc.getNom());
	}
	@Test
	public void testRepertoireMemeNom() throws ToutesExceptions{
		Repertoire doc1 = new Repertoire("Pere");
		Repertoire doc2 = new Repertoire("Fils");
		Repertoire doc3 = new Repertoire("Fils");
		
		Assert.assertTrue(doc1.ajouterFileSystem(doc2));
		Assert.assertFalse("\n\nEnculé de ta mère espèce de batard !!\n", doc1.ajouterFileSystem(doc3));
	}
	@Test
	public void testTailleAttendueRepertoire() throws ToutesExceptions{
		Repertoire doc1 = new Repertoire("Rep");
		Repertoire doc2 = new Repertoire("Sous-Rep");
		Fichier fic1 = new Fichier("Fic1",25);
		Fichier fic2 = new Fichier("Fic2",30);
		Fichier fic3 = new Fichier("Fic3",45);
		
		assertTrue(doc1.ajouterFileSystem(fic3));	// Arborescence:
		assertTrue(doc1.ajouterFileSystem(doc2));	// Document -- Fic3
		assertTrue(doc2.ajouterFileSystem(fic1));	// 			-- Sous-Document -- Fic1
		assertTrue(doc2.ajouterFileSystem(fic2));	// 							 -- Fic2
		
		assertTrue(doc2.taille()==55);
		assertTrue(doc1.taille()==100);
	}
	
	@Test
	public void testRepAjouterLuiMeme() throws ToutesExceptions {
		Repertoire A = new Repertoire("A");
		Repertoire B = new Repertoire("B");
		
		assertTrue(A.ajouterFileSystem(B));
		assertFalse(A.ajouterFileSystem(A));	// A ne peut être dans A on tombe dans le cas de l'exception.
	}
	@Test
	public void testRepSousRepLuiMeme() throws ToutesExceptions {
		Repertoire A = new Repertoire("A");
		Repertoire B = new Repertoire("B");
		Repertoire C = new Repertoire("C");
		Repertoire D = new Repertoire("D");
		
		assertTrue(A.ajouterFileSystem(B));	// A/B
		assertTrue(B.ajouterFileSystem(C));	// A/B/C
		assertTrue(C.ajouterFileSystem(D));	// A/B/C/D
		assertFalse(D.ajouterFileSystem(A));// A/B/C/D/A Impossible on tombe dans le cas de l'exception.
	}
}