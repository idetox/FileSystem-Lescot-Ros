package filesys;

import exceptions.*;

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
	 * @param nom
	 * @param type
	 * @throws FileSystemNomException
	 */
	public FileSystem(String nom, String type) throws FileSystemNomException{
		if(nom==null) throw new FileSystemNomException();
		setType(type);
		setNom(nom);
	}

	/**
	 * Calcul la taille du FileSystem désigné
	 * @return int
	 * @throws TailleFichierNegativeException
	 */
	public abstract int taille() throws TailleFichierNegativeException;
	
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
