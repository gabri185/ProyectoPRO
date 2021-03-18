
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
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


    public static Tienda pedirZapatos(){
        String nombre = JOptionPane.showInputDialog("Engade nombre= ");
        String marca = JOptionPane.showInputDialog("Engade marca= ");
        String color = JOptionPane.showInputDialog("Engade color= ");
        String talla = JOptionPane.showInputDialog("Engade talla + eu= ");
        int precio =  Integer.parseInt(JOptionPane.showInputDialog("Engade precio= "));
        int nUnidades = Integer.parseInt(JOptionPane.showInputDialog("Engade numUnidades= "));

        Tienda ti= new Tienda(nombre,marca,talla,precio,nUnidades,color);
       /*

        File fi;
        fi = new File(nomeFich+".txt");
        PrintWriter esc =null;
        try {
            esc = new PrintWriter(fi);
            esc.println( "Nombre: " + nombre + "Marca: " + marca + "Color: " + color + "Talla: " + talla + "Precio: " + precio + "nUnidades: " + nUnidades);

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
        */
        return ti;

    }
    public static void guardar(String nomeFich,ArrayList<Tienda> listaZapatos) throws IOException{
        File f = new File(nomeFich+".txt");
        FileWriter fi = new FileWriter(f,true);
        PrintWriter esc =null;
        try {
            esc = new PrintWriter(fi);
            for (Tienda al:listaZapatos)
                esc.println(al);
            System.out.println(fi);



        } finally{
            esc.close();
        }
    }

    public static void engadirElemento(ArrayList<Tienda> listaZapatos) throws FileNotFoundException {
        Tienda za=pedirZapatos ();
        listaZapatos.add(za);
    }
    public static void buscarPorNombre(ArrayList<Tienda>listaZapatos){
        boolean atopado =false;
        String nombre = JOptionPane.showInputDialog("libro");
        for(Tienda al :listaZapatos){
            if(nombre.equals(al.getNombre())){
                System.out.println("Este es el zapato =dddd " + al.getNombre() + al.getMarca());
                atopado=true;
            }
        }
        if(atopado==false){
            System.out.println("Zapato no encontrado");

        }
    }
    public static void amosarForEach(ArrayList<Tienda>listaZapatos){
        for (Tienda al:listaZapatos)
            System.out.println(al);
    }
    public static void vender(ArrayList<Tienda>listaZapatos){
        boolean atopado =false;
        String nombre = JOptionPane.showInputDialog("libro");
        for(Tienda al :listaZapatos){
            if(nombre.equals(al.getNombre())){
                al.setnUnidades(al.getnUnidades() -1);

                atopado=true;

            }
        }
        if(atopado == false)
            System.out.println("zapato no emcontrado");

    }

    //Metodo que nos amosa todas as lineas do noso ficheiro
    public static void catalogo(File fich){
        Scanner sc ;
        try {
            sc = new Scanner(fich);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("erro Liña "+ ex.toString());
        }

    }

    public static void BurcarTextoEnArchivo(){



        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);

        //Para seleccionar el archivo
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(j);

        //Introducimos el texto a buscar
        System.out.print("Introduce Marca: ");
        String texto = "marca=" + sc.nextLine();
        System.out.print("Introduce Talla: ");
        String texto2 = "talla=" + sc.nextLine();

        try {
            //guardamos el path del fichero en la variable ruta
            String ruta = j.getSelectedFile().getAbsolutePath();
            //creamos un objeto File asociado al fichero seleccionado
            File f = new File(ruta);
            //creamos un Scanner para leer el fichero
            entrada = new Scanner(f);
            //mostramos el nombre del fichero
            System.out.println("Archivo: " + f.getName());
            //mostramos el texto a buscar
            System.out.println("Marca a buscar: " + texto);
            System.out.println("Talla a buscar: " + texto2);
            while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                linea = entrada.nextLine();  //se lee una línea
                if (linea.contains(texto) && linea.contains(texto2)) {   //si la línea contiene el texto buscado se muestra por pantalla
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                }
                numeroDeLinea++; //se incrementa el contador de líneas
            }
            if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo

                System.out.println(texto + " no se ha encontrado en el archivo");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }
}
