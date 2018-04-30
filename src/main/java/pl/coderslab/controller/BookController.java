package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    BookService mbs = new MemoryBookService();



    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    @RequestMapping("/viewAllBooks")
    public List<Book> viewAllBooks() {

        List <Book> books = mbs.getList();
        return books;
    }

    @GetMapping
    @RequestMapping("/viewBook/{id}")
    public Book viewBookId(@PathVariable ("id") Long id) {
        Book book = mbs.getBook(id);
        return book;
    }

    // should use '@RequestBody Book book' but it isnt working, or I can't find the way to do so 
    @PostMapping
    @RequestMapping("/addBook/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
    public String addBook(@PathVariable ("id") Long id, @PathVariable ("isbn") String isbn,
                        @PathVariable ("title") String title, @PathVariable ("author") String author,
                        @PathVariable ("publisher") String publisher, @PathVariable ("type") String type)
    {
        Book book = new Book(id, isbn, title, author, publisher, type);
        mbs.addBook(book);
        return "Book added: \n" + book.toString();
    }

    @DeleteMapping
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable ("id") Long id) {
        Book book = mbs.getBook(id);
        mbs.deleteBook(book);
        return "Book deleted: " + book;
    }


    @PutMapping
    @RequestMapping("/editBook/{oldId}/{id}/{isbn}/{title}/{author}/{publisher}/{type}")
    public Book editBook(@PathVariable ("oldId") Long oldId,@PathVariable ("id") Long id, @PathVariable ("isbn") String isbn,
                         @PathVariable ("title") String title, @PathVariable ("author") String author,
                         @PathVariable ("publisher") String publisher, @PathVariable ("type") String type) {
        Book book = mbs.getBook(oldId);
        Book oldBook = book;
        book.setId(id);
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setType(type);

        mbs.editBook(oldBook, book);

        return book;
    }

}