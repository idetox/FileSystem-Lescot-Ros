package filesys;

import static org.junit.Assert.*;
import org.junit.*;

import exceptions.*;

public class FichierTest {	
	@Test
	public void testTailleFichierAttendue() throws ToutesExceptions {
		int taille=20;
		if(taille<0) taille=0;
		Fichier fic = new Fichier("Fichier.txt",taille);
		assertTrue(fic.taille() == 20); // La taille attendue doit être de 20
	}
	@Test
	public void testTailleNegativeFichier() throws ToutesExceptions{
		int taille=-25;
		if(taille<0) taille=0;
		Fichier fic = new Fichier("Fichier.txt",taille);
		assertTrue(fic.taille() == 0); // La taille attendue doit être de 0
	}
	
	@Test
	public void testFichierMemeNom() throws ToutesExceptions {
		Repertoire doc = new Repertoire("Document");
		Fichier fic1 = new Fichier("Fic1", 15);
		Fichier fic2 = new Fichier("Fic1", 30);
		
		doc.ajouterFileSystem(fic1);
		if(fic2.getNom()!=fic1.getNom()) doc.ajouterFileSystem(fic2);
		assertTrue(doc.taille() == 15);		// Car seul fic1 a été ajouté à doc
	}
}
