package view;

import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        GeneroDAO generoDao = new GeneroDAO();
        LivroDAO livroDAO = new LivroDAO();

        bibliotecaDAO.criaTabelaBiblioteca();
        generoDao.criaTabelaGenero();
        livroDAO.criaTabelaLivro();

        menu.MenuPrincipal();
    }


}
