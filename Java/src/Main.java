import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void registrarse(Scanner sc, ArrayList<Usuario> si ){
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

        try {
            File myObj = new File("primerfichero.txt");
            if (myObj.exists()){
                System.out.println("Cargando usuarios previos...");
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


        FileWriter myWriter = new FileWriter("primerfichero.txt",true);

        boolean start=true;
        while (start){
            System.out.println();
            System.out.println("1) AÑADIR USUARIO \n2) GUARDAR y SALIR");
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
                            myWriter.write(a.toString()+"\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    myWriter.close();
                    start=false;
                    break;
            }

        }

    }
}
