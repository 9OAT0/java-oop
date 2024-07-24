// import java.util.ArrayList;
// import java.util.Scanner;

// public class _66022646_Lab3 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         ArrayList<Student> students = new ArrayList<>();

//         // Ex 1
//         while (true) {
//             System.out.println("Enter name (or 'Exit' to finish): ");
//             String name = sc.nextLine();
//             if (name.equalsIgnoreCase("Exit")) {
//                 break;
//             }

//             System.out.println("Enter age: ");
//             int age = sc.nextInt();

//             System.out.println("Enter score: ");
//             int score = sc.nextInt();
//             sc.nextLine();  

//             Student student = new Student(name, age, score);
//             students.add(student);
//         }

//         System.out.println("\nAll students:");
//         for (Student student : students) {
//             student.displayInfo();
//             System.out.println("---------------------------");
//         }

//         sc.close();
//         // -----------------------------

//         // Ex 2

//         Character Sofia = new Character("Sofia");
//         Sofia.displayInfo();

//         Sofia.setExp(100);
//         Sofia.displayInfo();

//         Sofia.setExp(1000);
//         Sofia.displayInfo();

//         // ---------------------------

//         // Ex 3

//         Company company = new Company("Tech Corp");

//         company.addEmployee("John Doe", 50000, 7);
//         company.addEmployee("Jane Smith", 60000, 3);

//         System.out.println("Initial Company Information:");
//         company.displayInfo();

//         company.setEmpSalary("John Doe", 55000);
//         company.displayInfo();

//         company.setEmpSalary("Jane Smith", 65000);
//         company.displayInfo();

//         // ---------------------------

//     }
// }

// class Student {
//     private String name;
//     private int age;
//     private int score;

//     // Constructor
//     public Student(String name, int age, int score) {
//         this.name = name;
//         this.age = age;
//         this.score = score;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getAge() {
//         return age;
//     }

//     public void setAge(int age) {
//         if (age > 0) {
//             this.age = age;
//         }
//     }

//     public int getScore() {
//         return score;
//     }

//     public void setScore(int score) {
//         if (score > 0) {
//             this.score = score;
//         }
//     }

//     public String calGrade(int score) {
//         if (score >= 85) {
//             return "A";
//         } else if (score >= 75) {
//             return "B";
//         } else if (score >= 65) {
//             return "C";
//         } else if (score >= 45) {
//             return "D";
//         } else {
//             return "F";
//         }
//     }

//     public void displayInfo() {
//         System.out.println("Name: " + name);
//         System.out.println("Age: " + age);
//         System.out.println("Grade: " + calGrade(score));
//     }
// }

// class Character {

//     // Properties
//     private String name;
//     private int maxHealth;
//     private int level;
//     private int exp;

//     // Constructor
//     public Character(String name) {
//         this.name = name;
//         this.maxHealth = 100;
//         this.level = 1;
//         this.exp = 0;
//     }

//     // Getter and Setter
//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getMaxHealth() {
//         return maxHealth;
//     }

//     public void setMaxHealth(int maxHealth) {
//         this.maxHealth = maxHealth;
//     }

//     public int getLevel() {
//         return level;
//     }

//     public int getExp() {
//         return exp;
//     }

//     public void setExp(int exp) {
//         this.exp += exp;
//         levelUp();
//     }

//     public void displayInfo() {
//         System.out.println("***** Character Information: *****");
//         System.out.println("Name: " + name);
//         System.out.println("Max Health: " + maxHealth);
//         System.out.println("Level: " + level);
//         System.out.println("Current Exp: " + exp);
//         System.out.println("******************************");
//     }

//     private void levelUp() {
//         int req_exp = level * 1000;
//         while (exp >= req_exp) {
//             level++;
//             maxHealth += 100;
//             exp -= req_exp;
//             req_exp = level * 1000;
//         }
//     }
// }

// class Employee {

//     // Properties
//     private String name;
//     private double salary;
//     private int exp;

//     // Constructor
//     public Employee(String name, double salary, int exp) {
//         this.name = name;
//         this.salary = salary;
//         this.exp = exp;
//     }

//     // Getter and Setter
//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public double getSalary() {
//         return salary;
//     }

//     public void setSalary(double salary) {
//         this.salary = salary;
//     }

//     public int getExp() {
//         return exp;
//     }

//     public void setExp(int exp) {
//         this.exp = exp;
//     }

//     public double calBonus() {
//         return (salary * exp) * 0.3;
//     }
// }

// class Company {

//     // Properties
//     private String compName;
//     private ArrayList<Employee> employees;

//     // Constructor
//     public Company(String companyName) {
//         this.compName = companyName;
//         this.employees = new ArrayList<>();
//     }

//     // Methods
//     public void addEmployee(String name, double salary, int exp) {
//         Employee newEmployee = new Employee(name, salary, exp);
//         employees.add(newEmployee);
//     }

//     public void setEmpSalary(String name, double newSalary) {
//         for (Employee employee : employees) {
//             if (employee.getName().equals(name)) {
//                 employee.setSalary(newSalary);
//                 return;
//             }
//         }
//         System.out.println("Employee with name " + name + " not found");
//     }

//     public void displayInfo() {
//         System.out.println("*** Company Name: " + compName + " ***");
//         for (Employee employee : employees) {
//             System.out.println("\nName: " + employee.getName());
//             System.out.println("Salary: " + employee.getSalary());
//             System.out.println("Experience: " + employee.getExp());
//             System.out.println("Bonus: " + employee.calBonus());
//             System.out.println("**********************");
//         }
//     }
// }

// //Output
// // Enter name (or 'Exit' to finish): 
// // A
// // Enter age:
// // 23
// // Enter score:
// // 90
// // Enter name (or 'Exit' to finish):
// // B
// // Enter age:
// // 23
// // Enter score:
// // 60
// // Enter name (or 'Exit' to finish):
// // C
// // Enter age:
// // 23
// // Enter score:
// // 50
// // Enter name (or 'Exit' to finish):
// // exit

// // All students:
// // Name: A
// // Age: 23
// // Grade: A
// // ---------------------------
// // Name: B
// // Age: 23
// // Grade: D
// // ---------------------------
// // Name: C
// // Age: 23
// // Grade: D
// // ---------------------------
// // ***** Character Information: *****
// // Name: Sofia
// // Max Health: 100
// // Level: 1
// // Current Exp: 0
// // ******************************
// // ***** Character Information: *****
// // Name: Sofia
// // Max Health: 100
// // Level: 1
// // Current Exp: 100
// // ******************************
// // ***** Character Information: *****
// // Name: Sofia
// // Max Health: 200
// // Level: 2
// // Current Exp: 100
// // ******************************
// // Initial Company Information:
// // *** Company Name: Tech Corp ***

// // Name: John Doe
// // Salary: 50000.0
// // Experience: 7
// // Bonus: 105000.0
// // **********************

// // Name: Jane Smith
// // Salary: 60000.0
// // Experience: 3
// // Bonus: 54000.0
// // **********************
// // *** Company Name: Tech Corp ***

// // Name: John Doe
// // Salary: 55000.0
// // Experience: 7
// // Bonus: 115500.0
// // **********************

// // Name: Jane Smith
// // Salary: 60000.0
// // Experience: 3
// // Bonus: 54000.0
// // **********************
// // *** Company Name: Tech Corp ***

// // Name: John Doe
// // Salary: 55000.0
// // Experience: 7
// // Bonus: 115500.0
// // **********************

// // Name: Jane Smith
// // Salary: 65000.0
// // Experience: 3
// // Bonus: 58500.0
// // **********************