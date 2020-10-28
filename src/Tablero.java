public class Tablero {
    private int matriz[][] = new int[10][10];

    public void atacarPosicion(int x, int y, boolean impacto) {
        if (impacto) // impacto = 1
            matriz[y][x] = 1;
        else // no impacto = -1
            matriz[y][x] = -1;
    }

    public void mostrarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] == 0 ? "▓" : matriz[i][j] == 1 ? "*" : ".");
            }
            System.out.println();
        }
    }
}
