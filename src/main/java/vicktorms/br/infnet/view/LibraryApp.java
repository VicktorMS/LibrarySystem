package vicktorms.br.infnet.view;
import org.slf4j.Marker;
import vicktorms.br.infnet.controller.LibraryController;
import vicktorms.br.infnet.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Scanner;

public class LibraryApp {
    private static final LibraryController controller = new LibraryController();
    private static final Logger log = LoggerFactory.getLogger(LibraryApp.class);

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        int option;
        do {
            log.info("==== Menu da Biblioteca ====");
            log.info("1. Adicionar Livro");
            log.info("2. Remover Livro");
            log.info("3. Listar Livros");
            log.info("0. Sair");
            log.info("Escolha uma opção: ");

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
                    log.info("Saindo da aplicação. Até mais!");
                    break;
                default:
                    log.info("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    private static void addBook() {
        log.info("Digite o título do Livro: ");
        String title = sc.nextLine();
        log.debug("DEBUG: " + title);

        log.info("Digite o author do Livro: ");
        String author = sc.nextLine();
        log.debug("DEBUG: " + author);

        log.info("Digite as paginas do Livro: ");
        int pages = 0;
        try{
            pages = sc.nextInt();
            sc.nextLine();
        }
        catch(Exception e){
            log.error("ERRO: Número de páginas inválido!");
            System.exit(0);
        }


        Book book = new Book(title, author, pages);
        controller.addBook(book);
        log.info("Livro adicionado com sucesso!");
    }

    private static void removeBook() {
        log.info("Digite o título do Livro que deseja remover: ");
        String titulo = sc.nextLine();

        if (controller.removeBook(titulo)) {
            log.info("Livro removido com sucesso!");
        } else {
            log.info("Livro não encontrado.");
        }
    }

    private static void listBooks() {
        log.info("==== Lista de Livros ====");
        for (Book book : controller.listBooks()) {
            log.info(book.toString());
        }
        log.info("=========================");
    }
}
