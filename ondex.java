import java.util.ArrayList;
/**
 * ondex
 */
public class ondex {

    public static void main(String[] args) {
        // int score = 75;
        // if (score >= 40) {
        //     System.out.println("F");
        // } else if (score >= 50) {
        //     System.out.println("C");
        // } else if (score >= 60) {
        //     System.out.println("D");
        // } else if (score >= 70) {
        //     System.out.println("B");
        // } else if (score >= 80) {
        //     System.out.println("A");
        // } else {
        //     System.out.println("Not found");
        // }

        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores.add(1);
        scores.add(1);
        scores.add(1);
        scores.add(1);
        scores.add(1);
        System.out.println(scores.get(scores.size()));
    }
}

class A {
    void show() {
        System.out.println("a Show");
    }
}

class B extends A {
    void show() {
        System.out.println("b Show");
    }
}

class C extends B {
    void show() {
        super.show();
    }
}