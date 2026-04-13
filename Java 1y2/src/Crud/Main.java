package Crud;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//El sistema deberá permitir:
// Crear nuevos libros (añadir registros).
// Leer y mostrar la lista de libros almacenados.
// Actualizar la información de un libro existente.
// Eliminar libros del sistema.
//public class Main {
//    public static void añad
//    static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        ArrayList<Libro> libros = new ArrayList<>();
//
//        try {
//            File myObj = new File("libros.txt");
//            if (myObj.exists()){
//                System.out.println("Cargando libros almacenados...");
//                Scanner myReader= new Scanner(myObj);
//                while (myReader.hasNextLine()){
//                    String data = myReader.nextLine();
//                    System.out.println("- "+data);
//                }
//                myReader.close();
//            }else {
//                myObj.createNewFile();
//                System.out.println("Archivo nuevo creado");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
