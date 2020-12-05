package main;

public class Segundo extends Manecilla{
	
	private int t=0;
	private int segundo;

	public int definir () {
		
		segundo = getUnidad()-(t*60);
		if (segundo >= 60)
			t++;
		return segundo;
	}
}
