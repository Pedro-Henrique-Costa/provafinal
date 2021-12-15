package model;

public class Genero {
    String nome;
    int idGenero;

    public Genero() {

    }

    public Genero(String nome, int idGenero) {
        this.nome = nome;
        this.idGenero = idGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "nome='" + nome + '\'' +
                ", idGenero=" + idGenero +
                '}';
    }

}
