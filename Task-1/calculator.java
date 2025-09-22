import java.util.ArrayList;
import java.util.Scanner;

public class calculator {

    // ANSI color codes for console
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean firstInput = true;
        boolean keepRunning = true;
        ArrayList<String> history = new ArrayList<>();

        System.out.println(BLUE + "===============================" + RESET);
        System.out.println(CYAN + "   Welcome to Java Calculator   " + RESET);
        System.out.println(BLUE + "===============================" + RESET);

        while (keepRunning) {
            if (firstInput) {
                System.out.print(YELLOW + "Enter a number: " + RESET);
                result = scanner.nextDouble();
                firstInput = false;
            }

            System.out.println(GREEN + "\nCurrent result: " + String.format("%.2f", result) + RESET);
            System.out.println("Operations: + | - | * | / | C (clear) | H (history) | E (exit)");
            System.out.print("Choose operation: ");
            String operation = scanner.next();

            switch (operation) {
                case "+":
                    System.out.print("Enter number: ");
                    double addNum = scanner.nextDouble();
                    result += addNum;
                    history.add(String.format("%.2f + %.2f = %.2f", result - addNum, addNum, result));
                    break;

                case "-":
                    System.out.print("Enter number: ");
                    double subNum = scanner.nextDouble();
                    result -= subNum;
                    history.add(String.format("%.2f - %.2f = %.2f", result + subNum, subNum, result));
                    break;

                case "*":
                    System.out.print("Enter number: ");
                    double mulNum = scanner.nextDouble();
                    result *= mulNum;
                    history.add(String.format("%.2f * %.2f = %.2f", result / mulNum, mulNum, result));
                    break;

                case "/":
                    System.out.print("Enter number: ");
                    double divNum = scanner.nextDouble();
                    if (divNum == 0) {
                        System.out.println(RED + "Error: Division by zero!" + RESET);
                    } else {
                        result /= divNum;
                        history.add(String.format("%.2f / %.2f = %.2f", result * divNum, divNum, result));
                    }
                    break;

                case "C":
                case "c":
                    System.out.print("Enter new number: ");
                    result = scanner.nextDouble();
                    history.clear();
                    System.out.println(GREEN + "Calculator reset." + RESET);
                    break;

                case "H":
                case "h":
                    System.out.println(CYAN + "\n--- Calculation History ---" + RESET);
                    if (history.isEmpty()) {
                        System.out.println("No history yet.");
                    } else {
                        for (String entry : history) {
                            System.out.println(entry);
                        }
                    }
                    break;

                case "E":
                case "e":
                    keepRunning = false;
                    System.out.println(
                            BLUE + "Exiting calculator. Final result: " + String.format("%.2f", result) + RESET);
                    break;

                default:
                    System.out.println(RED + "Invalid operation! Try again." + RESET);
            }
        }

        scanner.close();
    }
}
