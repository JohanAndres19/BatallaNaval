package Logica;
public class Modelo {
  private Maquina maquina;
  private Jugador jugador;

  public Modelo(){
    maquina = new Maquina(this);
    jugador = new Jugador(this);
  }

  public void JugadorAtacado(int x, int y) {
    boolean ataque = jugador.VerificarImpacto(x, y);
    if (ataque) {
      maquina.getTa().atacarPosicion(x, y, ataque);
      jugador.getTd().atacarPosicion(x, y, ataque);
    }else{
      maquina.getTa().atacarPosicion(x, y, ataque);
      jugador.getTd().atacarPosicion(x, y, ataque);
    }
  }

  public boolean MaquinaAtacado(int x, int y) {
    boolean ataque = maquina.VerificarImpacto(x, y);
    System.out.println(" si hay ataque ? "+ataque );
    if (ataque) {
      jugador.getTa().atacarPosicion(x, y, ataque);
      maquina.getTd().atacarPosicion(x, y, ataque);
      return true;
    }else{
      jugador.getTa().atacarPosicion(x, y, ataque);
      maquina.getTd().atacarPosicion(x, y, ataque);
      return false;
    }
  }

  public Maquina getMaquina() {
    return maquina;
  }

  public Jugador getJugador() {
    return jugador;
  }
}
