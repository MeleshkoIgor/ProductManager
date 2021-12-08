package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book Java = new Book();
    private Book Java1 = new Book(1, "Java1", 500, "Ivanov");
    private Book Java2 = new Book(2, "Java2", 1000, "Petrov");

    @Test
    public void shouldSaveOneBook() {
        repository.save(Java);

        Product[] expected = new Product[]{Java};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneBookWithParameters() {
        repository.save(Java1);

        Product[] expected = new Product[]{Java1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoBooksWithParameters() {
        repository.save(Java1);
        repository.save(Java2);

        Product[] expected = new Product[]{Java1, Java2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;


        repository.save(Java1);
        repository.save(Java2);

        repository.removeById(idToRemove);

        Product[] expected = new Product[]{Java1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}