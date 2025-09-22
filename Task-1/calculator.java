import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean firstInput = true; // To check if first number is entered
        boolean keepRunning = true;

        System.out.println("--- Java Running Console Calculator ---");

        while (keepRunning) {
            if (firstInput) {
                System.out.print("Enter a number: ");
                result = scanner.nextDouble();
                firstInput = false;
            }

            System.out.println("\nCurrent result: " + result);
            System.out.println("Choose an operation: +, -, *, /, C (clear), E (exit)");
            System.out.print("Enter operation: ");
            String operation = scanner.next();

            switch (operation) {
                case "+":
                    System.out.print("Enter number: ");
                    result += scanner.nextDouble();
                    break;

                case "-":
                    System.out.print("Enter number: ");
                    result -= scanner.nextDouble();
                    break;

                case "*":
                    System.out.print("Enter number: ");
                    result *= scanner.nextDouble();
                    break;

                case "/":
                    System.out.print("Enter number: ");
                    double divisor = scanner.nextDouble();
                    if (divisor == 0) {
                        System.out.println("Error: Division by zero!");
                    } else {
                        result /= divisor;
                    }
                    break;

                case "C": // Clear the result
                case "c":
                    System.out.print("Enter new number: ");
                    result = scanner.nextDouble();
                    break;

                case "E": // Exit
                case "e":
                    keepRunning = false;
                    System.out.println("Exiting calculator. Final result: " + result);
                    break;

                default:
                    System.out.println("Invalid operation! Try again.");
            }
        }

        scanner.close();
    }
}
