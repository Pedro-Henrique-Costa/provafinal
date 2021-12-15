package controller;

import DAO.LivroDAO;
import model.Livro;

public class LivroController {

    LivroDAO livroDAO = new LivroDAO();

    public void CreateProduto(Livro livro) {livroDAO.cadastrarLivro(livro);}

}
