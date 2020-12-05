package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener {
  private JTextField texto;
  private JLabel etiqueta;
  private JButton boton;
  private JButton boton2;
  private JPanel panel;

  public GUI() {
    texto = new JTextField();
    etiqueta = new JLabel(" ");
    boton = new JButton("OK");
    boton2 = new JButton("Cancel");
    panel=new JPanel();
    panel.add(boton);
    panel.add(boton2);
    panel.setLayout(new GridLayout(1,2));
    this.getContentPane().setLayout(new GridLayout(3, 1));
    this.getContentPane().add(texto);
    this.getContentPane().add(etiqueta);
    this.getContentPane().add(panel);
    boton.setActionCommand("ok");
    boton.addActionListener(this);
    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
public void actionPerformed(ActionEvent e){
  if(e.getActionCommand().equals("ok")){
    etiqueta.setText(texto.getText());
    texto.setText("");
  }
}
}