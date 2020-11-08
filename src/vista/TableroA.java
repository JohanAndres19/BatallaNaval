package vista;

public class TableroA extends TableroG {
    
    Ventana ventana;
    
    public TableroA(Ventana v){
        ventana =v;
        acciones();
    }
    
    public void acciones(){
        for(int i=0;i<10;i++){
            for(int j=0; j<10;j++){
                this.botonesT[i][j].addActionListener(new Controlador(this));
            }
        }
    }



    
    
}
