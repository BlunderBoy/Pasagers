General:
	Am construit o clasa numita Pasager care reprezinta toate cea mai simpla
entitate din program. Toate celelalte clase care nu se ocupa de rulare sau i/o 
inheriteaza clasa Pasager. Clasesle numit intuitiv MembruGrup, MembruFamilie sau
Singur sunt pentru a diferentia tipurile diferite de pasageri. Cheia de 
diferentiere se face dupa id. Dupa id se adauga pasagerii in grupul sau familia
din care fac parte si ceululelea astea sunt retinute intr-un vector in main.
	Clasele afisare, citire si rulare sunt clase ajutatoare folosite la citire
si la scriere in fisier si in plus la rulare, clasa rulare continand functia 
main(). 
	Pentru citire folosesc clasa Scanner si pentru afisare folosesc clasa 
FileWriter. Se creeaza de fiecare data un fisier nou numit queue.out indiferent
de ce face programul.
Heap:
	Heap-ul este format din CeluleHeap care contin grupe de pasageri daca sunt
din familie sau grup sau pasageri singuri daca sunt Single.
	Heap-ul l-am cautat pe net si l-am implementat in Java folosind ArrayList 
in loc de vector. Insert si embark sunt functii canonice Heap-ului, extractMax 
si add care folosesc HeapifyUp/Down. List se face cu o afisare simpla in 
preordine in care am pus in loc de referinta la noduri am pus indicele din 
ArrayList.
Bonus:
	Am cautat in vectorul din main referintele pentru CelulaHeap sau pentru 
numele unui pasager si am apelat functia cu acea referinta. In functie folosesc
instanceOf ca sa stie programul ce vreau sa sterg.
