package controller;

import DAO.LivroDAO;
import model.Livro;

import java.util.List;

public class LivroController {

    LivroDAO livroDAO = new LivroDAO();

    public void CreateProduto(Livro livro) {livroDAO.cadastrarLivro(livro);}
    public List<Livro> ReadLivros() {return this.livroDAO.listarProdutos();}
    public void buscaLivroPorID(int idLivro){
        livroDAO.buscaLivroPorId(idLivro);}

}
