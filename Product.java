package ecommerceapp.product;
public class Product {
    private String name;
    private String manufacturer;
    private double price;
    private String description;

    public Product(String name, String manufacturer, double price, String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    public String getName() { return name; }
    public String getManufacturer() { return manufacturer; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + " (" + manufacturer + ") - ₹" + price + "\n" + description;
    }
}
