package ru.itprogram;

import ru.itprogram.service.DomService;
import ru.itprogram.service.StaxService;

public class App {
    private static final String PATH_FILE = "src/main/resources/plant_catalog.xml";

    public static void main( String[] args ) {
        DomService.parse(PATH_FILE);
        StaxService.parse(PATH_FILE);
    }
}
