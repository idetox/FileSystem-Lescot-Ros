package exceptions;

public class RepertoireAjouterALuiMemeException extends ToutesExceptions {
	public RepertoireAjouterALuiMemeException() {
		super("\nImpossible d'ajouter le répertoire courant à lui-même.\n");
	}
}
