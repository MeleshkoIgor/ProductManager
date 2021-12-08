package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    private Book first = new Book(1, "Java1", 500, "Kozlov");
    private Book second = new Book(2, "Java2", 1000, "Ivanov");
    private Book third = new Book(3, "Java3", 1000, "Ivanov");
    private Book fourth = new Book(4, "Game", 750, "Petrov");

    private Smartphone fifth = new Smartphone(5, "Iphone 12", 50000, "Apple");
    private Smartphone sixth = new Smartphone(6, "Samsung A50", 30000, "Samsung");
    private Smartphone seventh = new Smartphone(7, "Galaxy S20", 60000, "Samsung");
    private Product eighth = new Product(8, "Honor", 20000);

    @Test
    public void shouldSaveOneBook() {


        manager.add(first);

        Product[] expected = new Product[]{first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {
        String textForSearch = "Java";

        manager.add(second);
        manager.add(fourth);

        Product[] expected = new Product[]{second,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        String textForSearch = "Ivanov";

        manager.add(second);
        manager.add(fourth);

        Product[] expected = new Product[]{second,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {
        String textForSearch = "Iphone 12";

        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Product[] expected = new Product[]{fifth,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        String textForSearch = "Samsung";

        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{sixth, seventh};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorInBooksAndSmartphones() {
        String textForSearch = "Kozlov";

        manager.add(first);
        manager.add(third);
        manager.add(sixth);

        Product[] expected = new Product[]{first,};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturerWhichIsNot() {
        String textForSearch = "Honor";

        manager.add(fourth);
        manager.add(sixth);
        manager.add(eighth);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(textForSearch);
        assertArrayEquals(expected, actual);
    }
}