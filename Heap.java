import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Clasa care se ocupa cu heap-ul din spatele programului si in care avem toate operatiile.
 */
public class Heap {
	ArrayList<CelulaHeap> vector;
	Afisare scriitor;
	/**
	   * Constructorul instantiaza un FileWriter si ArrayList-ul in care este tinut Heap-ul.
	   */
	public Heap() throws IOException {
		vector  = new ArrayList<CelulaHeap>();
		scriitor = new Afisare("queue.out");
	}    
	/**
	   * @param Nodul curent.
	   * @return Parintele nodului.
	   */
	int parinte(int curent){ return (curent-1)/2; }
	/**
	   * @param Nodul curent.
	   * @return Copilul stang al nodului.
	   */
	int left(int curent)   { return (2*curent + 1); } 
	/**
	   * @param Nodul curent.
	   * @return Copilul drept al nodului.
	   */
    int right(int curent)  { return (2*curent + 2); } 
    
    /**
       * Functie de inserare in Heap.
	   * @param Pasagerul ce trebuie inserat si prioritatea cu care este inserat.
	   * @return Nothing.
	   */
	void insert(Pasager p, int priority)
	{
		vector.add((CelulaHeap) p );
		int i = vector.size() - 1;
		while(i != 0 && vector.get(parinte(i)).prioritate < vector.get(i).prioritate)
		{
			Collections.swap(vector, parinte(i), i);
			i = parinte(i);
		}
	}
	/**
       * Functie de extragere al maximului din Heap.
	   * @param Nefolosit.
	   * @return Nothing.
	   */
	void embark()
	{ 
		Pasager k = vector.get(0);
		Collections.swap(vector, 0, vector.size() - 1);
		vector.remove(k);
		Heapify(0);
	}
	/**
     * Functie de Heapify folosita intern pentru a pastra Heapul.
	   * @param Indexul curent.
	   * @return Nothing.
	   */
	void Heapify(int curent)
	{ 
	    int l = left(curent); 
	    int r = right(curent); 
	    int max = curent; 
	    if (l < vector.size() && vector.get(l).prioritate > vector.get(curent).prioritate) 
	        max = l; 
	    if (r < vector.size() && vector.get(r).prioritate > vector.get(max).prioritate) 
	        max = r; 
	    if (max != curent) 
	    { 
	    	Collections.swap(vector, curent, max);
	        Heapify(max); 
	    } 	
	} 
	/**
     * Functie de afisare in preordine a Heapului folosita intern pentru a implementa list.
	   * @param Indexul curent, Obicetul cu care fac afisarea
	   * @return Nothing.
	   */
	void printPreordine(int index, Afisare scriitor) throws IOException 
	{ 
       if (index >= vector.size()) 
       return;
	  
	    scriitor.printLinie(vector.get(index).id + " "); 
	  
	    //left
	    printPreordine(left(index), scriitor); 
	  
	    //right
	    printPreordine(right(index), scriitor);  
	} 
	/**
     * Functie care apeleaza printPreordine;
	   * @param Nefolosit.
	   * @return Nothing.
	   */
	void list() throws IOException
	{
		printPreordine(0, scriitor);
		scriitor.linieNoua();
	}
	/**
     * Functie care inchide scriitorul si completeaza citirea.
     * Nu se scrie nimic in fisier daca nu este inchis.
	 */
	void inchidereScriitor() throws IOException
	{
		scriitor.closeSc();
	}
	
	void delete(Pasager p)
	{
		boolean skip = true;
		if(p instanceof CelulaHeap)
		{
			int k =  vector.indexOf(p);
			Collections.swap(vector, vector.indexOf(p), vector.size() - 1);
			vector.remove(p);
			Heapify(k);
			skip = false;
		}
		if(skip)
		{
			int celula = 0;
			for (int i = 0; i < vector.size(); i++) 
			{
				if(vector.get(i).id.compareTo(p.id) == 0) //gasim celula
				{
					for (int j = 0; j < vector.get(i).pasageri.size(); j++) 
					{
						if(p.nume.compareTo(vector.get(i).pasageri.get(j).nume) == 0)
						{
							celula = i;
							vector.get(i).pasageri.remove(j);
							vector.get(i).prioritate = 0;
							vector.get(i).calculPrioritate();
							break;
						}
					}
				}
			}
			Heapify(celula);
		}
	}
}
