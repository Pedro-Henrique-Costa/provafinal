package view;

import controller.BibliotecaController;
import controller.GeneroController;
import controller.LivroController;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import javax.swing.*;

public class Menu {
    //Cadastra Biblioteca                   |-> Cadastra Genero              |-> Cadastra Livro
    // Escolhe Biblioteca ou cadastrar nova |Escolhe Genero ou cadastrar novo|Cadastrar novo livro

    Livro livroModel = new Livro();
    Genero generoModel = new Genero();
    Biblioteca bibliotecaModel = new Biblioteca();
    LivroController livroController = new LivroController();
    BibliotecaController bibliotecaController = new BibliotecaController();
    GeneroController generoController = new GeneroController();

    public void MenuPrincipal(){
        String leitura = JOptionPane.showInputDialog(
                        " [1] - Cadastrar\n" +
                        " [2] - Listar\n"+
                        " [3] - Buscar Livro por ID\n"+
                        " [4] - Editar \n");

        switch (Integer.parseInt(leitura)){
            case 1 -> this.CadastrarLivro();
            case 2 -> this.Listar();
            //case 3 -> this.BuscarPorID;
            case 4 -> this.Editar();
        }
    }

    //CADASTRAR []
    //LISTAR []
    //BUSCAR POR ID []
    //EDITAR []

    public void CadastrarLivro(){

        String leituraBiblioteca = JOptionPane.showInputDialog("Biblioteca do Livro: ");
        bibliotecaModel.setNome(leituraBiblioteca);
        livroModel.setBiblioteca(bibliotecaModel);

        String leituraGenero = JOptionPane.showInputDialog("Genero do Livro: ");
        generoModel.setNome(leituraGenero);
        livroModel.setGenero(generoModel);

        String leituraNome = JOptionPane.showInputDialog("Nome do Livro: ");
        livroModel.setNome(leituraNome);

        bibliotecaController.CreateBiblioteca(bibliotecaModel);
        generoController.CreateGenero(generoModel);
        livroController.CreateProduto(livroModel);

    }


    public void Listar(){
        String leitura = JOptionPane.showInputDialog("[1] - Listar Livros de uma Biblioteca\n[2] - Listar Livros de um Genero ");
        switch (Integer.parseInt(leitura)){
            case 1: String leituraidBiblioteca =JOptionPane.showInputDialog("Qual o Id da biblioteca? ");
            this.BuscarPorID();
            case 2: String leituraidGenero =JOptionPane.showInputDialog("Qual o Id do Genero? ");
                this.BuscarPorID();
        }
    }
    public void BuscarPorID(){

    }
    public void Editar(){

    }
}
