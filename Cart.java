package ecommerceapp.product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void displayBill() {
        double total = 0;
        System.out.println("\n===== Your Bill =====");
        for (Product p : items) {
            System.out.println(p);
            total += p.getPrice();
        }
        System.out.println("---------------------");
        System.out.println("Total: ₹" + total);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
