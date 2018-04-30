package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getList();

    public void setList(List<Book> list);

    public Book getBook(long id);

    public List<Book> addBook(Book book);

    public void deleteBook(Book book);

    public void editBook(Book book, Book editedBook);
}
