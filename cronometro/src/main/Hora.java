package main;

public class Hora extends Manecilla {
	
	private int t;
	private int hora;
	
	public int definir () {
		hora = (getUnidad()/3600)-(t*60);
		if (hora >= 60)
			t++;
		return hora;
	}
}
