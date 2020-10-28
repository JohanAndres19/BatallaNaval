import java.util.Scanner;

public class BatallaNaval{
  
  private char posiciciones[][];
  private Scanner entrada ;
  private Jugador jugador;
  private Maquina maquina;
  private Modelo modelo;
  public BatallaNaval(){
    jugador=new Jugador();
    maquina = new Maquina();
    modelo = new Modelo();
    modelo.setJugador(jugador);
    modelo.setMaquina(maquina);
    jugador.setModelo(modelo);
    maquina.setModelo(modelo);
    IngresarDatos();
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
        if(jugador.ubicarBarcos(posx, posy, aux, orientacion.equals("vertical")))i++;
      }else{
        System.out.println("Ingrese bien las coordenadas que se sale del tablero");
      }
    }      
  }
  public void JugarAtaque(){
    
    System.out.println("ingrese las coorddenadas x y y atacar ");
    int x =entrada.nextInt();
    int y= entrada.nextInt();
    jugador.Jugar(x, y);
    //falta hacer un ciclo while que mantenga el juego y permita seguir jugando cuando el ataque es valido 

  }

















}