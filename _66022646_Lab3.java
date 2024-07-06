import java.util.ArrayList;
import java.util.Scanner;

public class _66022646_Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Ex 1
        while (true) {
        System.out.println("Enter name (or 'Exit' to finish): ");
        String name = sc.nextLine();
        if (name.equalsIgnoreCase("Exit")) {
        break;
        }

        System.out.println("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Enter score: ");
        int score = sc.nextInt();
        sc.nextLine();

        Student student = new Student(name, age, score);
        students.add(student);
        }

        System.out.println("\nAll students:");
        for (Student student : students) {
        student.displayInfo();
        System.out.println("---------------------------");
        }

        sc.close();
        // -----------------------------

        // Ex 2

        Character Sofia = new Character("Sofia");
        Sofia.displayInfo();

        Sofia.setExp(100);
        Sofia.displayInfo();

        Sofia.setExp(1000);
        Sofia.displayInfo();

        // ---------------------------

        // Ex 3

        // สร้างตัวอย่างของ Company
        Company company = new Company("Tech Corp");
        // เพิ่มพนักงาน
        company.addEmployee("John Doe", 50000, 7);
        company.addEmployee("Jane Smith", 60000, 3);

        // แสดงข้อมูลบริษัทและพนักงาน
        System.out.println("Initial Company Information:");
        company.displayInfo();

        // แก้ไขเงินเดือนพนักงาน
        company.setEmpSalary("John Doe", 55000);
        company.displayInfo();

        // ---------------------------

    }
}

class Student {
    private String name;
    private int age;
    private int score;

    // Construc
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score > 0) {
            this.score = score;
        }
    }

    public String calGrade(int score) {
        if (score >= 85) {
            return "A";
        } else if (score >= 75) {
            return "B";
        } else if (score >= 65) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + calGrade(score));
    }
}

class Character {

    // Prop

    private String name;
    private int MaxHealth;
    private int Level;
    private int Exp;

    // Construc

    public Character(String name) {
        this.name = name;
        this.MaxHealth = 100;
        this.Level = 1;
        this.Exp = 0;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int MaxHealth) {
        this.MaxHealth = MaxHealth;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int Exp) {
        this.Exp += Exp;
        levelUp();
    }

    public void displayInfo() {
        System.out.println("***** Character Information: *****");
        System.out.println("Name: " + name);
        System.out.println("Max Health: " + MaxHealth);
        System.out.println("Level: " + Level);
        System.out.println("Current Exp: " + Exp);
        System.out.println("******************************");
    }

    private void levelUp() {
        int req_exp = Level * 1000;
        if (Exp >= req_exp) {
            Level++;
            MaxHealth += 100;
            req_exp = Level * 1000;
        }
    }
}

class Employee {

    // Prop

    private String name;
    private double salary;
    private int exp;

    // Construc

    public Employee(String name, double salary, int exp) {
        this.name = name;
        this.salary = salary;
        this.exp = exp;
    }

    // Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double calBonus() {
        return (salary * exp) * 0.3;
    }
}

class Company {

    // Prop

    private String Compname;
    private ArrayList<Employee> employees;

    // Met

    public Company(String companyName) {
        this.Compname = companyName;
        this.employees = new ArrayList<Employee>();
    }

    public void addEmployee(String name, int salary, int exp) {
        Employee newEmployee = new Employee(name, salary, exp);
        employees.add(newEmployee);
    }

    public void setEmpSalary(String name, int newSalaly) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employee.setSalary((newSalaly));
                return;
            }
        }
        System.out.println("Employee with name " + name + " not found");

    }

    public void displayInfo() {
        System.out.println("*** Comoany Name: " + Compname + " ***");
        for (Employee employee : employees) {
            System.out.println("\nName: " + employee.getName());
            System.out.println("\nSalary: " + employee.getSalary());
            System.out.println("\nExperience: " + employee.getExp());
            System.out.println("\nZBonus: " + employee.calBonus());
            System.out.println("**********************");
        }
    }
}