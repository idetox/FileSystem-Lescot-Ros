package exceptions;

public class RepertoireAjouterALuiMemeDansSousRepertoireException extends ToutesExceptions {
	public RepertoireAjouterALuiMemeDansSousRepertoireException() {
		super("\nImpossible d'ajouter le répertoire courant.\nC'est un sous répertoire de lui-même .\n");
	}
}