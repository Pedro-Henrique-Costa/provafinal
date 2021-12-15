package DAO;

import Factory.ConnectionFactory;
import model.Biblioteca;
import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneroDAO {

    private Connection connection;
    public GeneroDAO() {this.connection = new ConnectionFactory().getConnection();}

    public void criaTabelaGenero() {
        String sql = "CREATE TABLE IF NOT EXISTS genero(" +
                "idGenero INT primary key auto_increment," +
                "nome VARCHAR(50) NOT NULL)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Genero cadastrarGenero(Genero generoModel){
        String sql = "INSERT INTO genero(nome) VALUES (?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,generoModel.getNome());

            statement.execute();
            statement.close();

            return generoModel;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
