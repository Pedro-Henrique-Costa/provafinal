package DAO;

import Factory.ConnectionFactory;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    private Connection connection;
    public LivroDAO() {this.connection = new ConnectionFactory().getConnection();}

    public void criaTabelaLivro() {
        String sql = "CREATE TABLE IF NOT EXISTS livro(" +
                "idLivro INT primary key auto_increment, " +
                "nome VARCHAR(50) NOT NULL, " +
                "idGenero INT, " +
                "idBiblioteca INT, " +
                "CONSTRAINT fk_idBiblioteca FOREIGN KEY (idBiblioteca) REFERENCES biblioteca(idBiblioteca)," +
                "CONSTRAINT fk_idGenero FOREIGN KEY (idGenero) REFERENCES genero(idGenero));";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro cadastrarLivro(Livro livroModel){
        String sql = "INSERT INTO livro(nome, idGenero, idBiblioteca) VALUES (?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,livroModel.getNome());
            statement.setInt(2,livroModel.getGenero().getIdGenero());
            statement.setInt(3,livroModel.getBiblioteca().getIdBlioteca());

            statement.execute();
            statement.close();

            return livroModel;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
