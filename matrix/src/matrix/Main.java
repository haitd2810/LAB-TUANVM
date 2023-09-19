/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrix1 = null;
        int[][] matrix2 = null;
        int[][] result;
        int choice;
        do {
            //step 1: Display menu
            menu();
            //step 2: select an choice from option of menu
            choice = getChoice("Your Choice: ", 0, 5);
            //step 3: Display option from choice of user
            switch (choice) {
                //step 3.1: addtion matrix
                case 1:
                    //create matrix 1
                    matrix1 = InputMatrix1();
                    //create matrix 2
                    matrix2 = InputMatrix2(matrix1, 0);
                    //addtion 2 matrix 1 and 2
                    result = additionMatrix(matrix1, matrix2);
                    //display result
                    displayResult(matrix1, matrix2, result, "+");
                    break;
                //step 3.2: subtraction matrix
                case 2:
                    //create matrix 1
                    matrix1 = InputMatrix1();
                    //create matrix 2
                    matrix2 = InputMatrix2(matrix1, 0);
                    //subtraction 2 matrix 1 and 2
                    result = subtractionMatrix(matrix1, matrix2);
                    //display result
                    displayResult(matrix1, matrix2, result, "-");
                    break;
                //step 3.3: Multiplication matrix
                case 3:
                    //create matrix 1
                    matrix1 = InputMatrix1();
                    //create matrix 2
                    matrix2 = InputMatrix2(matrix1, 1);
                    //subtraction 2 matrix 1 and 2
                    result = multiplicationMatrix(matrix1, matrix2);
                    //display result
                    displayResult(matrix1, matrix2, result, "*");
                    break;
                //step 3.4: quit
                case 4:
                    break;

            }
        } while (choice != 4);

    }

    private static void menu() {
        System.out.println("=======Calculator program========");
        System.out.println("1. addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    private static int getChoice(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int Choice;
        //loop to request enter input to when input is ok
        while (true) {
            try {
                System.out.print(msg);
                Choice = Integer.parseInt(sc.nextLine());
                //check input is ok or not
                if (Choice > min && Choice < max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {

            }
        }
        return Choice;
    }

    private static int InputNum(String msg, String err) {
        Scanner sc = new Scanner(System.in);
        int Number;
        //loop to request enter input to when input is ok
        while (true) {
            try {
                System.out.print(msg);
                Number = Integer.parseInt(sc.nextLine());
                //check number input is positive number or not
                if(Number >=0)return Number;
                throw new Exception();
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    private static int[][] InputMatrix1() {
        Scanner sc = new Scanner(System.in);
        int row = InputNum("Enter row of matrix 1: ", "");
        int column = InputNum("Enter column of matrix 1: ", "");
        int[][] matrix1 = new int[row][column];
        //access all element in row to add value to row matrix
        for (int i = 0; i < row; i++) {
            //access all element in column to add value to column matrix
            for (int j = 0; j < column; j++) {
                matrix1[i][j] = InputNum(("Enter Matrix1[" + (i+1) + "]" + "[" + (j+1) + "]:"), "Values of matrix must be the number");
            }
        }
        return matrix1;
    }

    private static int[][] InputMatrix2(int[][] matrix1, int opt) {
        Scanner sc = new Scanner(System.in);
        int row;
        int column;
        /*check opt to check row and column
        0: check to add and sub
        1: check to multiple
        */
        if (opt == 0) {
            //loop again to check row is ok or not
            do {
                row = InputNum("Enter row of matrix 2: ", "");
                //compare row of matrix 2 is equal matrix 1 or not
                if (row != matrix1.length) {
                    System.out.println("row of matrix 2 have to be equal row of matrix 1");
                }
            } while (row != matrix1.length);
            //loop again check column of matrix is ok or not
            do {
                column = InputNum("Enter column of matrix 2: ", "");
                //compare column is equal column of matrix 1 or not
                if (column != matrix1[0].length) {
                    System.out.println("column of matrix 2 have to be equal column of matrix 1");
                }
            } while (column != matrix1[0].length);
        } else {
            //check row of matrix 2 is valid or not
            do {
                row = InputNum("Enter row of matrix 2: ", "");
                //compare row of matrix 2 is equal matrix 1 or not
                if (row != matrix1[0].length) {
                    System.out.println("row of matrix 2 have to be equal column of matrix 1");
                }
            } while (row != matrix1[0].length);
            column = InputNum("Enter column of matrix 2: ", "");
        }
        int[][] matrix2 = new int[row][column];
        //access all element in row to add value to row matrix
        for (int i = 0; i < row; i++) {
            //access all element in column to add value to column matrix
            for (int j = 0; j < column; j++) {
                matrix2[i][j] = InputNum(("Enter Matrix2[" + (i+1) + "]" + "[" + (j+1) + "]:"), "Values of matrix must be the number");
            }
        }
        return matrix2;
    }

    private static void displayMatrix(int[][] matrix) {
        //access all element in row of matrix to display
        for (int i = 0; i < matrix.length; i++) {
            //access all element in column of matrix to display
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    private static void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, String cal) {
        displayMatrix(matrix1);
        System.out.println(cal);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    private static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //access all element in row of 2 matrix to addition matrix by row
        for (int i = 0; i < matrix1.length; i++) {
            //access all element in column of 2 matrix to addtion matrix by column
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    private static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        //access all element in row of 2 matrix to addition matrix by row
        for (int i = 0; i < matrix1.length; i++) {
            //access all element in column of 2 matrix to addtion matrix by column
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    private static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        //access all elements in row of matrix1
        for (int i = 0; i < matrix1.length; i++) {
            //access all elements in column of matrix2
            for (int j = 0; j < matrix2[0].length; j++) {
                //access each element in row of matrix2
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}