/**
	 * Clasa care inheriteaza Pasager si descrie un membru singur.
	 */
public class Single extends Pasager {
	int prioritate = 0;
	
	public Single(String id, String nume, int varsta, String tipBilet, boolean prioritar, boolean andicap) {
		super(id, nume, varsta, tipBilet, prioritar, andicap);
		calculPrioritate();
	}
	
	int getPrioritate() {
		return prioritate;
	}
	/** 
	   * {@inheritDoc}
	   */
	void calculPrioritate() {
		// varsta
		if (varsta <= 2) // sub 2
		{
			prioritate += 20;
		} else if (varsta <= 5) // sub 5 peste 2
		{
			prioritate += 10;
		} else if (varsta <= 10) // sub 10 peste 5
		{
			prioritate += 5;
		} else if (varsta < 60) // sub 60 peste 10
		{
		} else // peste 60
		{
			prioritate += 15;
		}
		// tip bilet
		if (tipBilet.compareTo("b") == 0) {
			prioritate += 35;
		} else if (tipBilet.compareTo("p") == 0) {
			prioritate += 20;
		}
		// speciale
		if (andikapat) {
			prioritate += 100;
		}
		if (prioritar) {
			prioritate += 30;
		}
	}

	@Override
	String getId() {
		return id;
	}

}
