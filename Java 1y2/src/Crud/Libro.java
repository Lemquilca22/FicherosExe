package Crud;

public class Libro {
    private String titulo;
    private String autor;
    private String anioPubli;

    public Libro(String anioPubli, String autor, String titulo) {
        this.anioPubli = anioPubli;
        this.autor = autor;
        this.titulo = titulo;
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

    public String getAnioPubli() {
        return anioPubli;
    }

    public void setAnioPubli(String anioPubli) {
        this.anioPubli = anioPubli;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPubli='" + anioPubli + '\'' +
                '}';
    }
}
