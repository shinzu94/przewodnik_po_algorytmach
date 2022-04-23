package org.shinzu.algol.binarysearch;

public class BinarySearch {
    public static int findAny(int[] array, int search) {
        int result = -1;
        int length = array.length;

        if (length > 0) {
            int index = length / 2;
            int begin = 0;
            int end = length - 1;
            int lastIndex = -1;
            while (result == -1) {
                if (array[index] > search) {
                    end = index;
                    lastIndex = index;
                    index = index - ((end - begin + 1) / 2);
                    if (index == lastIndex) break;
                } else if (array[index] < search) {
                    begin = index;
                    lastIndex = index;
                    index = index + ((end - begin) / 2);
                    if (index == lastIndex) break;
                } else {
                    result = index;
                }
            }
        }
        return result;
    }
}
