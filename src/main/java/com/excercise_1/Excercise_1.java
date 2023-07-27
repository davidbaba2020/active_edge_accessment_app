package com.excercise_1;

import java.util.Arrays;

public class Excercise_1 {
    public static void main(String[] args) {
        System.out.println("Tested");
//        Sample Examples
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println(findSmallestNonOccurringInteger(array1));
        System.out.println(findSmallestNonOccurringInteger(array2));
    }



    public static int findSmallestNonOccurringInteger(int[] array) {
        int[] positiveArray = Arrays.stream(array)
                .filter(num -> num > 0)
                .distinct()
                .sorted()
                .toArray();

        int smallestNonOccurringInteger = 1;
        for (int num : positiveArray) {
            if (num == smallestNonOccurringInteger) {
                smallestNonOccurringInteger++;
            } else if (num > smallestNonOccurringInteger) {
                return smallestNonOccurringInteger;
            }
        }

        return smallestNonOccurringInteger;
    }
}

//com.active_edge_accessment_app