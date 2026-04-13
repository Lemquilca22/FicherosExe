public class Usuario {
    private String nom;
    private int edad;
    private String correo;

    public Usuario(String nom, int edad, String correo) {
        this.nom = nom;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nom:'" + nom + '\'' +
                ", edad: " + edad +
                ", correo:'" + correo + '\'' +
                '}';
    }
}
