/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Duy Hai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //step 1: Enter positive number is size array
        int PosNum = InputNumber("Enter Number of array:");
        //step 2: Enter Search Number
        int SearchNum = InputNumber("Enter Search value:");
        //step 3: Generate an array
//        int[] arr = GenerateArr(PosNum);
        int[] arr = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
        //step 4: sort array by bubble sort
        BubbleSort(arr);
        //step 5: display array sorted
        DisplayArr(arr);
        //step 6: find index of search number
        int index = BinarySearch(arr, SearchNum, 0, arr.length - 1, 1);
        //step 7: display index of search number
        DisplayIndex(SearchNum, index);
    }

    private static int InputNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        int Number;
        //loop to request enter input to when input is ok
        while (true) {
            try {
                System.out.println(msg);
                Number = Integer.parseInt(sc.nextLine());
                //check input is ok or not
                if (Number > 0) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {

            }
        }
        return Number;
    }

    private static int[] GenerateArr(int PosNum) {
        int[] arr = new int[PosNum];
        Random rand = new Random();
        //add random element to array
        for (int i = 0; i < PosNum; i++) {
            arr[i] = rand.nextInt(PosNum);
        }
        return arr;
    }

    private static void BubbleSort(int[] arr) {
        /*loop with number of time is equal size array to sort all 
        element of array, each loop sort 1 element*/
        for (int i = 0; i < arr.length; i++) {
            /*loop from first element to the last unsorted element of array
            to compare and sort 1 pair element*/
            for (int j = 0; j < arr.length - i - 1; j++) {
                //compare 1 pair element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void DisplayArr(int[] arr) {
        System.out.print("The array: ");
        System.out.print("[");
        //access all elements of array to display
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            //check index i to display with format [element, element,..]
            if (i < arr.length - 1) {
                System.out.print(", ");
            } else if (i == arr.length - 1) {
                System.out.println("]");
            }
        }
    }

    private static int BinarySearch(int[] arr, int SearchNum, int left, int right, int count) {
        int mid;
        //loop again to when find index of search value
        while (true) {
            //check Search range is exist or not
            if (left <= right) {
                mid = (right + left) / 2;
                //compare value of index mid is Search number or not
                if (arr[mid] == SearchNum) {
                    System.out.print("Step " + count + " (middle elemet is " + arr[mid] + "=" + SearchNum + "):");
                    displayArr(arr, left, right);
                    System.out.println();
                    return mid;
                } else if (SearchNum > arr[mid]) {
                    System.out.print("Step " + count + " (middle elemet is " + arr[mid] + "<" + SearchNum + "):");
                    displayArr(arr, left, right);
                    System.out.println();
                    left = mid + 1;
                    count++;
                } else if (SearchNum < arr[mid]) {
                    System.out.print("Step " + count + " (middle elemet is " + arr[mid] + ">" + SearchNum + "):");
                    displayArr(arr, left, right);
                    System.out.println();
                    right = mid - 1;
                    count++;
                }
            } else {
                System.out.println("Step " + count + "(searched value is absent):");
                return -1;
            }
        }
    }

    private static void DisplayIndex(int SearchNum, int index) {
        //check index of search value is valid in array or not
        if (index >= 0) {
            System.out.println("found " + SearchNum + " at index: " + index);
        } else if (index < 0) {
            System.out.println("not found");
        }
    }

    private static void displayArr(int[] arr, int min, int max) {
        for (int i = min; i <= max; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
