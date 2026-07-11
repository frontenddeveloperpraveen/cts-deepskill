import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

public class Main {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Keyboard", "Electronics"),
            new Product("P102", "Monitor", "Electronics"),
            new Product("P103", "Desk Lamp", "Furniture"),
            new Product("P104", "Backpack", "Accessories"),
            new Product("P105", "Water Bottle", "Sports")
        };

        System.out.println("--- Linear Search Test ---");
        Product result1 = linearSearch(products, "Monitor");
        System.out.println("Found: " + result1);

        System.out.println("\n--- Binary Search Test (Requires sorted array) ---");
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
        
        System.out.println("Sorted products for binary search:");
        for (Product p : products) {
            System.out.println(p);
        }

        Product result2 = binarySearch(products, "Monitor");
        System.out.println("\nFound: " + result2);
    }
}
