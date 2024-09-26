package product;

public class ProductModel {
    private String barCode;
    private String name;
    private int priceInCents;
    private int stock;

    public ProductModel(String newBarCode) {
        barCode = newBarCode;
    }

    public ProductModel(String newBarCode, String newName, int newPrice, int newStock) {
        barCode = newBarCode;
        name = newName;
        priceInCents = newPrice;
        stock = newStock;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (newName == null || newName.isEmpty()) return;
        name = newName;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int newPrice) {
        priceInCents = newPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int newStock) {
        stock = newStock;
    }

    public void addStock(int toAdd) {
        stock += toAdd;
    }

    public void removeStock(int toRemove) {
        if (toRemove > stock) return;
        stock -= toRemove;
    }

}
