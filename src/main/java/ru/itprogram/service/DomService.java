package ru.itprogram.service;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomService {
    private static Logger logger;
    private static DocumentBuilder documentBuilder;
    private static Document document;
    private static Node root;
    private static NodeList plants;

    public static void parse(String pathFile) {
        logger = LoggerFactory.getLogger(DomService.class);
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(pathFile);
            root = document.getDocumentElement();
            System.out.println("Растения: \n");
            plants = root.getChildNodes();
            for (int i = 0; i < plants.getLength(); i++) {
                Node plant = plants.item(i);
                if (plant.getNodeType() != Node.TEXT_NODE) {
                    NodeList plantProps = plant.getChildNodes();
                    for(int j = 0; j < plantProps.getLength(); j++) {
                        Node plantProp = plantProps.item(j);
                        if (plantProp.getNodeType() != Node.TEXT_NODE) {
                            String plantSting = plantProp.getNodeName() + ":" + plantProp
                                    .getChildNodes().item(0).getTextContent();
                            System.out.println(plantSting);
                            logger.info(plantSting);
                        }
                    }
                    System.out.println("**************");
                }
            }
        } catch (ParserConfigurationException ex) {
            logger.error(ex.getMessage());
        } catch (SAXException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
