package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println("---------");
        System.out.println("| " + string.charAt(0) + " " + string.charAt(1) + " " + string.charAt(2) + " |");
        System.out.println("| " + string.charAt(3) + " " + string.charAt(4) + " " + string.charAt(5) + " |");
        System.out.println("| " + string.charAt(6) + " " + string.charAt(7) + " " + string.charAt(8) + " |");
        System.out.println("---------");
    }
}
