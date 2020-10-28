
public class Modelo {
    private Maquina maquina;
    private Jugador jugador;

    public void JugadorAtacado(int x, int y) {
        boolean ataque = jugador.VerificarImpacto(x, y);
        if (ataque) {
            maquina.getTa().atacarPosicion(x, y, ataque);
            jugador.getTd().atacarPosicion(x, y, ataque);
        } else {
            maquina.getTa().atacarPosicion(x, y, ataque);
            jugador.getTd().atacarPosicion(x, y, ataque);
        }
    }

    public void MaquinaAtacado(int x, int y) {
        boolean ataque = maquina.VerificarImpacto(x, y);
        if (ataque) {
            jugador.getTa().atacarPosicion(x, y, ataque);
            maquina.getTd().atacarPosicion(x, y, ataque);
        } else {
            jugador.getTa().atacarPosicion(x, y, ataque);
            maquina.getTd().atacarPosicion(x, y, ataque);
        }
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    

}
