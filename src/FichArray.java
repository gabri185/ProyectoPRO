
    import javax.swing.*;
    import java.io.*;
    import java.util.ArrayList;

    public class FichArray {

        public static void vender(String nomeFich,ArrayList<Tienda> listaZapatos) throws IOException{

            ArrayList <Tienda> arrayList2;

            try {//
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
                //Guardando ArrayList en el fichero Zapatillas nuevo tras restar 1 unidad

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

        }

    class Objeto implements Serializable {
        private String _dato;

        public Objeto (String dato) {
            this._dato = dato;
        }

        public String toString() {
            return this._dato;
        }
    }

