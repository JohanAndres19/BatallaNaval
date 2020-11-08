package vista;

import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    TableroG pruebaTablero;
    BatallaNaval naval;
    public Ventana(BatallaNaval bNaval){
      this.setLayout(null);
      this.setBounds(0, 0, 440, 550);
      pruebaTablero= new TableroA(this);
      this.add(pruebaTablero);
      this.setVisible(true);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);      
      this.naval=bNaval;
    }



}
