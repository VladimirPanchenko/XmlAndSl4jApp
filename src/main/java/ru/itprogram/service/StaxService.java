package ru.itprogram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxService {
    private static Logger logger;
    private static XMLStreamReader xmlStreamReader;

    public static void parse(String pathFile) {
        logger = LoggerFactory.getLogger(DomService.class);
        try {
            xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(pathFile, new FileInputStream(pathFile));
            while (xmlStreamReader.hasNext()) {
                xmlStreamReader.next();
                if (xmlStreamReader.isStartElement()) {
                    String openingElement = xmlStreamReader.getLocalName();
                    System.out.println(openingElement);
                    logger.info(openingElement);
                } else if (xmlStreamReader.isEndElement()) {
                    String closingElement = "/" + xmlStreamReader.getLocalName();
                    System.out.println(closingElement);
                    logger.info(closingElement);
                } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 0) {
                    String value = "   " + xmlStreamReader.getText();
                    System.out.println(value);
                    logger.info(value);
                }
            }
        } catch (XMLStreamException | FileNotFoundException ex) {
            logger.error(ex.getMessage());
        }
    }
}
