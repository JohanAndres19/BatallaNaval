import java.util.ArrayList;
import java.util.Scanner;
public class Jugador {
    private Tablero ta, td;
    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private Modelo modelo;
    private Scanner entrada= new Scanner(System.in);
    public Jugador() {
        ta = new Tablero();
        td = new Tablero();     
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
                    System.out.println(" si entra porque son diferentes ");
                    contador++;
                } 
            }
            if(contador==getBarcos().size()){
                System.out.println("valor del contador "+contador);
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

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
}
