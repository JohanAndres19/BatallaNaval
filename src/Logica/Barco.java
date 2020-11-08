package Logica;

public class Barco {

  private int posiciones[][];
  private String tuplas[];
  private int longitud, impactos;

  public Barco(int px, int py, int lon, boolean ver) {
    posiciones = new int[3][lon];
    tuplas= new String[lon];
    longitud = lon;
    impactos = 0;
    if (ver) {
      for (int i = 0; i < lon; i++) {
        posiciones[0][i] = py;
        posiciones[1][i] = px++;
        String variable ="("+posiciones[1][i]+","+posiciones[0][i]+")";
        tuplas[i]=variable;
      }
    }else{
      for (int i = 0; i < lon; i++) {
        posiciones[0][i] = py++;
        posiciones[1][i] = px;
        String variable ="("+posiciones[1][i]+","+posiciones[0][i]+")";
        tuplas[i]=variable;
      }
    }
  }

  public boolean verificarImpacto(int py, int px) {
    for (int i = 0; i < longitud; i++) {
      if (posiciones[1][i] == px && posiciones[0][i] == py && posiciones[2][i] == 0) {
        posiciones[2][i] = 1;
        impactos++;
        return true;
      }
    }
      return false;
  }

  public boolean hundido() {
    return (longitud - impactos) == 0;
  }

  public String toString() {
    String b = "(" + posiciones[0][0] + "," + posiciones[1][0] + ") (" + posiciones[0][longitud - 1] + ","
    + posiciones[1][longitud - 1] + ")";
    return b;
  }

  public int[][] getPosiciones() {
    return posiciones;
  }
    
}