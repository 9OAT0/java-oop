// import java.util.ArrayList;
// import java.util.Scanner;

// public class _66022646_Lab2 {
//     public static void main(String[] args) {

//         Scanner kbd = new Scanner(System.in);


//         // Object
//         Kinght Arthur = new Kinght();
//         Arthur.name = "Arthur";
//         Arthur.hp = 100;
//         Arthur.mp = 100;
//         Arthur.Attack();
//         Arthur.Block();
//         Arthur.ShowDetails();

//         Mage Sorcerer = new Mage();
//         Sorcerer.name = "Sorcerer";
//         Sorcerer.hp = 100;
//         Sorcerer.mp = 100;
//         Sorcerer.Attack();
//         Sorcerer.Magic();
//         Sorcerer.ShowDetails();

//         System.out.println("Please enter How many your product :");
//         int Products = kbd.nextInt();
//         for (int i = 0; i < Products; i++) {
//         Product product = new Product();

//         System.out.println("Please enter your product name:");
//         product.name = kbd.next();

//         System.out.println("Please enter your product price: ");
//         product.price = kbd.nextInt();

//         System.out.println("Please enter your product quantity: ");
//         product.quantity = kbd.nextInt();
//         product.ShowDetails();

//         System.out.println();
//         System.out.println("There are " + ((Products - 1) - i ) +" products left.");
//         }

//         kbd.close();

//         student john = new student("john" , 66022646);

//         student anna = new student("anna", 66022345);

//         //course
//         course java = new course("java",2348902,3);
//         course c = new course("c",2348903,3);
//         course python = new course("python", 2343243, 3);
//         course csharp = new course("csharp", 2343244, 3);

//         course phy = new course("physic", 2342532, 3);
//         course chem = new course("chemistry", 2342533, 3);
//         course math = new course("math", 2342534, 3);



//         john.addcourse(c);
//         john.addcourse(java);
//         john.addcourse(python);
//         john.addcourse(csharp);


//         anna.addcourse(phy);
//         anna.addcourse(chem);
//         anna.addcourse(math);

//         john.ShowDetails();

//         anna.ShowDetails();
//     }

// }


// class Kinght {
//     // Prop
//     public int hp;
//     public int mp;
//     public String name;

//     // Method
//     public void Attack() {
//         System.out.println("Knigth is Attacking!!!!");
//     }

//     public void Block() {
//         System.out.println("Knigth is Blocking!!!!");
//     }

//     public void ShowDetails() {
//         System.out.println("*** Details of " + this.name + "***");
//         System.out.println("Name : " + this.name);
//         System.out.println("HP : " + this.hp);
//         System.out.println("MP : " + this.mp);
//     }
// }

// class Mage {
//     // Prop
//     public int hp;
//     public int mp;
//     public String name;

//     // Method
//     public void Attack() {
//         System.out.println("Mage is Attacking!!!!");
//     }

//     public void Magic() {
//         System.out.println("Mage is useing Magic!!!!");
//     }

//     public void ShowDetails() {
//         System.out.println("*** Details of " + this.name + "***");
//         System.out.println("Name : " + this.name);
//         System.out.println("HP : " + this.hp);
//         System.out.println("MP : " + this.mp);
//     }
// }

// class Product {
//     // Prop
//     public String name;
//     public int price;
//     public int quantity;

//     // Method
//     public void ShowDetails() {
//         System.out.println("*** Details of " + this.name + "***");
//         System.out.println("Name : " + this.name);
//         System.out.println("Price : " + this.price);
//         System.out.println("Quantity : " + this.quantity);
//         System.out.println("Total price :" + this.price * this.quantity);
//     }
// }

// class student {
//     // Prop
//     public String name;
//     public int student_code;

//     ArrayList<course> courses  = new ArrayList<course>();

//     // Method

//     student(String name, int student_code) {
//         this.name = name;
//         this.student_code = student_code;
//     }
//     public void ShowDetails() {
//         System.out.println("*** Details of " + this.name + " ***");
//         System.out.println("Name : " + this.name);
//         System.out.println("Student code : " + this.student_code);
//         System.out.println();
//         System.out.println("*** Detaile of " + this.name + " course ***");
//         System.out.println();
//         for (course course : this.courses) {
//             course.ShowDetails();
//         }
//     }

//     public void addcourse(course course) {
//         this.courses.add(course);
//     }
// }

// class course {
//     // Prop
//     int course_code;
//     String course_name;
//     int creadit;

//     course(String course_name, int course_code, int creadit){
//         this.course_name = course_name;
//         this.course_code = course_code;
//         this.creadit = creadit;
//     }

//     // Method

//     course(String name){
//         this.course_name = name;

//     }
//     public void ShowDetails() {
//         System.out.println("*** Details of " + this.course_name + " ***");
//         System.out.println("Course name : " + this.course_name);
//         System.out.println("Course code : " + this.course_code);
//         System.out.println("Creadit : " + this.creadit);
//         System.out.println();
//     }
// }

// // Knigth is Attacking!!!!
// // Knigth is Blocking!!!!
// // *** Details of Arthur***
// // Name : Arthur
// // HP : 100
// // MP : 100
// // Mage is Attacking!!!!
// // Mage is useing Magic!!!!
// // *** Details of Sorcerer***
// // Name : Sorcerer
// // HP : 100
// // MP : 100
// // Please enter How many your product :
// // 3
// // Please enter your product name:
// // a
// // Please enter your product price:
// // 20
// // Please enter your product quantity:
// // 10
// // *** Details of a***
// // Name : a
// // Price : 20
// // Quantity : 10
// // Total price :200

// // There are 2 products left.
// // Please enter your product name:
// // b
// // Please enter your product price:
// // 10
// // Please enter your product quantity:
// // 30
// // *** Details of b***
// // Name : b
// // Price : 10
// // Quantity : 30
// // Total price :300

// // There are 1 products left.
// // Please enter your product name:
// // c
// // Please enter your product price:
// // 40
// // Please enter your product quantity:
// // 5
// // *** Details of c***
// // Name : c
// // Price : 40
// // Quantity : 5
// // Total price :200

// // There are 0 products left.
// // *** Details of john ***
// // Name : john
// // Student code : 66022646

// // *** Detaile of john course ***

// // *** Details of c ***
// // Course name : c
// // Course code : 2348903
// // Creadit : 3

// // *** Details of java ***
// // Course name : java
// // Course code : 2348902
// // Creadit : 3

// // *** Details of python ***
// // Course name : python
// // Course code : 2343243
// // Creadit : 3

// // *** Details of csharp ***
// // Course name : csharp
// // Course code : 2343244
// // Creadit : 3

// // *** Details of anna ***
// // Name : anna
// // Student code : 66022345

// // *** Detaile of anna course ***

// // *** Details of physic ***
// // Course name : physic
// // Course code : 2342532
// // Creadit : 3

// // *** Details of chemistry ***
// // Course name : chemistry
// // Course code : 2342533
// // Creadit : 3

// // *** Details of math ***
// // Course name : math
// // Course code : 2342534
// // Creadit : 3