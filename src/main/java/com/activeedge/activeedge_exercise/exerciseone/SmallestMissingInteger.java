package com.activeedge.activeedge_exercise.exerciseone;

public class SmallestMissingInteger {

    public static int findSmallestMissing(int[] array) {
        int n = array.length;

        // Step 1: Mark elements present in array
        for (int i = 0; i < n; i++) {
            // Ignore non-positive integers and numbers greater than n
            while (array[i] > 0 && array[i] <= n && array[array[i] - 1] != array[i]) {
                // Swap array[array[i]-1] and array[i]
                int temp = array[array[i] - 1];
                array[array[i] - 1] = array[i];
                array[i] = temp;
            }
        }

        // Step 2: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all integers from 1 to n are present, return n+1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println("Smallest missing integer in array1: " + findSmallestMissing(array1)); // Output: 5
        System.out.println("Smallest missing integer in array2: " + findSmallestMissing(array2)); // Output: 1
    }
}

