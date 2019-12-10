/**
  * Clasa abstracta ce reprezinta cea mai simpla entitate pe care restul o inheriteaza.
  * Clase ce inheriteaza Pasager sunt : MembruFamilie, MembruGrup, Singur, CelulaHeap.
 */
abstract public class Pasager {
	String nume;
	String id;
	int varsta;
	/**
	  * Poate fi economic (e), premium(p), bussiness(b);
	 */
	String tipBilet; 
	boolean prioritar;
	boolean andikapat;

	public Pasager(){}
	/**
	  * Constructor ce genereaza o persoana dupa fielduri
	  * @param id-ul, numele, varsta, tipul de bilet si 2 booluri pentru prioritar si nevoi speciale
	 */
	public Pasager(String id, String nume, int varsta, String tipBilet, boolean prioritar, boolean andicap) 
	{
		this.nume = nume;
		this.id = id;
		this.varsta = varsta;
		this.tipBilet = tipBilet;
		this.prioritar = prioritar;
		this.andikapat = andicap;
	}
	abstract int getPrioritate();
	/**
	   * Metoda abstracta implementata in fiecare clasa care calculeaza prioritatea dupa date.
	   * @param Nefolosite.
	   * @return Nothing.
	   */
	abstract void calculPrioritate();
	abstract String getId();
}
