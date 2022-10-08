import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    private static Stack<String> stack = new Stack<>();
    private static Scanner userInput = new Scanner(System.in);

    public Calculator(Stack<String> stack, Scanner userInput) {
        Calculator.stack = stack;
        Calculator.userInput = userInput;
    }

    public static void main(String[] args) {
        System.out.println("Insert an expression in polish notation:\n");
        String input = userInput.nextLine();

        String[] elements = input.split("\\s+");

        for(String s : elements){
            int result = 0;
            int x, y;
            switch (s) {
                case "*" -> {
                    result = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(result));
                }
                case "/" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    result = y / x;
                    stack.push(String.valueOf(result));
                }
                case "+" -> {
                    result = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(result));
                }
                case "-" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    result = y - x;
                    stack.push(String.valueOf(result));
                }
                default -> stack.push(s);
            }
        }
        System.out.println("Result: " + stack.peek());
    }
}
