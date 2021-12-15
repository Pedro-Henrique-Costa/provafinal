package model;

public class Livro {
    String nome;
    Genero genero;
    Biblioteca biblioteca;
    int idLivro;

    public Livro() {
    }

    public Livro(String nome, Genero genero, Biblioteca biblioteca, int idLivro) {
        this.nome = nome;
        this.genero = genero;
        this.biblioteca = biblioteca;
        this.idLivro = idLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero +
                ", biblioteca=" + biblioteca +
                ", idLivro=" + idLivro +
                '}';
    }
}
