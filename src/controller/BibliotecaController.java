package controller;

import DAO.BibliotecaDAO;
import model.Biblioteca;
import model.Livro;

public class BibliotecaController {

    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();

    public void CreateBiblioteca(Biblioteca bibliotecaModel) {
        bibliotecaDAO.cadastrarBiblioteca(bibliotecaModel);
    }
}