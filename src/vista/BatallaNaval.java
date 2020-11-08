package vista;
import java.util.Scanner;
import Logica.Modelo;
public class BatallaNaval{
  
  private char posiciciones[][];
  private Scanner entrada ;
  private Modelo modelo;
  private int cantidadbarcos;
  private Ventana ventana;
  private boolean atacado;
  public BatallaNaval(){
    modelo = new Modelo();
    ventana = new Ventana(this);
    //IngresarDatos();
  }
  

  public void IngresarDatos(){
    entrada = new Scanner(System.in);
    int posx,posy;
    String orientacion; 
    for(int i=0;i<4;){
      int aux=i+1;
      System.out.println("ingrese la cordenada X cordenada y Y, direccion del barco de longitud "+aux);
      posx=entrada.nextInt();
      posy=entrada.nextInt();
      orientacion= entrada.next();
      if(posx>=0&&posy>=0&&posx<=10-aux && posy <=10-aux){
        if(modelo.getJugador().ubicarBarcos(posx,posy,aux, orientacion.equals("vertical")))i++;
      }else{
        System.out.println("Ingrese nuevamente las coordenadas, se sale del tablero");
      }
    }   
    JugarAtaque();   
  }
  
  public boolean JugarAtaque(int x, int y){
    if(modelo.getJugador().getContadorBarcosJugador()>=0 && modelo.getMaquina().getContadorBarcosMaquina()>=0){ 
      this.setAtacado(modelo.MaquinaAtacado(x, y)); 
      return true; 
    }else{
      this.setAtacado(false);
      System.out.println("DESTRUISTE LA FLOTA ENEMIGA");
      return false;
    }
    
  }

  public boolean isAtacado() {
    return atacado;
  }

  public void setAtacado(boolean atacado) {
    this.atacado = atacado;
  }
   
   



}