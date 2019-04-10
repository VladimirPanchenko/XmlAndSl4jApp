package ru.itprogram.utils;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XsdValidation {
    public static boolean validateXml(String pathToXml, String pathToXsd) {
        boolean validate = true;
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(new StreamSource(new File(pathToXsd)))
                    .newValidator()
                    .validate(new StreamSource(new File(pathToXml)));
        } catch (Exception ex) {
            ex.printStackTrace();
            validate = false;
        }
        return validate;
    }
}
