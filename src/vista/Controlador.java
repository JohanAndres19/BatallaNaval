package vista;

import java.awt.Color;
import java.awt.event.*;

public class Controlador implements ActionListener {
  TableroA tablero;

  public Controlador(TableroA ta) {
    tablero = ta;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (tablero.botonesT[i][j].equals(e.getSource())) {
          if (tablero.ventana.naval.JugarAtaque(i, j)) {
            if (tablero.ventana.naval.isAtacado()) {
              tablero.botonesT[i][j].setBackground(Color.GREEN);
              tablero.botonesT[i][j].setEnabled(false);
            } else {
              tablero.botonesT[i][j].setBackground(Color.YELLOW);
              tablero.botonesT[i][j].setEnabled(false);
            }
          } else {
            this.desabilitar();
            break;
          }
        }
      }
    }

  }

  public void desabilitar(){
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
         tablero.botonesT[i][j].setEnabled(false);
      }
    }
  }

}
