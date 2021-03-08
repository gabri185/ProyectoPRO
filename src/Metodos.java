import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Metodos {


    ArrayList <Integer> listaZapatos= new ArrayList < >();
    /*
    public static Tienda pedirZapatos(String mensaxe){
        String nombre = JOptionPane.showInputDialog("Engade nombre= ");
        String marca = JOptionPane.showInputDialog("Engade marca= ");
        int talla = Integer.parseInt(JOptionPane.showInputDialog("Engade talla= "));
        int precio =  Integer.parseInt(JOptionPane.showInputDialog("Engade precio= "));
        int nUnidades = Integer.parseInt(JOptionPane.showInputDialog("Engade unidades totales= "));
        String color = JOptionPane.showInputDialog("Engade color= ");

        Tienda ti= new Tienda(nombre,marca,talla,precio,nUnidades,color);
        return ti;
    }
*/


    public static Tienda pedirZapatos(String nomeFich, ArrayList <Tienda> listaZapatos) throws FileNotFoundException{
        String nombre = JOptionPane.showInputDialog("Engade nombre= ");
        String marca = JOptionPane.showInputDialog("Engade marca= ");
        String color = JOptionPane.showInputDialog("Engade color= ");
        int talla = Integer.parseInt(JOptionPane.showInputDialog("Engade talla= "));
        int precio =  Integer.parseInt(JOptionPane.showInputDialog("Engade precio= "));
        int nUnidades = Integer.parseInt(JOptionPane.showInputDialog("Engade numUnidades= "));

        Tienda ti= new Tienda(nombre,marca,talla,precio,nUnidades,color);
        listaZapatos.add(ti);
        File fi;
        fi = new File(nomeFich+".txt");
        PrintWriter esc =null;
        try {
            esc = new PrintWriter(fi);
            esc.println(talla);
            esc.println(marca);
            esc.println(nombre);
            esc.println(precio);
            esc.println(color);
            esc.println(nUnidades);

        }catch (FileNotFoundException ex){
            System.out.println(" erro escribirNumeros "+ ex.toString());
        }
        finally{
            esc.close();
        }
        return ti;

    }
    public static void engadirElemento(ArrayList<Tienda> listaZapatos) throws FileNotFoundException {
        Tienda za=pedirZapatos ("Ficheiro", listaZapatos);
        listaZapatos.add(za);
    }



}

