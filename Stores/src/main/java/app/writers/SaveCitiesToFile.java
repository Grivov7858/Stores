package app.writers;

import app.City;

import java.io.PrintWriter;
import java.util.Map;

public class SaveCitiesToFile implements Runnable {
    private PrintWriter citiesWriter;
    private Map<String, City> cities;

    public SaveCitiesToFile(){

    }

    public SaveCitiesToFile(PrintWriter citiesWriter, Map<String, City> cities) {
        setCitiesWriter(citiesWriter);
        setCities(cities);
    }

    public void setCitiesWriter(PrintWriter citiesWriter) {
        this.citiesWriter = citiesWriter;
    }

    public void setCities(Map<String, City> cities) {
        this.cities = cities;
    }

    @Override
    public void run() {
        for (String keyCityName : cities.keySet()) {
            City existingCity = cities.get(keyCityName);

            citiesWriter.println(existingCity.getCityName());
            citiesWriter.printf("Number of purchases: %d", existingCity.getPurchaseCount());
            citiesWriter.println();
            citiesWriter.printf("Total amount of purchases: %.2f", existingCity.getTotalAmount());
            citiesWriter.println();
            citiesWriter.printf("AVG amount of purchases: %.2f", existingCity.getTotalAmount() / existingCity.getPurchaseCount());
            citiesWriter.println();
            citiesWriter.println();
        }
    }
}
