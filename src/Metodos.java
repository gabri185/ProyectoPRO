import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 * Creado por @autor: gabriel
 * El  23 de mar. de 2021.
 **/
public class Metodos {
    ArrayList <Integer> listaZapatos= new ArrayList < >();


    /**
     * Metodo en el que creamos el array
     * @return
     */
    public static Tienda pedirZapatos() {
        String nombre = JOptionPane.showInputDialog("Engade nombre= ");
        String marca = JOptionPane.showInputDialog("Engade marca= ");
        String color = JOptionPane.showInputDialog("Engade color= ");
        String talla = JOptionPane.showInputDialog("Engade talla + eu= ");
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Engade precio= "));
        int nUnidades = Integer.parseInt(JOptionPane.showInputDialog("Engade numUnidades= "));

        Tienda ti = new Tienda(nombre, marca, talla, precio, nUnidades, color);

        return ti;

    }

    /**
     * Metodo que añade un elemento zapato a nuestro array
     * @param listaZapatos
     * @throws FileNotFoundException
     */
    public static void engadirElemento(ArrayList<Tienda> listaZapatos) throws FileNotFoundException {
        Tienda za=pedirZapatos ();
        listaZapatos.add(za);
    }



    /**
     * Metodo que guarda los zapatos que tengamos en el array en nuestro ficehro
     * @param nomeFich
     * @param listaZapatos
     * @throws IOException
     */
    public static void guardar(String nomeFich,ArrayList<Tienda> listaZapatos) throws IOException {
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

    /**
     * Metodo que cuando vendes un zapato resta 1 al numero de unidades
     * @param nomeFich
     * @param listaZapatos
     * @throws IOException
     */
    //Metodo que cuando vendes un zapato resta 1 al numero de unidades
    public static void vender(String nomeFich,ArrayList<Tienda> listaZapatos) throws IOException{

        ArrayList <Tienda> arrayList2;

        try {
            JFileChooser j = new JFileChooser();
            j.showOpenDialog(j);

            System.out.print("Leyendo ArrayList del fichero objetos.dat.. ");

            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream(String.valueOf(j)) );
            arrayList2 = ( ArrayList <Tienda> )leyendoFichero.readObject();
            leyendoFichero.close();

            System.out.println("ok!");
            System.out.println("Datos leídos del fichero:");

            for(int i = 0; i < arrayList2.size(); i++) {
                System.out.println( "arrayList2[" + i + "] = " + arrayList2.get(i) );
                int unidades = Integer.parseInt(JOptionPane.showInputDialog("Cuantas unidades tenemos?:  "));
                if(i==unidades){
                    int numUnidades=i;
                    numUnidades = numUnidades-1;
                    System.out.println(i);
                }
            }


            /**
             * Guardando ArrayList en el fichero Zapatillas nuevo tras restar 1 unidad
             */
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
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    /**
     * Metodo que nos amosa todas as lineas do noso ficheiro
     * @param fich
     */
    public static void catalogo(File fich){
        Scanner sc ; //declaramos variable tipo scanner
        try {
            sc = new Scanner(fich);
            while(sc.hasNextLine()){ //while que se ejecuta mientras tenga lineas que leer
                System.out.println(sc.nextLine()); //imprime las lineas que va leyendo

            }

        } catch (FileNotFoundException ex) {
            System.out.println("erro Liña "+ ex.toString());
        }

    }
    /**
    *Metodo que busca una zapatilla metieno la marca y la talla
     */
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
        /*
        System.out.print("Introduce Marca: ");
        String texto = "marca=" + sc.nextLine();
        System.out.print("Introduce Talla: ");
        String texto2 = "talla=" + sc.nextLine();
        */
        String texto = "nombre=" + (JOptionPane.showInputDialog("Engade nombre= "));
        String texto2 = "talla=" + (JOptionPane.showInputDialog("Engade talla= "));
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