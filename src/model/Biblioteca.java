package model;

public class Biblioteca {
    String nome;
    int idBiblioteca;

    public Biblioteca() {

    }

    public Biblioteca(String nome, int idBlioteca) {
        this.nome = nome;
        this.idBiblioteca = idBlioteca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBlioteca) {
        this.idBiblioteca = idBlioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", idBlioteca=" + idBiblioteca +
                '}';
    }
}
