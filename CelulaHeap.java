import java.util.ArrayList;
/**
 * Clasa folosita pentru celulele din Heap pentru ca ele pot fi 
 * compuse din familii, grupuri sau single.
 */
public class CelulaHeap extends Pasager {
	ArrayList<Pasager> pasageri =  new ArrayList<Pasager>(); //grup sau familie
	String id;
	int prioritate;
	
	/**
     * Instantiaza o celula cu un anumit id.
	   * @param id-ul celului
	   */
	public CelulaHeap(String id) {
		super();
		this.id = id;
	}
	/**
     * Functie care calculeaza prioritatea unui grup, familie sau single.
	   * @param Nefolosit.
	   * @return Nothing.
	   */
	void calculPrioritate()
	{
		for(Pasager i : pasageri)
		{
			prioritate += i.getPrioritate();
		}
		if(id.contains("f"))
		{
			prioritate += 10;
		}
		if(id.contains("g"))
		{
			prioritate += 5;
		}
	}
	/**
     * Functie care adauga intr-o grupare familie sau grup un element.
	   * @param Nefolosit.
	   * @return Nothing.
	   */
	void adaugareInGrup(Pasager p)
	{
		pasageri.add(p);
	}

	@Override 
	int getPrioritate() {
		return 0;
	}

	@Override
	String getId() {
		return null;
	}
}	
