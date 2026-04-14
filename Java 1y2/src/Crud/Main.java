package Crud;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void print(){
        System.out.println("¿Que quiere hacer hoy?"+ " Selecciona una opcion");
        System.out.println("1) Añadir Libro"+
                "\n"+"2) Mostrar Libros"+
                "\n"+"3) Actualizar Libro"+
                "\n"+"4) Eliminar Libro");
        System.out.print("Rpta: ");
    }

    //Metodo guardarEnArchivo y cargarDesde... lo busqué en gemini :) que siguen lógica de borrar y
    // actualizar cada vez que realizo un pedido por terminal...
    public static void guardarEnArchivo(ArrayList<Libro> lista) {
        try (java.io.FileWriter fw = new java.io.FileWriter("libros.txt", false)) { // 'false' borra lo viejo y escribe lo nuevo
            for (Libro l : lista) {
                fw.write(l.getTitulo() + "," + l.getAutor() + "," + l.getAnioPubli() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    public static void cargarDesdeArchivo(ArrayList<Libro> lista) {
        File archivo = new File("libros.txt");
        if (!archivo.exists()) return;

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(","); // Dividimos por la coma
                if (partes.length == 3) {
                    // Creamos el objeto y lo metemos al array
                    lista.add(new Libro(partes[0], partes[1], Integer.parseInt(partes[2])));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }

    public static void añadirLibro(Scanner sc, ArrayList<Libro> l1){
        System.out.println("Titulo: "); String nombre=sc.nextLine();
        System.out.println("Autor: "); String autor=sc.nextLine();
        System.out.println("Año de publicacion: "); int aniopub=sc.nextInt();
        sc.nextLine();
        try {
            l1.add(new Libro(nombre, autor, aniopub));
            System.out.println("Libro añadido correctamente");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void actualizarLibro(Scanner sc, ArrayList<Libro> l2){
        System.out.println("Libro que quieres modificar: ");
        String buscarnom=sc.nextLine();

        boolean encontrado= false;
        for (Libro  c: l2){
            if (c.getTitulo().equalsIgnoreCase(buscarnom)){
                System.out.println("Lo encontré\n");
                System.out.println("Titulo: ");
                String nuevoNombre=sc.nextLine();
                System.out.println("Autor: ");
                String nuevoautor=sc.nextLine();
                System.out.println("Año de publicación:");
                int nuevoAnio=sc.nextInt();
                sc.nextLine();
                //Utilizo este set para modificar los datos.
                c.setTitulo(nuevoNombre);
                c.setAutor(nuevoautor);
                c.setAnioPubli(nuevoAnio);
                System.out.println("Se modificó correctamente");
                encontrado=true;
                break;
            }

        }
        if (!encontrado){
            System.out.println("No encontré ese contacto");
        }
    }
    public static void mostrarLibros(ArrayList<Libro> l3){
        if (!l3.isEmpty()){
            for(Libro a: l3){
                System.out.println(a.toString());
            }
        } else {
            System.out.println("Aun no hay libros en la biblioteca");
        }

    }
    public static void eliminarLibro(Scanner sc, ArrayList<Libro> l4){
        System.out.println("Libro que quieres modificar: ");
        String libroEliminar=sc.nextLine();

        boolean encontrado= false;
        for (int i = 0; i < l4.size(); i++) {
            if (l4.get(i).getTitulo().equalsIgnoreCase(libroEliminar)) {
                l4.remove(i); // Busque que con remove puedo borrar todo un objeto en la posicion del array
                encontrado = true;
                System.out.println("Libro eliminado con éxito.");
                break;
            }
        }
        if (!encontrado){
            System.out.println("No encontré ese Libro");
        }
    }
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();

        cargarDesdeArchivo(libros);

        boolean start = true;
        while (start) {
            print();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirLibro(sc, libros);
                    guardarEnArchivo(libros);
                    break;
                case 2:
                    mostrarLibros(libros);
                    break;
                case 3:
                    actualizarLibro(sc, libros);
                    guardarEnArchivo(libros);
                    break;
                case 4:
                    eliminarLibro(sc, libros);
                    guardarEnArchivo(libros);
                    break;
            }
        }

    }
}
