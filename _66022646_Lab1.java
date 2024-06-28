import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class _66022646_Lab1 {

    public static void Ex1() {
        Scanner kbd = new Scanner(System.in);

        System.out.println("Please enter your name : ");
        String name = kbd.next();

        System.out.println("Please enter your age : ");
        int age = kbd.nextInt();

        System.out.println("Please enter your future occupation");
        String occupation = kbd.next();

        System.out.println("Your name is : " + name);
        System.out.println("Your age is : " + age);
        System.out.print("Your future occupation is : " + occupation);

        kbd.close();
    }

    public static void Ex2() {
        Scanner kbd = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int n = kbd.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int num = kbd.nextInt();
            sum += num;
        }
        int Average = sum / n;
        System.out.println("the Average is " + Average);
        kbd.close();
    }

    public static void Ex3() {
        Scanner kbd = new Scanner(System.in);
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(100) + 1;

        System.out.println("Enter your number : ");
        int player_num = kbd.nextInt();

        System.out.println("Random num " + randomNumber);

        boolean player_lose = true;
        while (player_lose == true) {
            if (randomNumber == player_num) {
                System.out.println("Correct");
                break;
            } else if (randomNumber > player_num) {
                System.out.println("Lesser");
            } else if (randomNumber < player_num) {
                System.out.println("Greater");
            }
            System.out.println("Enter your number : ");
            player_num = kbd.nextInt();
        }
        kbd.close();
    }

    public static void Ex4() {
        ArrayList<Integer> Al = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();

        Al.add(69);
        Al.add(3);
        Al.add(12);
        Al.add(21);
        Al.add(1);
        Al.add(144);
        Al.add(2);
        Al.add(5);
        Al.add(299);
        Al.add(4);

        int sum = 0;
        for (int i : Al) {
            sum += i;
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }
        int size = Al.size();
        int Average = sum / size;
        System.out.println(Al);
        System.out.println("Odd numbers: " + odd);
        System.out.println("Even numbers: " + even);
        System.out.println("Average is: " + Average);

    }

    public static void Ex5() {
        Scanner kbd = new Scanner(System.in);
        ArrayList<String> occupations = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        boolean unExit = true;
        while (unExit) {
            System.out.println("Enter your name and your occupation (type 'exit' to finish): ");
            String name = kbd.next();
            if (name.equals("exit")) {
                unExit = false;
            } else {
                names.add(name);
                String occupation = kbd.next();
                occupations.add(occupation);
            }
        }

        System.out.println("Names: " + names);
        System.out.println("Occupations: " + occupations);
        kbd.close();
    }

    public static void Ex6() {
        Scanner kbd = new Scanner(System.in);
        ArrayList<String> splitWord = new ArrayList<>();

        System.out.println("Enter your word: ");
        String word = kbd.next();

        if (word.length() > 15) {
            System.out.println("The word is too long");
            kbd.close();
            return;
        }

        String[] arrOfStr = word.split("");
        for (String a : arrOfStr) {
            splitWord.add(a);
        }

        System.out.println("SplitWord: " + splitWord);

        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;
        for (String letter : splitWord) {
            switch (letter) {
                case "a":
                    aCount++;
                    break;
                case "e":
                    eCount++;
                    break;
                case "i":
                    iCount++;
                    break;
                case "o":
                    oCount++;
                    break;
                case "u":
                    uCount++;
                    break;
            }
        }

        System.out.println("a : " + aCount);
        System.out.println("e : " + eCount);
        System.out.println("i : " + iCount);
        System.out.println("o : " + oCount);
        System.out.println("u : " + uCount);

        kbd.close();
    }

    public static void main(String[] args) {
        Ex1(); 

        Ex2(); 

        Ex3(); 

        Ex4(); 

        Ex5(); 

        Ex6(); 
    }
}
