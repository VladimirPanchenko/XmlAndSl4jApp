package ru.itprogram;

import ru.itprogram.utils.XmlDocument;
import ru.itprogram.utils.XsdValidation;
import ru.itprogram.utils.generator.BookGenerator;

public class App {
    private static final String PATH_PLANT_CATALOG_XML_FILE = "src/main/resources/" +
            "plant_catalog.xml";
    private static final String PATH_BOOKS_XML_FILE = "temp.xml";
    private static final String PATH_XSD_FILE = "src/main/resources/book.xsd";
    private static final int NUMBER_OF_GENERATE_BOOK = 10;

    public static void main( String[] args ) {
//        DomService.parse(PATH_PLANT_CATALOG_XML_FILE);
//        StaxService.parse(PATH_PLANT_CATALOG_XML_FILE);

        XmlDocument.createXmlFile(PATH_BOOKS_XML_FILE,
                BookGenerator.getListBook(NUMBER_OF_GENERATE_BOOK));
        System.out.println("Валидность схемы: " +
                XsdValidation.validateXml(PATH_BOOKS_XML_FILE, PATH_XSD_FILE));


    }
}
