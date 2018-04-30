package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {
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
        Book loadedBook = new Book();

        for (Book book: list)
        {
            Long bookId = book.getId();
            if (bookId == id) {
                loadedBook = book;
            }
        }
        return loadedBook;
    }

    public List<Book> addBook(Book book) {
        List<Book> newList = list;
        newList.add(book);
        setList(newList);

        return newList;
    }

    public void deleteBook(Book book) {

        list.remove(book);
    }

    public void editBook(Book book, Book editedBook) {
        list.remove(book);
        list.add(editedBook);
    }
}