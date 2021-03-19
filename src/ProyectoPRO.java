



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProyectoPRO {

        public static void main(String[] args) throws FileNotFoundException, IOException {
            ArrayList <Tienda>lista = new ArrayList<Tienda>();
            File f = new File("Zapatillas.txt");
            String opcion;

            do {
                opcion = JOptionPane.showInputDialog(" *** MENU *** \n1 --> ENGADIR\n2 --> AMOSAR\n3--> BUSCAR\n4--> CATALOGO\n5--> VENDER\n6--> SAIR");
                switch(opcion){
                    case "1":
                        Metodos.engadirElemento(lista);
                        break;
                    case "2":

                        Metodos.amosarForEach(lista);
                        break;
                    case "3":
                        Metodos.BurcarTextoEnArchivo();
                        break;
                    case "4":
                        Metodos.catalogo(f);
                        break;
                    case "5":
                        FichArray.vender("Zapatillas",lista);
                        break;
                    case "6":
                        Metodos.guardar("Zapatillas", lista);
                        System.exit(0);
                }
            } while (!opcion.equalsIgnoreCase("4"));
        }

    }
