package domain;

public class Product {
    private final String productID;
    private String name;
    private int price;

    public Product(String productID, String name, int price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
