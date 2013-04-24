package filesys;

import static org.junit.Assert.*;
import org.junit.*;

import exceptions.*;

public class FichierTest {	
	@Test
	public void testTailleFichierAttendue() throws ToutesExceptions {
		Fichier fic = new Fichier("Fichier.txt",20);
		
		assertEquals(20,fic.taille()); // La taille attendue doit être de 20
	}
	@Test
	public void testTailleNegativeFichier() throws ToutesExceptions{
		int taille=-25;
		Fichier fic1 = new Fichier("Fic1",taille);
		Assert.assertEquals(taille,fic1.taille());
	}
	
	@Test (expected=FileSystemDejaExistantException.class)
	public void testFichierMemeNom() throws ToutesExceptions {
		Repertoire doc = new Repertoire("Document");
		Fichier fic1 = new Fichier("Fic1", 15);
		Fichier fic2 = new Fichier("Fic1", 30);
		
		doc.ajouterFileSystem(fic1);
		doc.ajouterFileSystem(fic2);	// fic2 a le meme nom que fic1 donc on tombe dans le cas de l'exception.
	}
}
