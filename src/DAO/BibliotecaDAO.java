package DAO;

import Factory.ConnectionFactory;
import model.Biblioteca;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BibliotecaDAO {

    private Connection connection;
    public BibliotecaDAO() {this.connection = new ConnectionFactory().getConnection();}

    Biblioteca bibliotecaModel = new Biblioteca();

    public void criaTabelaBiblioteca() {
        String sql = "CREATE TABLE IF NOT EXISTS biblioteca(" +
                "idBiblioteca INT primary key auto_increment," +
                "nome VARCHAR(50) NOT NULL)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Biblioteca cadastrarBiblioteca(Biblioteca bibliotecaModel){
        String sql = "INSERT INTO biblioteca(nome) VALUES (?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,bibliotecaModel.getNome());

            statement.execute();
            statement.close();

            return bibliotecaModel;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
