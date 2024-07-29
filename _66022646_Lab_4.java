// /**
//  * _66022646_Lab_4
//  */
// public class _66022646_Lab_4 {

//     public static void main(String[] args) {

//         // EX1
//         Programmer john = new Programmer("155484", "John", 15, "1");
//         john.displayInfo();
//         john.Work();
//         john.Meeting();

//         john.setProjectName("_66022646_Lab");
//         john.Meeting();
//         john.TakeBrake();

//         //----------------------------------------------------------------

//         // EX2
//         GrauateStudent mac = new GrauateStudent("156512", "Mac","Software Engji", "How to drive a plane?");
//         mac.displayInfo();
//         mac.attend();
//         mac.study();
//         mac.Research();

//         mac.setResearchTopic("How to distroy a plane?");
//         mac.Research();

//         //----------------------------------------------------------------

//         // EX3
//         Laptop Macbook = new Laptop("Macbook", "Apple", 3000, "M1");
//         Smartphone Samsung = new Smartphone("Galaxy", "Samsung", 20000, "Android");
//         Macbook.display();
//         Samsung.display();

//         Macbook.setPrice(59999);
//         Samsung.setPrice(29999);

//         Macbook.display();
//         Samsung.display();
//     }
// }

// class Employees {
//     protected String EmployeeID;
//     protected String EmployeeName;
//     protected int Salary;

//     Employees(String EmployeeID, String EmployeeName, int Salary){
//         this.EmployeeID = EmployeeID;
//         this.EmployeeName = EmployeeName;
//         this.Salary = Salary;
//     }

//     public String getID() {
//         return EmployeeID;
//     }

//     public void setID (String EmployeeID) {
//         this.EmployeeID = EmployeeID;
//     }

//     public String getName() {
//         return EmployeeName;
//     }

//     public void setName (String EmployeeName) {
//         this.EmployeeName = EmployeeName;
//     }

//     public int getSalary() {
//         return Salary;
//     }

//     public void setSalary(int Salary) {
//         this.Salary = Salary;
//     }

//     public void Work() {
//         System.out.println(this.EmployeeName + " is working");
//     }

//     public void TakeBrake() {
//         System.out.println(this.EmployeeName + " is taking a brake");
//     }

//     public void displayInfo() {
//         System.out.println("Name: " + this.EmployeeName);
//         System.out.println("EmployeeID: " + this.EmployeeID);
//         System.out.println("Salary: " + this.Salary);
//     }
// }

// class Programmer extends Employees {
//     protected String ProjectName;

//     Programmer(String EmployeeID, String EmployeeName, int Salary, String ProjectName) {
//         super(EmployeeID, EmployeeName, Salary);
//         this.ProjectName = ProjectName;
//     }

//     public String getProjectName() {
//         return ProjectName;
//     }

//     public void setProjectName (String ProjectName) {
//         this.ProjectName = ProjectName;
//     }

//     public void Meeting() {
//         System.out.println(this.EmployeeName + " is meeting with " + this.ProjectName + " team members");
//     }  
// }

// class UniversityMember {
//     private String membersID;
//     protected String membersName;

//     UniversityMember(String membersID, String membersName) {
//         this.membersID = membersID;
//         this.membersName = membersName;
//     }

//     public String getMembersName() {
//         return membersName;
//     }

//     public void setMembersName(String membersName) {
//         this.membersName = membersName;
//     }

//     public String getMembersID() {
//         return membersID;
//     }

//     public void setMembersID(String membersID) {
//         this.membersID = membersID;
//     }

//     public void attend() {
//         System.out.println(this.membersName + " is attending the university");
//     }

//     public void displayInfo() {
//         System.out.println("Name: " + this.membersName);
//         System.out.println("ID" + this.membersID);
//     }
// }

// class Student extends UniversityMember {
//     protected String Major;

//     Student(String membersID, String membersName, String Major) {
//         super(membersID, membersName);
//         this.Major = Major;
//     }

//     public String getMajor() {
//         return Major;
//     }

//     public void setMajor(String major) {
//         Major = major;
//     }

//     public void study () {
//         System.out.println(this.membersName + " is studying " + this.Major);
//     }
// }

// class GrauateStudent extends Student {
//     private String researchTopic;

//     GrauateStudent(String membersID, String membersName, String major, String researchTopic) {
//         super(membersID, membersName, major);
//         this.researchTopic = researchTopic;
//     }

//     public void Research () {
//         System.out.println(this.membersName + " is researching on " + this.researchTopic);
//     }

//     public String getResearchTopic() {
//         return researchTopic;
//     }

//     public void setResearchTopic(String researchTopic) {
//         this.researchTopic = researchTopic;
//     }
// }

// class Product {
//     protected String name;
//     protected String brand;
//     protected int price;

//     Product(String name, String brand, int price) {
//         this.name = name;
//         this.brand = brand;
//         this.price = price;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getPrice() {
//         return price;
//     }

//     public void setPrice(int price) {
//         this.price = price;
//     }

//     public String getBrand() {
//         return brand;
//     }

//     public void setBrand(String brand) {
//         this.brand = brand;
//     }

//     public void display () {
//         System.out.println("**** Product discription. ****");
//         System.out.println("Name: " + this.name);
//         System.out.println("brand: " + this.brand);
//         System.out.println("price: " + this.price + " THB");
//     }
// }

// class Laptop extends Product {
//     protected String CUP; 

//     Laptop(String name, String brand, int price, String CPU) {
//         super(name, brand, price);
//         this.CUP = CPU;
//     }

//     public String getCUP() {
//         return CUP;
//     }

//     public void setCUP(String cUP) {
//         this.CUP = cUP;
//     }

//     @Override
//     public void display() {
//         // TODO Auto-generated method stub
//         super.display();
//         System.out.println("CPU : " + this.CUP);
//         System.out.println(" ");
//     }
// }

// class Smartphone extends Product {
//     protected String OS;

//     Smartphone(String name, String brand, int price, String OS) {
//         super(name, brand, price);
//         this.OS = OS;
//     }

//     public String getOS() {
//         return OS;
//     }

//     public void setOS(String OS) {
//         this.OS = OS;
//     }

//     @Override
//     public void display() {
//         // TODO Auto-generated method stub
//         super.display();
//         System.out.println("OS : " + this.OS);
//         System.out.println(" ");
//     }
// }
// //Ex 1
// // Name: John
// // EmployeeID: 155484
// // Salary: 15
// // John is working
// // John is meeting with 1 team members
// // John is meeting with _66022646_Lab team members
// // John is taking a brake

// //Ex2
// // Name: Mac
// // ID156512
// // Mac is attending the university
// // Mac is studying Software Engji
// // Mac is researching on How to drive a plane?
// // Mac is researching on How to distroy a plane?

// //Ex3
// // **** Product discription. ****
// // Name: Macbook
// // brand: Apple
// // price: 3000 THB
// // CPU : M1

// // **** Product discription. ****
// // Name: Galaxy
// // brand: Samsung
// // price: 20000 THB
// // OS : Android

// // **** Product discription. ****
// // Name: Macbook
// // brand: Apple
// // price: 59999 THB
// // CPU : M1

// // **** Product discription. ****
// // Name: Galaxy
// // brand: Samsung
// // price: 29999 THB
// // OS : Android