package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class TableroG extends JPanel {

    JButton[][] botonesT = new JButton[10][10];
    protected int posx,posy;
    public TableroG() {
        this.setLayout(null);
        this.setBounds(50, 40, 320, 320);
        this.setBackground(Color.CYAN);
        this.Botones();
    }

    public void Botones() {
        int x=10, y=10;
        for(int i=0;i<10;i++){
            for(int j=0; j<10;j++){
                botonesT[i][j]= new JButton();
                botonesT[i][j].setBounds(x, y, 30, 30);
                this.add(botonesT[i][j]);
                x=x+30;
            }
            x=10;
            y=y+30;
        }
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

}
