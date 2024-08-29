public class MainLab5 {

    public static void main(String[] args) {

        //Ex1
        Sale emp1 = new Sale("Mac", 5000);
        emp1.ShowDetails();

        Programmer emp2 = new Programmer("Doue", 5);
        emp2.ShowDetails();

        //Ex2
        Student st1 = new Student("Wade", 20, "66123456", 2);
        Teacher t1 = new Teacher("Logan", 40, "T1234", "Science");

        System.out.println("*******************");
        st1.display();
        st1.attendClass();

        System.out.println("*******************");
        t1.display();
        t1.teachClass();

        AdvisingTeacher advT = new AdvisingTeacher("Tony", 45, "T456", "Software Engineering");
        StudentClubMember cm = new StudentClubMember("Natasha", 19, "66987643", 2);

        System.out.println("*******************");
        advT.display();
        advT.teachClass();
        advT.adviseClass();

        System.out.println("*******************");
        cm.display();
        cm.attendClass();
        cm.joinClub();
    }
}

class Employee {
    protected String name;
    protected String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public double CalSalary() {
        return 0.0;
    }

    public void ShowDetails() {
        System.out.println("Name : " + name);
        System.out.println("Position : " + position);
        System.out.println("Salary : " + CalSalary());
    }
}

class Sale extends Employee {
    private double salary;
    private double commission;

    public Sale(String name, double commission) {
        super(name, "Sale");
        this.salary = 15000;  
        this.commission = commission;
    }

    @Override
    public double CalSalary() {
        return salary + commission;
    }
}

class Programmer extends Employee {
    private double salary;
    private int languageBonus;

    public Programmer(String name, int languageBonus) {
        super(name, "Programmer");
        this.salary = 25000; 
        this.languageBonus = languageBonus;
    }

    @Override
    public double CalSalary() {
        return salary + (languageBonus * 1000);
    }
}

interface ClassAdvisor {
    void adviseClass();
}

interface ClubMember {
    void joinClub();
}

abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    protected String teacherId;
    protected String department;

    public Teacher(String name, int age, String teacherId, String department) {
        super(name, age);
        this.teacherId = teacherId;
        this.department = department;
    }

    public void teachClass() {
        System.out.println(name + " is teaching " + department + ".");
    }
}

class Student extends Person {
    protected String studentId;
    protected int year;

    public Student(String name, int age, String studentId, int year) {
        super(name, age);
        this.studentId = studentId;
        this.year = year;
    }

    public void attendClass() {
        System.out.println(name + " is attending class.");
    }
}

class AdvisingTeacher extends Teacher implements ClassAdvisor {
    public AdvisingTeacher(String name, int age, String teacherId, String department) {
        super(name, age, teacherId, department);
    }

    @Override
    public void adviseClass() {
        System.out.println(name + " is advising a student.");
    }
}

class StudentClubMember extends Student implements ClubMember {
    public StudentClubMember(String name, int age, String studentId, int year) {
        super(name, age, studentId, year);
    }

    @Override
    public void joinClub() {
        System.out.println(name + " is joining in a club activity.");
    }
}
// Ex 1
// Name : Mac
// Position : Sale
// Salary : 20000.0
// Name : Doue
// Position : Programmer
// Salary : 30000.0

//Ex2
// *******************
// Name: Wade, Age: 20
// Wade is attending class.
// *******************
// Name: Logan, Age: 40
// Logan is teaching Science.
// *******************
// Name: Tony, Age: 45
// Tony is teaching Software Engineering.
// Tony is advising a student.
// *******************
// Name: Natasha, Age: 19
// Natasha is attending class.
// Natasha is joining in a club activity.