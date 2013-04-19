package exceptions;

public class FileSystemDejaExistantException extends ToutesExceptions{
	public FileSystemDejaExistantException() {
		super("\nCe FileSystem existe déjà dans ce répertoire.\n");
	}
}
