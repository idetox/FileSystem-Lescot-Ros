package fileSystem;

/**
 * La class Fichier
 * 
 * @author Edouard Lescot et Victor Ros
 * @version 27/03/2013
 */
public class Fichier extends FileSystem {
	private int taille;

	/**
	 * Constructeur des objets de la classe Fichier
	 */
	public Fichier(String nom, int taille) {
		super(nom, "Fichier");
		setTaille(taille);
	}

	/**
	 * Retourne la taille du fichier
	 */
	public int taille() {
		return getTaille();
	}

	/** Get **/
	public int getTaille() {
		return this.taille;
	}

	/** Set **/
	private void setTaille(int taille) {
		this.taille = taille;
	}
}
