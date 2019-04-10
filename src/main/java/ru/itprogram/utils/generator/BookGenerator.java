package ru.itprogram.utils.generator;

import ru.itprogram.entity.Author;
import ru.itprogram.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookGenerator extends Generator{
    public static Book getBook() {
        Author author = new Author(getRandomString(7), getRandomString(5), getRandomString(8));
        Book book = new Book(author, Integer.toString(getRandomInt()), getRandomString(12),
                getRandomString(10));
        return book;
    }

    public static List<Book> getListBook(int numberOfBook) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < numberOfBook; i++) {
            books.add(getBook());
        }
        return books;
    }
}
