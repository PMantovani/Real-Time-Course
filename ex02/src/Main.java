import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the first operator: ");
        double op1 = scan.nextDouble();

        System.out.println("Please enter the second operator: ");
        double op2 = scan.nextDouble();

        Calculator th1 = new Calculator(op1, op2, '+');
        Calculator th2 = new Calculator(op1, op2, '-');
        Calculator th3 = new Calculator(op1, op2, '*');
        Calculator th4 = new Calculator(op1, op2, '/');

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();

            System.out.println("Addition Result: " + th1.result);
            System.out.println("Subtraction Result: " + th2.result);
            System.out.println("Multiplication Result: " + th3.result);
            System.out.println("Division Result: " + th4.result);

        } catch (InterruptedException e) {
            System.out.println("Threads were Interrupted!");
        }
    }
}
