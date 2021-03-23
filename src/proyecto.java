
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class proyecto {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList <Tienda>lista = new ArrayList<Tienda>();
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(" *** MENU *** \n1 --> ENGADIR\n2 --> AMOSAR\n3--> SAIR");
            switch(opcion){
                case "1":
                    Metodos.engadirElemento(lista);
                    break;
                case "2":

                    break;
                case "3":
                    System.exit(0);
            }
        } while (!opcion.equalsIgnoreCase("3"));
    }
}
