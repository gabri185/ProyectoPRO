import java.io.*;
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


    public static Tienda pedirZapatos(String nomeFich, ArrayList <Tienda> listaZapatos) throws IOException {
        String nombre = JOptionPane.showInputDialog("Engade nombre= ");
        String marca = JOptionPane.showInputDialog("Engade marca= ");
        String color = JOptionPane.showInputDialog("Engade color= ");
        int talla = Integer.parseInt(JOptionPane.showInputDialog("Engade talla= "));
        int precio =  Integer.parseInt(JOptionPane.showInputDialog("Engade precio= "));
        int nUnidades = Integer.parseInt(JOptionPane.showInputDialog("Engade numUnidades= "));

        Tienda ti= new Tienda(nombre,marca,talla,precio,nUnidades,color);
        listaZapatos.add(ti);
        File f = new File(nomeFich+".txt");
        FileWriter fi = new FileWriter(f,true);
        PrintWriter esc =null;
        try {
            esc = new PrintWriter(fi);
            esc.println(nombre+ ", " +marca+ ", " +talla+ ", " +precio+ ", " +color+ ", " +nUnidades);

        } finally{
            esc.close();
        }
        return ti;

    }
    public static void engadirElemento(ArrayList<Tienda> listaZapatos) throws IOException {
        Tienda za= pedirZapatos("Ficheiro", listaZapatos);
        listaZapatos.add(za);
    }



}


