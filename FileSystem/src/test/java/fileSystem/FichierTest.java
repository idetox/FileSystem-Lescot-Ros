package fileSystem;

import fileSystem.*;
import junit.framework.TestCase;

public class FichierTest extends TestCase {	
	public static void testTailleFichier() {
		Fichier fic = new Fichier("Fichier.txt",20);
		
		assertTrue(fic.taille() == 20); // La taille attendue doit être de 20
	}
	
	public static void testFichierMemeNom() {
		Repertoire doc = new Repertoire("Document");
		Fichier fic1 = new Fichier("Fic1", 15);
		Fichier fic2 = new Fichier("Fic1", 30);
		
		assertTrue(doc.ajouterFileSystem(fic1));	// On ajoute fic1 à doc
		
		// Pour tous les Files de doc (ici fic1),
		for (int i = 0; i < doc.nbFiles; i++) {
			// On regarde si fic2 est de meme type que doc.files[i] = fic1
			if (doc.files[i].getType() == fic2.getType()) {
				// Si oui on regarde si fic1 et fic2 ont le même nom
				if((fic2.getNom()).equals((doc.files[i].getNom()))) {
					// Si c'est le cas on ne l'ajoute pas 
				}
				else {
					// Sinon on ajoute fic2 à doc
					assertTrue(doc.ajouterFileSystem(fic2));
				}
			}
		}
	}
}
