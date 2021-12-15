package model;

public class Biblioteca {
    String nome;
    int idBlioteca;

    public Biblioteca() {

    }

    public Biblioteca(String nome, int idBlioteca) {
        this.nome = nome;
        this.idBlioteca = idBlioteca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdBlioteca() {
        return idBlioteca;
    }

    public void setIdBlioteca(int idBlioteca) {
        this.idBlioteca = idBlioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", idBlioteca=" + idBlioteca +
                '}';
    }
}
