class Assignment {
    int a = 100;
    int b = 200;
    String s = "Assignment1 Odelu";

    void sum() {
        int c = a + b;
        System.out.println(c);
    }

    void display() {
        System.out.println("integer 1 is: " + a);
        System.out.println("integer 2 is: " + b);
        System.out.println("String is: " + s);
    }
}

public class May22 {
    public static void main(String[] args) {
        Assignment obj = new Assignment();
        obj.sum();
        obj.display();
    }
}
