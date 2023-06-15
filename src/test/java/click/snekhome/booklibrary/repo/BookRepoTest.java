package click.snekhome.booklibrary.repo;

import click.snekhome.booklibrary.models.Book;
import click.snekhome.booklibrary.models.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BookRepoTest {
    private BookRepo bookRepo;

    @BeforeEach
    void setup() {
        bookRepo = new BookRepo();
    }

    @Test
    void expectAllBooks() {
        Set<Book> bookSet = new HashSet<>(Set.of(
                new Book(Type.HARD, "04102844", "LOTR", "Tolkien"),
                new Book(Type.SOFT, "39950121", "The little Prince", "Saint-Exupery"),
                new Book(Type.AUDIO, "94010555", "Harry Potter", "Rowland")
        ));
        bookRepo.add(new Book(Type.HARD, "04102844", "LOTR", "Tolkien"));
        bookRepo.add(new Book(Type.SOFT, "39950121", "The little Prince", "Saint-Exupery"));
        bookRepo.add(new Book(Type.AUDIO, "94010555", "Harry Potter", "Rowland"));
        assertThat(bookRepo.getBooks()).containsAll(bookSet);
    }

    @Test
    void expectBookFromBookSet() {
        Book testBook = new Book(Type.HARD, "04102844", "LOTR", "Tolkien");
        bookRepo.add(testBook);
        assertThat(bookRepo.getBooks()).contains(testBook);
    }

    @Test
    void expectDeletedBookNotInRepo() {
        Book testBook = new Book(Type.HARD, "04102844", "LOTR", "Tolkien");
        bookRepo.add(testBook);
        bookRepo.remove(testBook.isbn());
        assertThat(bookRepo.getBooks()).isEmpty();
    }

    @Test
    void expectUpdatedBookInBookSet() {
        Book testBook = new Book(Type.HARD, "04102844", "LOTR", "Tolkien");
        Book updatedBook = new Book(Type.HARD, "04102844", "GOT", "Martin");
        bookRepo.add(testBook);
        bookRepo.edit(testBook.isbn(), updatedBook);
        System.out.println(bookRepo.getBooks());
        assertThat(bookRepo.getBooks()).contains(updatedBook);
    }
}