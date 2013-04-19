package filesys;

import exceptions.*;

/**
 * Repertoire
 * 
 * @author Edouard Lescot et Victor Ros
 * @version 27/03/13
 */
public class Repertoire extends FileSystem {
	private static final int MAX_FILES = 2;
	public int nbFiles = 0;
	public FileSystem[] files;

	/**
	 * Constructeur des objets de la classe Repertoire
	 * 
	 * @throws FileSystemNomException
	 */
	public Repertoire(String nom) throws FileSystemNomException {
		super(nom, "Repertoire");
		files = new FileSystem[MAX_FILES];
	}
	
	/**
	 * Check FileSystem déjà existant dans le répertoire courant
	 * @param file
	 * @return boolean
	 */
	public boolean checkFileSystemDejaExistant(FileSystem file) {
		for (int i = 0; i < nbFiles; i++)
			if (file.getType() == files[i].getType()
					&& file.getNom() == files[i].getNom())
				return true;
		return false;
	}
	
	/**
	 * Check si on essaye d'inclure le répertoire courant dans lui-même
	 * @param file
	 * @return boolean
	 */
	public boolean checkMemeRep(Repertoire file) {
		if (this == file)
			return true;
		
		return false;
	}
	
	/**
	 * Check si on essaye d'inclure le répertoire courant plus bas dans son arborescence
	 * @param file
	 * @return boolean
	 */
	public boolean checkMemeRepRecursif(Repertoire file) {
		int i=0;
			while(file.files[i]!=null) {
				if(file.files[i].getType() == "Repertoire") {
					if (file.files[i] == this)
						return true;
					return checkMemeRepRecursif((Repertoire)file.files[i]);
				}
				i++;
		}
		return false;
	}
	
	/**
	 * Ajouter un type de fichier (fichier ou repertoire) au repertoire courant
	 * @param file
	 * @return boolean
	 * @throws ToutesExceptions
	 */
	public boolean ajouterFileSystem(FileSystem file) throws ToutesExceptions {
		if (nbFiles >= MAX_FILES)
			throw new RepertoirePleinException();
		if(file.getType() == "Repertoire") {
			if (checkMemeRep((Repertoire)file))
				throw new RepertoireAjouterALuiMemeException();
			if (checkMemeRepRecursif((Repertoire)file))
				throw new RepertoireAjouterALuiMemeDansSousRepertoireException();
		}
		if (checkFileSystemDejaExistant(file))
			throw new FileSystemDejaExistantException();
		this.files[nbFiles++] = file;
		return true;
	}

	/**
	 * Retourne la taille du repertoire
	 * @throws TailleFichierNegativeException
	 * @return int
	 */
	public int taille() throws TailleFichierNegativeException {
		int tailleTotale = 0;
		for (int i = 0; i < nbFiles; i++) {
			tailleTotale += files[i].taille();
		}

		return tailleTotale;
	}
	
	/** Get*/
	public int getNbFiles() {
		return nbFiles;
	}
}
