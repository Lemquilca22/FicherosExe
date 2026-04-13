package Epstein;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        File myObj2 = new File("lista.txt");
        int contador=0;
        if (myObj2.exists()){
            System.out.println("Base de datos cargada correctamente");
        }else {
            myObj2.createNewFile();
            System.out.println("Creando nueva base de datos...");
        }
        System.out.print("BUSCAR PALABRA: ");
        String palabraBuscada=sc.nextLine();
         try (Scanner lector = new Scanner(myObj2)){
             System.out.println("Analizando archivo");

             while (lector.hasNextLine()){
                 String data = lector.next();
                 if (data.equalsIgnoreCase(palabraBuscada)){
                     contador++;
                 }
             }
             System.out.println(palabraBuscada +" aparece "+contador+" veces en este archivo");
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }
}
