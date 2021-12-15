package controller;

import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import model.Biblioteca;
import model.Genero;

import java.util.List;

public class GeneroController {
    GeneroDAO generoDAO = new GeneroDAO();

    public void CreateGenero(Genero generoModel) {generoDAO.cadastrarGenero(generoModel);}
    public void editaGenero(Genero generoModel){generoDAO.editaGenero(generoModel);}
    public List<Genero> ReadGenero(){return this.generoDAO.listarGeneros();}

}
