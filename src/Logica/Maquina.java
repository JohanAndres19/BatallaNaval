package Logica;
import java.util.ArrayList;

public class Maquina {

  private Tablero ta, td;
  private ArrayList<Barco> barcos = new ArrayList<Barco>();
  private Modelo modelo;
  private boolean atacado;
  private boolean fallado;
  private int ContadorBarcosMaquina=0;
  private int turno = 0;

  public Maquina(Modelo m) {
    ta = new Tablero();
    td = new Tablero();
    this.modelo= m;
    ArmarTablero();
  }

  public void ArmarTablero() {
    int numero = (int) (Math.random() * 4);
    System.out.println("caso maqina "+numero);
    switch (numero) {
      case 0:
        getBarcos().add(new Barco(0, 0, 1, true));
        getBarcos().add(new Barco(1, 7, 2, false));
        getBarcos().add(new Barco(3, 4, 3, true));
        getBarcos().add(new Barco(6, 7, 4, true));
        break;
      case 1:
        getBarcos().add(new Barco(7, 2, 1, true));
        getBarcos().add(new Barco(2, 0, 2, false));
        getBarcos().add(new Barco(4, 6, 3, false));
        getBarcos().add(new Barco(6, 9, 4, true));
        break;
      case 2:
        getBarcos().add(new Barco(0, 5, 1, true));
        getBarcos().add(new Barco(4, 5, 2, true));
        getBarcos().add(new Barco(5, 3, 3, true));
        getBarcos().add(new Barco(9, 5, 4, false));
        break;
      case 3:
        getBarcos().add(new Barco(6, 8, 1, true));
        getBarcos().add(new Barco(9, 0, 2, false));
        getBarcos().add(new Barco(0, 9, 3, true));
        getBarcos().add(new Barco(1, 1, 4, false));
        break;
      }
    System.out.println("BARCOS ENEMIGOS A LA VISTA");
  }

    
    /*------------------------- esta parte es la logica para la maquina falata completar -----------------------------
     * public String Jugar(){ int fila ,columna; if(turno==0){ fila=
     * (int)(Math.random()*1+8); columna=(int)(Math.random()*2+7); String coordenada
     * = "("+fila+","+columna+")"; getModelo]().Jugador(); turno++; return
     * coordenada; }else{
     * 
     * } }
     * 
     */
    
  public boolean VerificarImpacto(int px, int py) {
    int contador = 0;
    for (Barco b : barcos) {
      if (b.verificarImpacto(py, px)) {
        hundidoMaquina();
        break;
      }else{
        contador++;
      }
    }
    if (contador == barcos.size()) {
      return false;
    }else{
      return true;
    }
  }

  public void hundidoMaquina(){
    int contador=0;
      for(Barco b: barcos){
        if(b.hundido()){
          contador++;
        }else{
          break;
        }
      } 
      if(contador==4){
        setContadorBarcosMaquina(-1);
      }else{
        setContadorBarcosMaquina(contador);
      }
  }

  public ArrayList<Barco> getBarcos() {
    return barcos;
  }

  public Modelo getModelo() {
    return modelo;
  }

  public Tablero getTa() {
    return ta;
  }

  public Tablero getTd() {
    return td;
  }

  public void setContadorBarcosMaquina(int contadorBarcosMaquina) {
    ContadorBarcosMaquina = contadorBarcosMaquina;
  }

  public int getContadorBarcosMaquina() {
    return ContadorBarcosMaquina;
  }
}