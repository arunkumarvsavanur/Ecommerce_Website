package ecommerceapp.product;

import java.util.*;

public class ECommerceApp {
    private static Scanner sc = new Scanner(System.in);
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        System.out.println("Welcome to Arun Mega Mart!");

        Map<String, List<String>> categories = new HashMap<>();
        categories.put("Fashion", Arrays.asList("Men", "Women", "Children"));
        categories.put("Electronics", Arrays.asList("Mobile", "Laptop", "Earphones"));
        categories.put("Household", Arrays.asList("Kitchen", "Cleaning", "Decor"));
        categories.put("Furniture", Arrays.asList("Sofa", "Table", "Chair"));

        Map<String, List<Product>> products = prepareProducts();

        boolean shopping = true;
        while (shopping) {
            System.out.println("\nMain Categories:");
            int i = 1;
            List<String> catList = new ArrayList<>(categories.keySet());
            for (String cat : catList) System.out.println(i++ + ". " + cat);
            System.out.print("Choose category (1-" + catList.size() + "): ");
            int catChoice = sc.nextInt();
            String selectedCat = catList.get(catChoice - 1);

            List<String> subcats = categories.get(selectedCat);
            System.out.println("\nSubcategories:");
            i = 1;
            for (String sub : subcats) System.out.println(i++ + ". " + sub);
            System.out.print("Choose subcategory (1-" + subcats.size() + "): ");
            int subChoice = sc.nextInt();
            String selectedSub = selectedCat + "-" + subcats.get(subChoice - 1);

            List<Product> subProducts = products.get(selectedSub);
            System.out.println("\nProducts:");
            i = 1;
            for (Product p : subProducts) System.out.println(i++ + ". " + p);
            System.out.print("Choose product to add to cart (1-" + subProducts.size() + "): ");
            int prodChoice = sc.nextInt();
            Product chosenProduct = subProducts.get(prodChoice - 1);
            cart.addProduct(chosenProduct);

            System.out.print("1. Continue Shopping  2. Checkout → ");
            int nextAction = sc.nextInt();
            if (nextAction == 2) {
                shopping = false;
            }
        }

        if (!cart.isEmpty()) {
            System.out.println("\nEnter Shipping Address:");
            sc.nextLine(); // consume leftover newline
            System.out.print("Area: ");
            String name = sc.nextLine();
            System.out.print("Street: ");
            String street = sc.nextLine();
            System.out.print("City: ");
            String city = sc.nextLine();
            System.out.print("State: ");
            String state = sc.nextLine();
            System.out.print("ZIP Code: ");
            String zip = sc.nextLine();

            ShippingAddress address = new ShippingAddress(name, street, city, state, zip);

            cart.displayBill();
            System.out.println("\nShipping Address:");
            System.out.println(address);
        } else {
            System.out.println("Your cart is empty.");
        }
    }

    private static Map<String, List<Product>> prepareProducts() {
        Map<String, List<Product>> map = new HashMap<>();

        map.put("Fashion-Men", Arrays.asList(
            new Product("Levi's T-shirt", "Levi's", 999, "Cotton, Blue"),
            new Product("Nike Shoes", "Nike", 3999, "Running shoes"),
            new Product("Puma Jacket", "Puma", 2999, "Winter wear"),
            new Product("Wrangler Jeans", "Wrangler", 2499, "Slim fit"),
            new Product("Ray-Ban Sunglasses", "Ray-Ban", 5999, "UV protection")
        ));

        map.put("Electronics-Mobile", Arrays.asList(
            new Product("iPhone 15", "Apple", 79999, "128GB, Black"),
            new Product("Galaxy S24", "Samsung", 69999, "128GB, Silver"),
            new Product("Pixel 8", "Google", 64999, "128GB, Obsidian"),
            new Product("OnePlus 12", "OnePlus", 58999, "256GB, Green"),
            new Product("Moto Edge 40", "Motorola", 29999, "128GB, Blue")
        ));
        map.put("Fashion-Women", Arrays.asList(
            new Product("Dress", "Zara", 1999, "Summer dress"),
            new Product("Handbag", "Michael Kors", 7999, "Leather bag"),
            new Product("Heels", "Aldo", 4999, "Black heels"),
            new Product("Scarf", "H&M", 999, "Silk scarf"),
            new Product("Jacket", "Mango", 2999, "Leather jacket")
        ));

        map.put("Fashion-Children", Arrays.asList(
            new Product("Kids T-shirt", "H&M", 499, "Cartoon print"),
            new Product("School Bag", "Wildcraft", 1499, "Red color"),
            new Product("Sneakers", "Nike", 2999, "White sneakers"),
            new Product("Cap", "Adidas", 699, "Blue cap"),
            new Product("Toy Watch", "Fasttrack", 999, "Digital watch")
        ));

        map.put("Electronics-Laptop", Arrays.asList(
            new Product("MacBook Air", "Apple", 99999, "M3 chip, 13-inch"),
            new Product("Dell XPS", "Dell", 89999, "i7, 16GB RAM"),
            new Product("ThinkPad", "Lenovo", 79999, "i5, 16GB RAM"),
            new Product("Aspire 7", "Acer", 69999, "Ryzen 5, 8GB RAM"),
            new Product("ROG Zephyrus", "ASUS", 129999, "Gaming laptop")
        ));

        map.put("Electronics-Earphones", Arrays.asList(
            new Product("AirPods Pro", "Apple", 24999, "Noise canceling"),
            new Product("Galaxy Buds", "Samsung", 14999, "Wireless earbuds"),
            new Product("OnePlus Buds", "OnePlus", 6999, "Dolby Atmos"),
            new Product("Realme Buds", "Realme", 2999, "Bass Boost"),
            new Product("JBL Earphones", "JBL", 1999, "Wired earphones")
        ));

        return map;
    }
}
