
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class proyecto {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList <Tienda>lista = new ArrayList<Tienda>();
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(" *** MENU *** \n1 --> ENGADIR\n2 --> AMOSAR\n3--> BUSCAR\n4--> SAIR");
            switch(opcion){
                case "1":
                    Metodos.engadirElemento(lista);
                    break;
                case "2":
                    Metodos.amosarForEach(lista);
                    break;
                case "3":
                    Metodos.buscarPorNombre(lista);
                    break;
                case "4":
                    Metodos.guardar("Zapatillas", lista);
                    System.exit(0);
            }
        } while (!opcion.equalsIgnoreCase("4"));
    }

}
