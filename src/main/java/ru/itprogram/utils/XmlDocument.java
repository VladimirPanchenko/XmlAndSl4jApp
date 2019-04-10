package ru.itprogram.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.itprogram.entity.Book;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XmlDocument {
    private static final String ROOT_TAG = "books";
    private static final String BOOK_TAG = "book";
    private static final String AUTHOR_TAG = "author";
    private static final String FIRST_NAME_TAG = "firstName";
    private static final String LAST_NAME_TAG = "lastName";
    private static final String SECOND_NAME_TAG = "secondName";
    private static final String NUMBER_OF_PAGES_TAG = "numberOfPages";
    private static final String TITLE_TAG = "title";
    private static final String PUBLISHER_TAG = "publisher";

    public static void createXmlFile(String path, List<Book> books) {
        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        Element root = document.createElement(ROOT_TAG);
        document.appendChild(root);
        for (Book b : books) {
            Element book = document.createElement(BOOK_TAG);
            Element author = document.createElement(AUTHOR_TAG);
            Element firstName = document.createElement(FIRST_NAME_TAG);
            Element lastName = document.createElement(LAST_NAME_TAG);
            Element secondName = document.createElement(SECOND_NAME_TAG);
            Element numberOfPages = document.createElement(NUMBER_OF_PAGES_TAG);
            Element title = document.createElement(TITLE_TAG);
            Element publisher = document.createElement(PUBLISHER_TAG);
            root.appendChild(book);
            book.appendChild(author);
            author.appendChild(firstName);
            firstName.appendChild(document.createTextNode(b.getAuthor().getFirstName()));
            author.appendChild(lastName);
            lastName.appendChild(document.createTextNode(b.getAuthor().getLastName()));
            author.appendChild(secondName);
            secondName.appendChild(document.createTextNode(b.getAuthor().getSecondName()));
            book.appendChild(numberOfPages);
            numberOfPages.appendChild(document.createTextNode(b.getNumberOfPages()));
            book.appendChild(title);
            title.appendChild(document.createTextNode(b.getTitle()));
            book.appendChild(publisher);
            publisher.appendChild(document.createTextNode(b.getPublisher()));
        }
        saveDocumentToXml(document, path);
    }

    private static void saveDocumentToXml(Document document, String path) {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document),
                    new StreamResult(new FileOutputStream(path)));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
