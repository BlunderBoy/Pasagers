/**
  * Implementarea unui pseudo-HeapSort pentru o companie aeriana ce ajuta la procesul de imbarcare;
  * @author      Macarie Razvan-Cristian
  * @version     1.0
 */
public class Rulare {
	public static void main(String[] args) throws Exception {
		// Heap coada = new Heap();
		Citire cititor = new Citire("queue.in");
		int numarPasageri = cititor.numarPasageri();

		int nrGrupePasageri = 0;
		boolean nuExistaDejaGrupul = true;
		String[] buffer = new String[6];
		String pasager;
		String comanda;
		CelulaHeap grupePasageri[] = new CelulaHeap[numarPasageri];
		Heap heap = new Heap();
		for (int i = 0; i < numarPasageri; i++) 
		{
			pasager = cititor.linieNoua();
			buffer = pasager.split(" "); // strtok

			// procesare date pasager
			String id = buffer[0];
			String nume = buffer[1];
			int varsta = Integer.parseInt(buffer[2]);
			String tipBilet = buffer[3];
			boolean prioritar = Boolean.parseBoolean(buffer[4]);
			boolean andicap = Boolean.parseBoolean(buffer[5]);

			nuExistaDejaGrupul = true;
			
			for (int j = 0; j < nrGrupePasageri; j++) 
			{
				if (id.compareTo(grupePasageri[j].id) == 0) 
				{
					if (id.contains("s")) {
						grupePasageri[j].adaugareInGrup(new Single(id, nume, varsta, tipBilet, prioritar, andicap));
					}
					if (id.contains("g")) {
						grupePasageri[j].adaugareInGrup(new MembruGrup(id, nume, varsta, tipBilet, prioritar, andicap));
					}
					if (id.contains("f")) {
						grupePasageri[j].adaugareInGrup(new MembruFamilie(id, nume, varsta, tipBilet, prioritar, andicap));
					}
					nuExistaDejaGrupul = false;
				}
			}
			if (nuExistaDejaGrupul) 
			{
				grupePasageri[nrGrupePasageri] = new CelulaHeap(id);
				if (id.contains("s")) {
					grupePasageri[nrGrupePasageri].adaugareInGrup(new Single(id, nume, varsta, tipBilet, prioritar, andicap));
				}
				if (id.contains("g")) {
					grupePasageri[nrGrupePasageri].adaugareInGrup(new MembruGrup(id, nume, varsta, tipBilet, prioritar, andicap));
				}
				if (id.contains("f")) {
					grupePasageri[nrGrupePasageri].adaugareInGrup(new MembruFamilie(id, nume, varsta, tipBilet, prioritar, andicap));
				}
				nrGrupePasageri++;
			}
		}// for citire
		
		//calcul prioritate
		for (int i = 0; i < nrGrupePasageri; i++) 
		{
			grupePasageri[i].calculPrioritate();
		}

		//citire comenzi + parsare
		while ((comanda = cititor.linieNoua()) != null) 
		{
			//System.out.println(comanda);
			//insert
			if (comanda.contains("insert")) 
			{
				String[] bufferComanda = new String[2];
				bufferComanda = comanda.split(" ");
				for (int k = 0; k < nrGrupePasageri; k++)
				{
					if (grupePasageri[k].id.compareTo(bufferComanda[1]) == 0) 
					{
						Pasager p = grupePasageri[k];
						heap.insert(p, p.getPrioritate());
						break;
					}
				}
			}
			
			//embark
			if (comanda.contains("embark")) 
			{
				heap.embark();
			}
			
			//list
				
			if (comanda.contains("list")) 
			{
				//System.out.println("print");
				heap.list();
			}
			
			//delete
			if (comanda.contains("delete")) 
			{
				String[] bufferComanda = new String[3];
				bufferComanda = comanda.split(" ");
				if(bufferComanda.length == 2)
				{
					for (int k = 0; k < nrGrupePasageri; k++)
					{
						if (grupePasageri[k].id.compareTo(bufferComanda[1]) == 0) 
						{
							Pasager p = grupePasageri[k];
							heap.delete(p);
							break;
						}
					}
				}
				else
				{
					for (int k = 0; k < nrGrupePasageri; k++)
					{
						if (grupePasageri[k].id.compareTo(bufferComanda[1]) == 0) 
						{
							for (int i = 0; i < grupePasageri[k].pasageri.size(); i++) 
							{
								if(grupePasageri[k].pasageri.get(i).nume.compareTo(bufferComanda[2]) == 0)
								{
									heap.delete(grupePasageri[k].pasageri.get(i));
								}
							}
						}
					}
				}
			}
		}
		heap.inchidereScriitor();
		cititor.closeScanner();
		
	}// main
}//clasa
