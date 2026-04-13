package Crud;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPubli;

    public Libro(String titulo, String autor, int anioPubli) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPubli = anioPubli;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPubli() {
        return anioPubli;
    }

    public void setAnioPubli(int anioPubli) {
        this.anioPubli = anioPubli;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPubli=" + anioPubli +
                '}';
    }
}
