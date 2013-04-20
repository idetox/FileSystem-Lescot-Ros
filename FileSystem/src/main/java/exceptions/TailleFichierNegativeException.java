package exceptions;

public class TailleFichierNegativeException extends ToutesExceptions {
	public TailleFichierNegativeException() {
		super("\nImpossible d'ajouter un fichier avec une taille négative.\n");
	}
}
