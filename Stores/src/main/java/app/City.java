package app;

public class City {
    private String cityName;
    private String storeName;
    private int purchaseCount = 0;
    private double totalAmount = 0;

    public City() {

    }

    public City(String cityName, String storeName, double totalAmount) {
        setCityName(cityName);
        setStoreName(storeName);
        setPurchaseCount();
        setTotalAmount(totalAmount);

    }

    public void addToExistingCity(double totalAmount) {
        setPurchaseCount();
        setTotalAmount(totalAmount);
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }

    public void setPurchaseCount() {
        this.purchaseCount++;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount += totalAmount;
    }

}
