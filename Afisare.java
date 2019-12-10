import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clasa folosita la afisare;
 */
public class Afisare {
	FileWriter sc;
	File out;
	/**
	 * Constructor care instantiaza un scriitor pe un fisier citit ca input.
	 */
	Afisare(String file) throws IOException
	{
		out = new File("queue.out");
		out.createNewFile();
		out.setWritable(true);
		sc = new FileWriter(out);
	}
	/**
     * Functie care printeaza o linie.
	   * @param Linia de scris.
	   * @return Nothing.
	   */
	void printLinie(String s) throws IOException
	{
		sc.write(s);
	}
	/**
     * Functie care scrie un \n pentru un nou rand.
	   * @param Nefolosit.
	   * @return Nothing.
	   */
	void linieNoua() throws IOException
	{
		sc.write("\n");
	}
	void closeSc() throws IOException
	{
		sc.close();
	}
}
