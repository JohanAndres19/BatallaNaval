package Logica;
import java.util.ArrayList;
public class Jugador {

  private Tablero ta, td;
  private ArrayList<Barco> barcos = new ArrayList<Barco>();
  private Modelo modelo;
  private int ContadorBarcosJugador=1; 
    
  public Jugador(Modelo m) {
    ta = new Tablero();
    td = new Tablero(); 
    this.modelo=m;    
  }

  public boolean ubicarBarcos(int px,int py ,int lon, boolean opcion){
    int contador=0;
    if(getBarcos().size()==0){
      getBarcos().add(new Barco(px,py,lon,opcion));
      return true;
    }else{
      Barco varco= new Barco(px,py,lon,opcion);
      for(int i=0;i<getBarcos().size();i++){
        if(getBarcos().get(i).getPosiciones().equals(varco.getPosiciones())==false){                 
          //System.out.println(" si entra porque son diferentes ");
          contador++;
        } 
      }
      if(contador==getBarcos().size()){
        //System.out.println("valor del contador "+contador);
        getBarcos().add(varco);
        return true;
      }else{
        return false;
      }
    }
  }
    
    
  public void Jugar(int x , int y){
    getModelo().MaquinaAtacado(x, y);
    ta.mostrarTablero();
  }
    
  public boolean VerificarImpacto(int px , int py){
    int contador=0;
    for(Barco b: barcos){
      if(b.verificarImpacto(py, px)){
        hundidoJugador();
        break;
      }else{
        contador++;
      }
    }
    if(contador==barcos.size()){
      return false;
    }else{
      return true;
    }
  }

  public void hundidoJugador(){
    int contador=0;
    for(Barco b: barcos){
      if(b.hundido()){
        contador++;
      }else{
        break;
      }
    } 
    if(contador==4){
      setContadorBarcosJugador(-1);
    }else{
      setContadorBarcosJugador(contador);
    }
  }


  public ArrayList<Barco> getBarcos() {
    return barcos;
  }

  public Tablero getTa() {
    return ta;
  }

  public Tablero getTd() {
    return td;
  }
    
  public Modelo getModelo() {
    return modelo;
  }

  public int getContadorBarcosJugador() {
    return ContadorBarcosJugador;
  }

  public void setContadorBarcosJugador(int contadorBarcosJugador) {
    ContadorBarcosJugador = contadorBarcosJugador;
  }
}