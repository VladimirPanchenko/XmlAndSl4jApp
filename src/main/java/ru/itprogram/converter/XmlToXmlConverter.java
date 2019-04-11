package ru.itprogram.converter;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlToXmlConverter {
    public static final String COMMON_TAG = "COMMON";
    public static final String BOTANICAL_TAG = "BOTANICAL";
    public static final String ZONE_TAG = "ZONE";
    public static final String LIGHT_TAG = "LIGHT";
    public static final String PRICE_TAG = "PRICE";
    public static final String AVAILABILITY_TAG = "AVAILABILITY";

    public void deleteElement(String pathXml, String pathNewXml, String deleteElement) {
        Document document = null;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(pathXml);
            Node root = document.getDocumentElement();
            NodeList plants = root.getChildNodes();
            for (int i = 0; i < plants.getLength(); i++) {
                Node plantElement = plants.item(i);
                if (plantElement.getNodeType() != Node.TEXT_NODE) {
                    NodeList plantProps = plantElement.getChildNodes();
                    for(int j = 0; j < plantProps.getLength(); j++) {
                        Node plantProp = plantProps.item(j);
                        if (plantProp.getNodeType() != Node.TEXT_NODE) {
                            if (deleteElement.equals(plantProp.getNodeName())) {
                                plantProp.getParentNode().removeChild(plantProp);
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            ex.getMessage();
        } catch (SAXException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
        saveDocumentToXml(document, pathNewXml);
    }

    private void saveDocumentToXml(Document document, String path) {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
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
