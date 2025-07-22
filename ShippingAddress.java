package ecommerceapp.product;

public class ShippingAddress {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public ShippingAddress(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String toString() {
        return name + "\n" + street + "\n" + city + ", " + state + " - " + zipCode;
    }
}
