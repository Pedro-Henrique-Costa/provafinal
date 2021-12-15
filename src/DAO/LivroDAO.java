package DAO;

import Factory.ConnectionFactory;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            statement.setInt(3,livroModel.getBiblioteca().getIdBiblioteca());

            statement.execute();
            statement.close();

            return livroModel;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro buscaLivroPorId(int idLivro){
        String sql = "SELECT * FROM livro WHERE idLivro = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idLivro);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Livro livro = new Livro();
                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNome(resultSet.getString("nome"));

                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.buscaGeneroPorId(resultSet.getInt("idGenero"));
                livro.setGenero(genero);

                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                Biblioteca biblioteca = bibliotecaDAO.buscaBibliotecaPorId(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                return livro;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Livro> listarProdutos(){
        String sql = "SELECT * FROM livro";
        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            ArrayList livros = new ArrayList();

            while(resultSet.next()){
                Livro livro = new Livro();
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                GeneroDAO generoDAO = new GeneroDAO();

                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNome(resultSet.getString("nome"));

                Genero genero = generoDAO.buscaGeneroPorId(resultSet.getInt("idGenero"));  //Entender está lógica
                livro.setGenero(genero);

                Biblioteca biblioteca = bibliotecaDAO.buscaBibliotecaPorId(resultSet.getInt("idBiblioteca"));  //Entender está lógica
                livro.setBiblioteca(biblioteca);

                livros.add(livro);
            }
            return livros;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
