import java.util.Scanner;

public class _66022646_Lab1 {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("Please enter your name : ");
        String name = kbd.next();

        System.out.println("Your name is : " + name);

        System.out.println("Please enter your age : ");
        int age = kbd.nextInt();

        System.out.println("Your age is : " + age);

        System.out.println("Please enter your future occupation");
        String occupation = kbd.next();

        System.out.print("Your future occupation is : " + occupation);

        kbd.close();
    }
}
