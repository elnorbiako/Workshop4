package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {return list;}


    public void setList(List<Book> list) {this.list = list;}


    public Book getBook(long id) {
        List<Book> books = new ArrayList<>();
        MemoryBookService mbs = new MemoryBookService();
        books = mbs.getList();
        Book loadedBook = new Book();

        for (Book book: books)
        {
            Long bookId = book.getId();
            if (bookId == id) {
                loadedBook = book;
            }
        }
        return loadedBook;
    }

    public void addBook(Book book) {
        list.add(book);
    }

    public void deleteBook(Book book) {

        list.remove(book);
    }

    public void editBook(long id, Book editedBook) {
        list.remove(id);
        list.add(editedBook);
    }
}