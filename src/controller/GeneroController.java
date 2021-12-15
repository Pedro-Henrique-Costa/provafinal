package controller;

import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import model.Biblioteca;
import model.Genero;

public class GeneroController {
    GeneroDAO generoDAO = new GeneroDAO();

    public void CreateGenero(Genero generoModel) {
        generoDAO.cadastrarGenero(generoModel);
    }
}
