package main;

import java.util.Timer;
import java.util.TimerTask;


public class Manecilla {
	private int unidad;
	Timer timer = new Timer();

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	
	public void contar() {
	
		//Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			public void run() {
				unidad++;
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public void pausar() {
		timer.cancel();
	}
	
	public void reiniciar() {
		
		unidad = 0;
	}
}
