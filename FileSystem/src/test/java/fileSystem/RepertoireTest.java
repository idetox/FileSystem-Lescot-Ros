package fileSystem;

import fileSystem.*;
import junit.framework.TestCase;

public class RepertoireTest extends TestCase {
	
	public static void testRefNull() {
		Repertoire test = new Repertoire(null);
		assertFalse(test.getNom() != null);
	}
	
	public static void testRepertoireMemeNom() {
		Repertoire doc1 = new Repertoire("Pere");
		Repertoire doc2 = new Repertoire("Fils");
		Repertoire doc3 = new Repertoire("Fils");
		
		assertTrue(doc1.ajouterFileSystem(doc2));	// doc2 est ajouté à doc1
		
		// Pour tous les Fils de doc1 (ici doc2)
		for (int i = 0; i < doc1.nbFiles; i++) {
			// On vérifie que doc3 est du même type que doc1.files[i] = doc2 dans l'exemple
			if (doc3.getType() == doc1.files[i].getType()) {
				// Si oui, on vérifie si doc3 a le même nom de que doc2
				if (doc3.getNom() == doc1.files[i].getNom()) {
					//Si doc3 a le même nom que doc2 on ne l'ajoute pas.
				}
				else {
					//Sinon on ajoute doc3 à doc1 (RESULTAT ATTENDU)
					assertTrue(doc1.ajouterFileSystem(doc3));
				}
			}
		}
	}
	
	public static void testTailleRepertoire() {
		Repertoire doc1 = new Repertoire("Rep");
		Repertoire doc2 = new Repertoire("Sous-Rep");
		Fichier fic1 = new Fichier("Fic1",25);
		Fichier fic2 = new Fichier("Fic2",30);
		Fichier fic3 = new Fichier("Fic3",45);
		
		assertTrue(doc1.ajouterFileSystem(fic3));	// Arborescence:
		assertTrue(doc1.ajouterFileSystem(doc2));	// Document => Fic3
		assertTrue(doc2.ajouterFileSystem(fic1));	// 			   Sous-Document => Fic1
		assertTrue(doc2.ajouterFileSystem(fic2));	// 								Fic2
		
		assertTrue(doc2.taille()==55);
		assertTrue(doc1.taille()==100);
		
	}
	
	public static void testRepAjouterLuiMeme() {
		Repertoire doc = new Repertoire("Document");
		
		// Uniquement possible avec les Exceptions pour checker les noms pour autoriser ou non l'ajout
	}
	
	public static void testRepSousRepLuiMeme() {
		Repertoire pater = new Repertoire("abc");
		Repertoire fils = new Repertoire("abc");
		pater.ajouterFileSystem(fils);
		fils.ajouterFileSystem(pater);
		for (int i = 0; i < pater.nbFiles; i++) {
			if (pater.files[i].getType() == "Repertoire") {
				Repertoire tmp = (Repertoire) pater.files[i];
				for (int j = 0; j < tmp.nbFiles; j++) {
					assertNotSame(pater, tmp.files[j]);
				}
			}
		}
	}
}