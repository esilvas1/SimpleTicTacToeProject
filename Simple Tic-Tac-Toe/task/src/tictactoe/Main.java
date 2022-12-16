package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String[][] matrix = printGame();
        if (isThereWinner(matrix) && !isGameImpossible(matrix)) System.out.println(winner(matrix) + " wins");
        else if (isGameImpossible(matrix)) System.out.println("Impossible");
        else if (withSpace(matrix)) System.out.println("Game not finished");
        else if (isDraw(matrix)) System.out.println("Draw");
    }

    public static boolean withSpace(String[][] matrix) {
        boolean flag = false;
        final String space = "_";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (space.equals(matrix[i][j])) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static boolean isGameImpossible(String[][] matrix) {
        boolean flag = false;
             if (column1(matrix) && column2(matrix)) flag = true;
        else if (column1(matrix) && column3(matrix)) flag  = true;
        else if (column2(matrix) && column3(matrix)) flag = true;
        else if (row1(matrix) && row2(matrix)) flag = true;
        else if (row1(matrix) && row3(matrix)) flag = true;
        else if (row2(matrix) && row3(matrix)) flag = true;
        else if ((Integer.max(countO(matrix),countX(matrix)) - Integer.min(countO(matrix), countX(matrix))) >= 2 ) flag = true;
        return flag;
    }

    public static boolean isDraw(String[][] matrix) {
        boolean flag = true;
        if (column1(matrix)) flag = false;
        else if (column2(matrix)) flag = false;
        else if (column3(matrix)) flag = false;
        else if (row1(matrix)) flag = false;
        else if (row2(matrix)) flag = false;
        else if (row3(matrix)) flag = false;
        else if (diagonal1(matrix)) flag = false;
        else if (diagonal2(matrix)) flag = false;
        return flag;
    }
    public static boolean isThereWinner(String[][] matrix) {
        boolean flag = false;
        if (column1(matrix)) flag = true;
        else if (column2(matrix)) flag = true;
        else if (column3(matrix)) flag = true;
        else if (row1(matrix)) flag = true;
        else if (row2(matrix)) flag = true;
        else if (row3(matrix)) flag = true;
        else if (diagonal1(matrix)) flag = true;
        else if (diagonal2(matrix)) flag = true;
        return flag;
    }

    public static String winner(String[][] matrix) {
        String winner = "";
        if (column1(matrix)) winner = matrix[0][0];
        else if (column2(matrix)) winner = matrix[0][1];
        else if (column3(matrix)) winner = matrix[0][2];
        else if (row1(matrix)) winner = matrix[0][0];
        else if (row2(matrix)) winner = matrix[1][0];
        else if (row3(matrix)) winner = matrix[2][0];
        else if (diagonal1(matrix)) winner = matrix[0][0];
        else if (diagonal2(matrix)) winner = matrix[2][0];
        return winner;
    }

    public static boolean isOwin(String[][] matrix) {
        boolean flag = false;
        return flag;
    }

    public static String[][] printGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert string of the game: >");
        String string = scanner.next();
        System.out.println("---------");
        System.out.println("| " + string.charAt(0) + " " + string.charAt(1) + " " + string.charAt(2) + " |");
        System.out.println("| " + string.charAt(3) + " " + string.charAt(4) + " " + string.charAt(5) + " |");
        System.out.println("| " + string.charAt(6) + " " + string.charAt(7) + " " + string.charAt(8) + " |");
        System.out.println("---------");
        String[][] matrix = createMatrix(string);
        return matrix;
    }

    public static String[][] createMatrix(String string) {
        String[][] matrix = new String[3][3];
        int k = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(string.charAt(k)); k++;
            }
        }
        return matrix;
    }


    public static boolean column1(String[][] matrix) {
        boolean flag = false;
        if (matrix[0][0].equals(matrix[1][0]) && matrix[1][0].equals(matrix[2][0])) flag = true;
        return flag;
    }
    public static boolean column2(String[][] matrix) {
        boolean flag = false;
        if (matrix[0][1].equals(matrix[1][1])  && matrix[1][1].equals(matrix[2][1])) flag = true;
        return flag;
    }
    public static boolean column3(String[][] matrix) {
        boolean flag = false;
        if (matrix[0][2].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][2])) flag = true;
        return flag;
    }
    public static boolean row1(String[][] matrix) {
        boolean flag = false;
        if (matrix[0][0].equals(matrix[0][1]) && matrix[0][1].equals(matrix[0][2])) flag = true;
        return flag;
    }
    public static boolean row2(String[][] matrix) {
        boolean flag = false;
        if (matrix[1][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[1][2])) flag = true;
        return flag;
    }
    public static boolean row3(String[][] matrix) {
        boolean flag = false;
        if (matrix[2][0].equals(matrix[2][1]) && matrix[2][1].equals(matrix[2][2])) flag = true;
        return flag;
    }
    public static boolean diagonal1(String[][] matrix) {
        boolean flag = false;
        if (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])) flag = true;
        return flag;
    }
    public static boolean diagonal2(String[][] matrix) {
        boolean flag = false;
        if (matrix[2][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[0][2])) flag = true;
        return flag;
    }


    public static int countO(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j].equals("o") || matrix[i][j].equals("O"))
                    count++;
        return count;
    }

    public static int countX(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j].equals("x")  || matrix[i][j].equals("X"))
                    count++;
        return count;
    }


}//end class ppal
