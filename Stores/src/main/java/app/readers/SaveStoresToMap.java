package app.readers;

import app.City;

import java.util.Map;

public class SaveStoresToMap implements Runnable {
    private Map<String, City> stores;
    private String line;

    public SaveStoresToMap() {
    }

    public SaveStoresToMap(Map<String, City> stores, String line) {
        setStores(stores);
        setLine(line);
    }

    public void setStores(Map<String, City> stores) {
        this.stores = stores;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public void run() {
        String[] storeInfo = line.split(",");

        if (!(stores.containsKey(storeInfo[1]))) {
            City store = new City(storeInfo[0], storeInfo[1], Double.parseDouble(storeInfo[3]));

            stores.put(storeInfo[1], store);
        } else {
            for (String keyStoreName : stores.keySet()) {

                if (storeInfo[1].equals(keyStoreName)) {
                    City existingStore = stores.get(keyStoreName);

                    existingStore.addToExistingCity(Double.parseDouble(storeInfo[3]));
                }
            }
        }
    }
}
