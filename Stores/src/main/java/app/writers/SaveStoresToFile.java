package app.writers;

import app.City;

import java.io.PrintWriter;
import java.util.Map;

public class SaveStoresToFile implements Runnable {
    private PrintWriter storesWriter;
    private Map<String, City> stores;

    public SaveStoresToFile(){

    }

    public SaveStoresToFile(PrintWriter storesWriter, Map<String, City> stores) {
        setStoresWriter(storesWriter);
        setStores(stores);
    }

    public void setStoresWriter(PrintWriter storesWriter) {
        this.storesWriter = storesWriter;
    }

    public void setStores(Map<String, City> stores) {
        this.stores = stores;
    }
    @Override
    public void run() {
        for (String keyCityName : stores.keySet()) {
            City existingStore = stores.get(keyCityName);

            storesWriter.printf("%s, %s",
                    existingStore.getStoreName(),
                    existingStore.getCityName());
            storesWriter.println();
            storesWriter.printf("Number of purchases: %d",
                    existingStore.getPurchaseCount());
            storesWriter.println();
            storesWriter.printf("Total amount of purchases: %.2f",
                    existingStore.getTotalAmount());
            storesWriter.println();
            storesWriter.printf("AVG amount of purchases: %.2f",
                    existingStore.getTotalAmount() / existingStore.getPurchaseCount());
            storesWriter.println();
            storesWriter.println();
        }
    }
}
