package vicktorms.br.infnet.controller;
import vicktorms.br.infnet.model.Book;

import java.util.ArrayList;
import java.util.List;
public class LibraryController {
    private List<Book> bookList;
    public LibraryController(){
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public boolean removeBook(String title){
        Book selectedBook = findBookByTitle(title);
        if (selectedBook != null){
            bookList.remove(selectedBook);
            return true;
        }
        return false;
    }
    public List<Book> listBooks() {
        return bookList;
    }
    private Book findBookByTitle(String title) {
        for (Book book : bookList){
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

}
