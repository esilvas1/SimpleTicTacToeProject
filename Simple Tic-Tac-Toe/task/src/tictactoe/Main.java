package tictactoe;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String string = "         ";
        String[][] matrix = printGame(string);
        int index = 0;
        while (index < 9) {
            System.out.print("Enter coordinates (x y):/> ");
            string = scanner.nextLine();
            string = validateToNumbers(string);
            string = validateToCoordiantes(string);
            string = cellIsOccupied(string,matrix);
            string = modifyMatrix(string,matrix,index);
            matrix = printGame(string);
            index++;

            if (isThereWinner(matrix)) {System.out.println(winner(matrix) + " wins"); return;}
            else if (withSpace(matrix)) ;
            else if (isDraw(matrix)) {System.out.println("Draw"); return;}
        }


    }

    public static String modifyMatrix(String string, String[][] matrix, int index) {
        StringBuilder sb = new StringBuilder();
        int x = Integer.valueOf(String.valueOf(string.charAt(0))) - 1;
        int y = Integer.valueOf(String.valueOf(string.charAt(2))) - 1;
        if (index % 2 == 0) matrix[x][y] = "X";
        else matrix[x][y] = "O";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
        }
        string = sb.toString();
        return string;
    }
    public static String validateToNumbers(String string) {
        String empty = " ";
        Scanner scanner = new Scanner(System.in);
        while (string.length() != 3
                || !Character.isDigit(string.charAt(0))
                || !empty.equals(String.valueOf(string.charAt(1)))
                || !Character.isDigit(string.charAt(2))) {
            System.out.println("You should enter numbers!");
            string = scanner.nextLine();
        }
        return string;
    }

    public static String validateToCoordiantes(String string) {
        Scanner scanner = new Scanner(System.in);
        while (Integer.valueOf(String.valueOf(string.charAt(0))) <= 0
                || Integer.valueOf(String.valueOf(string.charAt(0))) > 3
                || Integer.valueOf(String.valueOf(string.charAt(2))) <= 0
                || Integer.valueOf(String.valueOf(string.charAt(2))) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            string = scanner.nextLine();
            string = validateToNumbers(string);
        }
        return string;
    }

    public static String cellIsOccupied(String string, String[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.valueOf(String.valueOf(string.charAt(0))) - 1;
        int y = Integer.valueOf(String.valueOf(string.charAt(2))) - 1;
        while (!(matrix[x][y].equals(" "))) {
            System.out.println("This cell is occupied! Choose another one!");
            //System.out.print("> ");
            string = scanner.nextLine();
            string = validateToNumbers(string);
            string = validateToCoordiantes(string);
            x = Integer.valueOf(String.valueOf(string.charAt(0))) - 1;
            y = Integer.valueOf(String.valueOf(string.charAt(2))) - 1;
        }
        return string;
    }


    public static boolean withSpace(String[][] matrix) {
        boolean flag = false;
        final String space = " ";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (space.equals(matrix[i][j])) {
                    flag = true;
                }
            }
        }
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

    public static String[][] printGame(String string) {
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
        String space = " ";
        if (matrix[0][0].equals(matrix[1][0]) && matrix[1][0].equals(matrix[2][0]) && !matrix[0][0].equals(space)) flag = true;
        return flag;
    }
    public static boolean column2(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[0][1].equals(matrix[1][1])  && matrix[1][1].equals(matrix[2][1]) && !matrix[0][1].equals(space)) flag = true;
        return flag;
    }
    public static boolean column3(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[0][2].equals(matrix[1][2]) && matrix[1][2].equals(matrix[2][2]) && !matrix[0][2].equals(space)) flag = true;
        return flag;
    }
    public static boolean row1(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[0][0].equals(matrix[0][1]) && matrix[0][1].equals(matrix[0][2]) && !matrix[0][0].equals(space)) flag = true;
        return flag;
    }
    public static boolean row2(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[1][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[1][2]) && !matrix[1][0].equals(space)) flag = true;
        return flag;
    }
    public static boolean row3(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[2][0].equals(matrix[2][1]) && matrix[2][1].equals(matrix[2][2]) && !matrix[2][0].equals(space)) flag = true;
        return flag;
    }
    public static boolean diagonal1(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2]) && !matrix[0][0].equals(space)) flag = true;
        return flag;
    }
    public static boolean diagonal2(String[][] matrix) {
        boolean flag = false;
        String space = " ";
        if (matrix[2][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[0][2]) && !matrix[2][0].equals(space)) flag = true;
        return flag;
    }

    public static boolean irregularCount(String[][] matrix) {
        boolean flag = false;
        int countO = 0;
        int countX = 0;
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j].equals("o") || matrix[i][j].equals("O"))
                    countO++;

        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j].equals("x")  || matrix[i][j].equals("X"))
                    countX++;

        if ((Integer.max(countO,countX) - Integer.min(countO, countX)) >= 2 )
            flag = true;

        return flag;
    }


}//end class ppal
