package DAO;

import Factory.ConnectionFactory;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void cadastrarGenero(Genero generoModel){
        String sql = "INSERT INTO genero(nome) VALUES (?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,generoModel.getNome());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()){
                generoModel.setIdGenero(resultSet.getInt(1));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Genero buscaGeneroPorId(int idGenero) {
        String sql = "SELECT * FROM genero WHERE idGenero = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idGenero);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNome(resultSet.getString("nome"));

                return genero;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editaGenero(Genero generoModel){
        String sql = "UPDATE genero SET nome = ? WHERE idGenero = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,generoModel.getNome());
            statement.setInt(2,generoModel.getIdGenero());

            statement.execute();
            statement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Genero> listarGeneros(){
        String sql = "SELECT * FROM genero";
        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            ArrayList generos = new ArrayList();

            while(resultSet.next()){
                Genero genero = new Genero();
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                GeneroDAO generoDAO = new GeneroDAO();

                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNome(resultSet.getString("nome"));

                generos.add(genero);
            }
            return generos;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
