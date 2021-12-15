package DAO;

import Factory.ConnectionFactory;
import model.Biblioteca;
import model.Livro;

import java.sql.*;

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

    public void cadastrarBiblioteca(Biblioteca bibliotecaModel){
        String sql = "INSERT INTO biblioteca(nome) VALUES (?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,bibliotecaModel.getNome());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()){
                bibliotecaModel.setIdBiblioteca(resultSet.getInt(1));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Biblioteca buscaBibliotecaPorId(int idBiblioteca) {
        String sql = "SELECT * FROM biblioteca WHERE idBiblioteca = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idBiblioteca);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNome(resultSet.getString("nome"));

                return biblioteca;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
