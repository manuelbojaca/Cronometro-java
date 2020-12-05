package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Graficos extends JFrame{
	
	boolean estado = true;
	
	public Graficos() {
		setSize(302, 339);
		setTitle("Cronometro");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300, 300));
		initComponent();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void initComponent() {
		
		Minuto min = new Minuto();
		Segundo seg = new Segundo();
		Hora hor = new Hora();
		JPanel panel = new JPanel();
		JLabel display = new JLabel("00:00:00");
		JButton play = new JButton("Play");
		JButton pause = new JButton("Pause");
		JButton reiniciar = new JButton("Reiniciar");
		panel.setLayout(null);
		this.getContentPane().add(panel);
		//panel.setLayout(new GridLayout(3,1));
		/*display.setLayout(null);
		play.setLayout(null);
		reiniciar.setLayout(null);*/
		
		display.setBounds(125, 0, 298, 100);
		play.setBounds(0, 100, 150, 100);
		pause.setBounds(150, 100,150, 100 );
		reiniciar.setBounds(0, 200, 300, 100);
		
		panel.add(display);
		panel.add(play);
		panel.add(pause);
		panel.add(reiniciar);
		
		
		
		
		ActionListener aLPlay = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				estado = true;
				Thread hilo = new Thread() {
					public void run() {
						System.out.println("run");
						hor.contar();
						min.contar();
						seg.contar();
						for(;;) {
							if(estado == true) {
								display.setText(hor.definir() + ":" + min.definir()+ ":" + seg.definir());
							}
							else {
								System.out.println("break");
								break;
							}
						}
					}
				};
				
				if (estado == false) {
					estado = true;
					hilo.start();
				}else {
					hilo.start();
				}
				/*boolean bol = false;
				if (bol) 
					bol = false;
				else 
					bol = true;
				
				hor.contar();
				min.contar();
				seg.contar();
				
				for (int i = 0; i<100; i++) {
					display.setText(hor.definir() + ":" + min.definir()+ ":" + seg.definir());
					try {
						Thread.sleep(30);
					} catch (InterruptedException ex) {
					}
				}*/	
			}
		};
		
		ActionListener aLPause = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				estado = false;
				System.out.println("reiniando" );
				/*hor.pausar();
				min.pausar();
				seg.pausar();*/
			}
			
		};
		
		ActionListener aLReiniciar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				estado = true;
				hor.reiniciar();
				min.reiniciar();
				seg.reiniciar();
				display.setText("00:00:00");
				System.out.println("00:00:00");
			}
			
		};
		play.addActionListener(aLPlay);
		pause.addActionListener(aLPause);
		reiniciar.addActionListener(aLReiniciar);
	}

}	
		



