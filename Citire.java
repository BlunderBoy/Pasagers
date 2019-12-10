import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Clasa folosita la citire.
 */
public class Citire {
	File fisier;
	Scanner sc;
	/**
	 * Constructor care instantiaza un cititor pe un fisier citit ca input.
	 */
	Citire(String file) throws FileNotFoundException
	{
		this.fisier = new File(file); 
		sc = new Scanner(fisier);
	}
	/**
     * Functie care citeste o linie (String) noua sau returneaza null;
	   * @param Nefolosit.
	   * @return O linie noua (String).
	   */
	String linieNoua() throws Exception 
	{
		String linie = ""; 
		if(sc.hasNextLine())
		{
			linie = sc.nextLine();
			return linie;
		}
		else
		{
			return null; //end of file (EOF)
		}
	}
	/**
     * Functie care citeste o cifra (int) noua sau returneaza 0(teoretic niciodata);
	   * @param Nefolosit.
	   * @return Un integer.
	   */
	int numarPasageri() throws Exception //citeste numarul de pasageri
	{
		int numarPasageri;
		if(sc.hasNextLine())
		{
			numarPasageri = sc.nextInt();
			sc.nextLine();
			return numarPasageri;
		}
		
		return 0; //nu ar trebui sa intre pe else, da cn stie
	}
	/**
     * Functie care inchide obiectul folosit la citire;
	   * @param Nefolosit.
	   * @return Nothing.
	   */
	void closeScanner()
	{
		sc.close();
	}
}
