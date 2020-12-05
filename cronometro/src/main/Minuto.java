package main;

public class Minuto extends Manecilla {
	private int t=0;
	private int minuto;

	public int definir () {
		minuto = (getUnidad()/60)-(t*60);
		if (minuto >= 60)
			t++;
		return minuto;
	}

}
