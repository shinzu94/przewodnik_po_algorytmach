package org.shinzu.algol.binarysearch;

public class BinarySearch {
    public static int find(int[] array, int search) {
        int result = -1;
        int length = array.length;

        if (length > 0) {
            int lengthDiff = length/2;
            int index = lengthDiff;
            int lastLengthDiff = -1;
            while (result == -1) {
                if (array[index] > search) {
                    index = index - lengthDiff;
                    lengthDiff = lengthDiff/2;
                    if (lengthDiff == 0 && lastLengthDiff == lengthDiff) {
                        break;
                    }
                    lastLengthDiff = lengthDiff;
                } else if (array[index] < search) {
                    index = index - lengthDiff;
                    lengthDiff = lengthDiff/2;
                    if (lengthDiff == 0 && lastLengthDiff == lengthDiff) {
                        break;
                    }
                    lastLengthDiff = lengthDiff;
                } else {
                    result = index;
                }
            }
        }
        return result;
    }
}
