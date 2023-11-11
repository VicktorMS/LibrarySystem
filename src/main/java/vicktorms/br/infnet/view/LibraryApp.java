package vicktorms.br.infnet.view;
import vicktorms.br.infnet.controller.LibraryController;
import vicktorms.br.infnet.model.Book;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Scanner;

public class LibraryApp {
    private static LibraryController controller = new LibraryController();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        int option;
        do {
            System.out.println("==== Menu da Biblioteca ====");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Listar Livros");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            option = sc.nextInt();
            sc.nextLine();  // Consumir a quebra de linha

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 0:
                    System.out.println("Saindo da aplicação. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    private static void addBook() {
        System.out.println("Digite o título do Livro: ");
        String title = sc.nextLine();

        System.out.println("Digite o author do Livro: ");
        String author = sc.nextLine();

        System.out.println("Digite o ano de publicação do Livro: ");
        int pages = sc.nextInt();
        sc.nextLine();  // Consumir a quebra de linha

        Book book = new Book(title, author, pages);
        controller.addBook(book);
        System.out.println("Livro adicionado com sucesso!");
    }

    private static void removeBook() {
        System.out.println("Digite o título do Livro que deseja remover: ");
        String titulo = sc.nextLine();

        if (controller.removeBook(titulo)) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void listBooks() {
        System.out.println("==== Lista de Livros ====");
        for (Book book : controller.listBooks()) {
            System.out.println(book.toString());
        }
        System.out.println("=========================");
    }
}
