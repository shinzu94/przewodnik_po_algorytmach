package org.shinzu.algol.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static int[] sort(int[] array) {
        if (array.length > 1) {
            int[] part1 = new int[array.length];
            int[] part2 = new int[array.length];
            int[] result = new int[array.length];
            int pivotIndex = array.length / 2;
            int pivotValue = array[pivotIndex];
            int leftIndex = 0;
            int rightIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (i != pivotIndex) {
                    if (array[i] <= pivotValue) {
                        part1[leftIndex] = array[i];
                        leftIndex++;
                    } else {
                        part2[rightIndex] = array[i];
                        rightIndex++;
                    }
                }
            }
            part1 = sort(Arrays.copyOfRange(part1, 0, leftIndex));
            part2 = sort(Arrays.copyOfRange(part2, 0, rightIndex));

            System.arraycopy(part1, 0, result, 0, leftIndex);
            result[leftIndex] = pivotValue;
            System.arraycopy(part2, 0, result, leftIndex + 1, rightIndex);

            return result;
        } else {
            return array;
        }
    }
}
