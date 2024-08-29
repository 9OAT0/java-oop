import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabGroup {
    public static void main(String[] args) {
        // สร้าง object จาก class Store
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        // แสดงเมนู
        while (true) {
            System.out.println("Product Store Menu: ");
            System.out.println("1. Add Product to store");
            System.out.println("2. List Products");
            System.out.println("3. Find Product");
            System.out.println("4. Exit");

            // รับค่าตัวเลขจากเมนู
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            if (option == 1) {
                // ถ้าเลือก 1 ให้เรียก function addProductToStore
                addProductToStore(store, scanner);
            } else if (option == 2) {
                // ถ้าเลือก 2 ให้เรียก function listProductsInStore
                listProductsInStore(store);
            } else if (option == 3) {
                // ถ้าเลือก 3 ให้เรียก function findProductInStore
                findProductInStore(store, scanner);
            } else if (option == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // ฟังก์ชัน addProductToStore
    public static void addProductToStore(Store store, Scanner scanner) {
        System.out.println("Enter product type [1 for Smartphone, 2 for Clothing]");
        int productType = scanner.nextInt();
        scanner.nextLine(); // Clear the newline

        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline

        if (productType == 1) {
            System.out.print("Enter OS: ");
            String os = scanner.nextLine();
            // สร้าง Object จาก class Smartphone
            Product smartphone = new Smartphone(productId, name, price, os);
            store.addProduct(smartphone);
        } else if (productType == 2) {
            System.out.print("Enter Size: ");
            String size = scanner.nextLine();
            // สร้าง Object จาก class Clothing
            Product clothing = new Clothing(productId, name, price, size);
            store.addProduct(clothing);
        }
    }

    // ฟังก์ชัน listProductsInStore
    public static void listProductsInStore(Store store) {
        store.listProduct();
    }

    // ฟังก์ชัน findProductInStore
    public static void findProductInStore(Store store, Scanner scanner) {
        System.out.print("Enter Product ID to find: ");
        String productId = scanner.nextLine();
        Product foundProduct = store.findProduct(productId);

        if (foundProduct != null) {
            foundProduct.displayInfo();
        } else {
            System.out.println("Product not found");
        }
    }
}

class Product {
    // Properties
    private String productId;
    private String name;
    private double price;

    // Constructor
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Method
    public void displayInfo() {
        System.out.println("ProductId: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

    public String getProductId() {
        return productId;
    }
}

class Smartphone extends Product {
    // Properties
    private String os;

    // Constructor
    public Smartphone(String productId, String name, double price, String os) {
        super(productId, name, price);
        this.os = os;
    }

    // Method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("OS: " + this.os);
    }
}

class Clothing extends Product {
    // Properties
    private String size;

    // Constructor
    public Clothing(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    // Method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + this.size);
    }
}

class Store {
    // Properties
    private List<Product> products = new ArrayList<>();

    // Method
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getProductId());
    }

    public Product findProduct(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void listProduct() {
        for (Product product : products) {
            product.displayInfo();
            System.out.println("");
        }
    }
}
