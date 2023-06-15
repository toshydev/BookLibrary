package click.snekhome.booklibrary.repo;

import click.snekhome.booklibrary.models.Book;
import click.snekhome.booklibrary.models.Type;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class BookRepo {
    private final Set<Book> books;

    public BookRepo() {
        books = new HashSet<>();
    }

    public Set<Book> list() {
        return books;
    }

    public Book get(String isbn) {
        for (Book book : books) {
            if (book.isbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void add(Book book) {
        books.add(book);
    }

    public void remove(String isbn) {
        books.remove(this.get(isbn));
    }

    public void edit(String isbn, Book updatedBook) {
        if (books.removeIf(book -> book.isbn().equals(isbn))) {
            books.add(updatedBook);
        }

    }
}
