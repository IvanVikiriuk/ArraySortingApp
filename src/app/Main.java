package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[15];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println("The initial view of the array : " + Arrays.toString(array));

        insertionSort(array);

        System.out.println("Sorted array : " + Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search for : ");
        int target = scanner.nextInt();
        int index = binarySearch(array, target);
        if (index >= 0) {
            System.out.println("Number Index " + target + " in a sorted array: " + index);
        } else {
            System.out.println("Number " + target + " not it the array.");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


