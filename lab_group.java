import java.util.ArrayList;
import java.util.List;

public class lab_group {
    
// - สร้าง object จาก class Store
// - แสดง menu
// Product Store Menu:
// 1. Add Product to store
// 2. List Products
// 3. Find Product
// 4. Exit
// - รับค่า ตัวเลขหน้า menu จาก keyboard 

}

class Product {

    //prop
    private String ProductId;
    private String Name;
    private double Price; 

    //Constructor
    Product(String ProductId, String Name, double Price) {
        this.ProductId = ProductId;
        this.Name = Name;
        this.Price = Price;
    }

    //Method
    public void displayInfo() {
        System.out.println("ProductId: " + ProductId);
        System.out.println("Name: " + Name);
        System.out.println("Price: " + Price);
    }
}

class Smartphone extends Product {
    
    //Prop
    private String OS;

    //Constructor
    Smartphone(String ProductId, String Name, double Price, String OS) {
        super(ProductId, Name, Price);
        this.OS = OS;
    }

    //Method
    public void displayInfo(String ProductId) {
        //เรียก super ของ method displayInfo()

    }
}

class Clothing extends Product {

    //Prop
    private String Size;

    //Constructor
    Clothing(String ProductId, String Name, double Price, String Size){
        super(ProductId, Name, Price);
        this.Size = Size;
    }

    //Method
    public void displayInfo() {
        //เรียก super ของ method displayInfo()
    }
}

class Store {
    
    //Prop
    private ArrayList<Store> Store = new ArrayList<>();

    //Method
    public void addProduct(Product product) {
        //หลังจาก add product ลงใน Arraylist แล้วให้ print 

    }

    public void findProduct(String productId) {
        //Check productid ที่รับมาใน ArrayList ถ้ามี ให้ return Product ตัวนั้น

    }

    public void listProduct() {
        //Product ทุกตัว เรียก method displayInfo()

    }
}
