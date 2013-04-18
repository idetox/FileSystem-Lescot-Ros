package fileSystem;

/**
 * Repertoire
 * 
 * @author Edouard Lescot et Victor Ros
 * @version 27/03/13
 */
public class Repertoire extends FileSystem {
	private static final int MAX_FILES = 10;
	public int nbFiles = 0;
	public FileSystem[] files;

	/**
	 * Constructeur des objets de la classe Repertoire
	 */
	public Repertoire(String nom) {
		super(nom, "Repertoire");
		files = new FileSystem[MAX_FILES-1];
	}

	/**
	 * Ajouter un type de fichier (fichier ou repertoire) au repertoire courant
	 */
	public boolean ajouterFileSystem(FileSystem file) {
		if (nbFiles < MAX_FILES) {
			files[nbFiles] = file;
			nbFiles++;
		}

		return nbFiles < MAX_FILES;
	}

	/**
	 * Retourne la taille du repertoire
	 */
	public int taille() {
		int tailleTotale = 0;
		for (int i = 0; i < nbFiles; i++) {
			tailleTotale += files[i].taille();
		}

		return tailleTotale;
	}
}
