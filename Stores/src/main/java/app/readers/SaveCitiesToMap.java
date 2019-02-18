package app.readers;

import app.City;

import java.io.BufferedReader;
import java.util.Map;

public class SaveCitiesToMap implements Runnable {
    private BufferedReader reader;
    private Map<String, City> cities;
    private Map<String, City> stores;

    public SaveCitiesToMap() {
    }

    public SaveCitiesToMap(BufferedReader reader, Map<String, City> cities, Map<String, City> stores) {
        setReader(reader);
        setCities(cities);
        setStores(stores);
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setCities(Map<String, City> cities) {
        this.cities = cities;
    }

    public void setStores(Map<String, City> stores) {
        this.stores = stores;
    }

    @Override
    public void run() {

        reader.lines().forEach(line -> {

            SaveStoresToMap saveStoresToMap = new SaveStoresToMap(stores, line);
            saveStoresToMap.run();

            String[] storeInfo = line.split(",");
            if (!(cities.containsKey(storeInfo[0]))) {
                City city = new City(storeInfo[0], storeInfo[1], Double.parseDouble(storeInfo[3]));

                cities.put(storeInfo[0], city);
            } else {
                for (String keyCityName : cities.keySet()) {

                    if (storeInfo[0].equals(keyCityName)) {
                        City existingCity = cities.get(keyCityName);

                        existingCity.addToExistingCity(Double.parseDouble(storeInfo[3]));
                    }
                }
            }
        });
    }
}
