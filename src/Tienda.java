     public class Tienda {

         private String nombre;
         private String marca;
         private String talla;
         private double precio;
         private int nUnidades;
         private String color;

         public Tienda() {
         }

         public Tienda(String nombre, String marca, String talla, double precio, int nUnidades, String color) {
             this.nombre = nombre;
             this.marca = marca;
             this.talla = talla;
             this.precio = precio;
             this.nUnidades = nUnidades;
             this.color = color;
         }


         public String getNombre() {
             return nombre;
         }

         public void setNombre(String nombre) {
             this.nombre = nombre;
         }

         public String getMarca() {
             return marca;
         }

         public void setMarca(String marca) {
             this.marca = marca;
         }

         public String getTalla() {
             return talla;
         }

         public void setTalla(String talla) {
             this.talla = talla;
         }

         public double getPrecio() {
             return precio;
         }

         public void setPrecio(double precio) {
             this.precio = precio;
         }

         public int getnUnidades() {
             return nUnidades;
         }

         public void setnUnidades(int nUnidades) {
             this.nUnidades = nUnidades;
         }

         public String getColor() {
             return color;
         }

         public void setColor(String color) {
             this.color = color;
         }

         @Override
         public String toString() {
             return "nombre=" + nombre +
                     " marca=" + marca +
                     " talla=" + talla +
                     " precio=" + precio +
                     " nUnidades=" + nUnidades +
                     " color=" + color ;
         }

     }
