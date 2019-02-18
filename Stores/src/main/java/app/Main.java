package app;

import app.readers.SaveCitiesToMap;
import app.writers.SaveCitiesToFile;
import app.writers.SaveStoresToFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String resourceFolder = "D:\\Java\\InteliJ\\Stores\\src\\main\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String citiesReportPath = resourceFolder + "cities_report.txt";
        String storesReportPath = resourceFolder + "stores_report.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             PrintWriter citiesWriter = new PrintWriter(new FileOutputStream(citiesReportPath));
             PrintWriter storesWriter = new PrintWriter(new FileOutputStream(storesReportPath))) {

            Map<String, City> cities = new HashMap<>();
            Map<String, City> stores = new HashMap<>();

            SaveCitiesToMap saveCitiesToMap = new SaveCitiesToMap(reader, cities, stores);
            saveCitiesToMap.run();

            SaveCitiesToFile saveCitiesToFile = new SaveCitiesToFile(citiesWriter, cities);
            saveCitiesToFile.run();
            SaveStoresToFile saveStoresToFile = new SaveStoresToFile(storesWriter, stores);
            saveStoresToFile.run();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
