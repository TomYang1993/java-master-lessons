package yxy.tom.yang;

import java.util.Scanner;

public class ArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        sortArrays(myIntegers);
        printArrays(myIntegers);
        System.out.println(findMin(myIntegers));
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i=0; i<values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArrays(int[] array) {
        for(int i=0; i< array.length; i++) {
            System.out.println("the " + i + "th item is "+ array[i]);
        }
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for(int i=0; i< array.length; i++) {
            sum += array[i];
        }
        return (double) sum / (double)array.length;
    }

    public static void sortArrays(int[] array) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;

            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                  min= array[i];
                }
            }
            return min;
    }

}
