package Crud;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//El sistema deberá permitir:
// Crear nuevos libros (añadir registros).
// Leer y mostrar la lista de libros almacenados.
// Actualizar la información de un libro existente.
// Eliminar libros del sistema.
public class Main {
    public static void añadirLibro(Scanner sc, ArrayList<Libro> l1){
        System.out.println("Nombre: "); String nombre=sc.nextLine();
        System.out.println("Autor: "); String autor=sc.nextLine();
        System.out.println("Año de publicacion: "); int aniopub=sc.nextInt();
        l1.add(new Libro(nombre, autor, aniopub));
    }
    public static void modificarLibro(Scanner sc, ArrayList<Libro> l2){
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
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();

        try {
            File myObj = new File("libros.txt");
            if (myObj.exists()){
                System.out.println("Cargando libros almacenados...");
                Scanner myReader= new Scanner(myObj);
                while (myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    System.out.println("- "+data);
                }
                myReader.close();
            }else {
                myObj.createNewFile();
                System.out.println("Archivo nuevo creado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        boolean start = true;
        while (start) {
            print();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirLibro(sc, libros);
                    break;
                case 2:
                    for (Contacto c : listaContactos) {
                        c.mostrarContacto();
                    }
                    break;
                case 3:
                    modificarLibro(sc, libros);
                    break;
                case 4:
                    buscarcontacto(listaContactos, sc);
                    break;
            }
        }

    }
}
