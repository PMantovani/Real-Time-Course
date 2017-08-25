public class Calculator extends Thread {
    private char operation;
    private double op1;
    private double op2;
    public double result;

    public Calculator(double op1, double op2, char operation) {
        this.operation = operation;
        this.op1 = op1;
        this.op2 = op2;
    }

    public void run() {
        switch (operation) {
            case '+':
                this.result = op1 + op2;
                break;
            case '-':
                this.result = op1 - op2;
                break;
            case '*':
                this.result = op1 * op2;
                break;
            case '/':
                this.result = op1 / op2;
                break;
            default:
                this.result = 9;
        }
    }
}
