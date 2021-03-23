package Principal;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import Clases.Metodos;
import Clases.Tienda;

/**
 * Creado por @autor: gabriel
 * El  23 de mar. de 2021.
 **/
class Proyecto extends JFrame implements ActionListener {

    ArrayList <Tienda> lista = new ArrayList<Tienda>();
    File f = new File("Zapatillas.txt");


    //Aqui declaramos todos los botones
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    JButton boton6;
    public Proyecto(){
        setLayout(null);
        //Aqui le ponemos un nombre a cada boton y unas cordenadas
        boton1 = new JButton("Catalogo");
        boton1.setBounds(20,20,100,30);
        boton2 = new JButton("Cerrar");
        boton2.setBounds(300,250,100,30);
        boton3 = new JButton("Añadir");
        boton3.setBounds(300,20,100,30);
        boton4 = new JButton("Vender");
        boton4.setBounds(20,250,100,30);
        boton5 = new JButton("Guardar");
        boton5.setBounds(150,250,100,30);
        boton6 = new JButton("Buscar");
        boton6.setBounds(150,20,100,30);
        //Añadimos los botones
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        //y le damos una accion
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        boton6.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //si la accion es igual al boton1 entonces llamamos al metodo
        if(e.getSource() == boton1){
            Metodos.catalogo(f);
        }
        //si la accion es igual al boton2 entonces llamamos al metodo
        if(e.getSource() == boton2){
            System.exit(0);
        }
        //si la accion es igual al boton3 entonces llamamos al metodo
        if(e.getSource() == boton3){
            try {
                Metodos.engadirElemento(lista);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //si la accion es igual al boton4 entonces llamamos al metodo
        if(e.getSource() == boton4){
            try {
                Metodos.vender("Zapatillas", lista);
            } catch (IOException ex) {
                Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //si la accion es igual al boton5 entonces llamamos al metodo
        if(e.getSource() == boton5){
            try {
                Metodos.guardar("Zapatillas", lista);
            } catch (IOException ex) {
                Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //si la accion es igual al boton6 entonces llamamos al metodo
        if(e.getSource() == boton6){
            Metodos.BurcarTextoEnArchivo();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Proyecto pro = new Proyecto();
        pro.setBounds(0,0,450,350);
        pro.setVisible(true);
        pro.setResizable(false);
        pro.setLocationRelativeTo(null);





        ArrayList <Tienda>lista = new ArrayList<Tienda>();
        File f = new File("Zapatillas.txt");

    }

}

