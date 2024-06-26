import java.util.Scanner;

public class ondex {
    public static void main(String[] args) {
        Scanner  kbd = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = kbd.nextInt();

        System.out.println("The number is : " + n);

        kbd.close();
    }
}
