package view;

import controller.BibliotecaController;
import controller.GeneroController;
import controller.LivroController;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import javax.swing.*;
import java.util.List;

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
                        " [4] - Editar Genero \n");

        switch (Integer.parseInt(leitura)){
            case 1 -> this.CadastrarLivro();
            case 2 -> this.Listar();
            case 3 -> this.BuscarPorID();
            case 4 -> this.EditarGenero();
        }
    }

    //CADASTRAR [X]
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
            case 1: this.ChooseBibliotecaView();
            case 2: this.ChooseGeneroView();
        }
    }
    public void BuscarPorID(){
        this.ChooseLivroView();

    }
    public void EditarGenero(){
        List<Livro> livros = this.ReadLivroView();
        String leituraIdLivro = JOptionPane.showInputDialog("Digite o Id do Livro para editar seu genero: ");
        int idGenero = Integer.parseInt(leituraIdLivro);
        for(int i = 0; i< livros.size(); i++){
            if(livros.get(i).getGenero().getIdGenero() == idGenero){
                Livro livro = livros.get(i);
                String leituraNome = JOptionPane.showInputDialog("Digite o Nome do Genero a ser Editado: ");
                Genero genero = new Genero();
                genero.setNome(leituraNome);
                livro.setGenero(genero);

                generoController.editaGenero(genero);
            }
        }
    }

    public List<Livro> ReadLivroView(){

        List<Livro> livros =  livroController.ReadLivros();

        for (Livro livro : livros) {
            System.out.println("|Id Biblioteca: " + livro.getBiblioteca().getIdBiblioteca() + "| Nome Biblioteca : " + livro.getBiblioteca().getNome() + "|Id Genero: " + livro.getGenero().getIdGenero() + "| Nome Genero: " + livro.getGenero().getNome() + "|id Livro: " + livro.getIdLivro() + "| Nome Livro: " + livro.getNome());
        }
        return livros;
    }

    public List<Livro> ReadIdBibliotecaView(){

        List<Livro> livros =  livroController.ReadLivros();

        for (Livro livro : livros) {
            System.out.println("|Id Biblioteca: " + livro.getBiblioteca().getIdBiblioteca() + "| Nome Biblioteca : " );
        }
        return livros;
    }

    public List<Livro> ReadidGeneroView(){

        List<Livro> livros =  livroController.ReadLivros();

        for (Livro livro : livros) {
            System.out.println("|Id Genero: " + livro.getGenero().getIdGenero() + "| Nome Genero: " + livro.getGenero().getNome());
        }
        return livros;
    }

    public List<Livro> ReadidLivroView(){

        List<Livro> livros =  livroController.ReadLivros();

        for (Livro livro : livros) {
            System.out.println("|id Livro: " + livro.getIdLivro() + "| Nome Livro: " + livro.getNome());
        }
        return livros;
    }

    public void ChooseBibliotecaView(){
        int idBiblioteca;
        List<Livro> livros = this.ReadLivroView();

        String leituraId = JOptionPane.showInputDialog("  Informe ID do Biblioteca escolhida: ");
        idBiblioteca = Integer.parseInt(leituraId);

        for (int i = 0; i< livros.size(); i++) {
            if (livros.get(i).getBiblioteca().getIdBiblioteca() == idBiblioteca) {
                System.out.println(" |NOME: " + livros.get(i).getNome() + " |ID LIVRO: " + livros.get(i).getIdLivro() + " |GENERO: " + livros.get(i).getGenero() + " |BIBLIOTECA: " + livros.get(i).getBiblioteca()); ;
            }
        }
    }

    public void ChooseGeneroView(){
        int idGenero;
        List<Livro> livros = this.ReadLivroView();

        String leituraId = JOptionPane.showInputDialog("  Informe ID do Genero escolhido: ");
        idGenero = Integer.parseInt(leituraId);

        for (int i = 0; i< livros.size(); i++) {
            if (livros.get(i).getGenero().getIdGenero() == idGenero) {
                System.out.println("| NOME: " + livros.get(i).getNome() + "| ID LIVRO: " +livros.get(i).getIdLivro() + "| GENERO: " +livros.get(i).getGenero() + "| BIBLIOTECA: " +livros.get(i).getBiblioteca());
            }
        }
    }

    public void ChooseLivroView(){
        int idLivro;
        List<Livro> livros = ReadLivroView();

        String leituraId = JOptionPane.showInputDialog("  Informe ID do Livro escolhido: ");
        idLivro = Integer.parseInt(leituraId);

        for (int i = 0; i< livros.size(); i++) {
            if (livros.get(i).getGenero().getIdGenero() == idLivro) {
                System.out.println("| NOME: " + livros.get(i).getNome() + "| ID LIVRO: " +livros.get(i).getIdLivro() + "| GENERO: " +livros.get(i).getGenero() + "| BIBLIOTECA: " +livros.get(i).getBiblioteca());
            }
        }
    }
}
