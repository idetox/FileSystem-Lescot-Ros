package fileSystem;

/**
 * FileSystem
 * 
 * @author Edouard Lescot et Victor Ros
 * @version 27/03/13
 */
abstract class FileSystem {
	private String nom;
	private String type;

	/**
	 * Constructeur des objets de la classe FileSystem
	 */
	public FileSystem(String nom, String type) {
		setNom(nom);
		setType(type);
	}

	/**
	 * Calcul la taille du FileSystem désigné
	 */
	public abstract int taille();
	
	/** Get **/
	public String getNom() {
		return this.nom;
	}

	public String getType() {
		return this.type;
	}

	/** Set **/
	private void setNom(String nom) {
		this.nom = nom;
	}

	private void setType(String type) {
		this.type = type;
	}
}
