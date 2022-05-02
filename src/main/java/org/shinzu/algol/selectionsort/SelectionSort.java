package org.shinzu.algol.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static int[] sort(int[] array) {
        int[] cloneArray = Arrays.copyOf(array, array.length);
        int[] newArray = new int[array.length];
        int length = cloneArray.length;
        for (int i = 0; length > 0; i++, length--) {
            int indexOfSmallest = findIndexOfSmallest(Arrays.copyOf(cloneArray, length));
            newArray[i] = cloneArray[indexOfSmallest];
            cloneArray[indexOfSmallest] = cloneArray[length - 1];
        }

        return newArray;
    }

    private static int findIndexOfSmallest(int[] array) {
        int indexOfSmallest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[indexOfSmallest]) {
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }
}