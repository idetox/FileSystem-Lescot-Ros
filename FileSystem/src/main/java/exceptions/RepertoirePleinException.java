package exceptions;

public class RepertoirePleinException extends ToutesExceptions{
	public RepertoirePleinException() {
		super("\nImpossible d'ajouter.\nRépertoire Plein.\n");
	}
}
