import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void registrarse(Scanner sc, ArrayList<Usuario> si ){
        System.out.println("REGISTRARSE:");
        System.out.print("NOMBRE: ");
        String nom=sc.nextLine();
        System.out.print("EDAD: ");
        int edad=sc.nextInt();
        sc.nextLine();
        System.out.print("CORREO: ");
        String email=sc.nextLine();
        Usuario u1=new Usuario(nom,edad,email);
        si.add(u1);
    }
    static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        ArrayList<Usuario> users = new ArrayList<>();
        File myObj = new File("primerfichero.txt");
        if (myObj.createNewFile()){
            System.out.println("Archivo creado: "+myObj.getName());
        }else {
            System.out.println("Este archivo ya existe");
        }
        FileWriter myWriter = new FileWriter("primerfichero.txt");


        boolean start=true;
        while (start){
            System.out.println("1) REGISTRARSE \n2) GUARDAR USUARIOS");
            System.out.print("OPCION: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    registrarse(sc,users);
                    break;
                case 2:
                    for (Usuario a: users){
                        try {
                            myWriter.write(a.toString());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    start=false;
                    break;
            }

        }

    }
}
