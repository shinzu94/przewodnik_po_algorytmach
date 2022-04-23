package org.shinzu.algol.binarysearch;

public class BinarySearch {
    public static final int NOT_FOUND = -1;

    public static int[] findAll(int[] array, int search) {
        return new int[]{BinarySearch.findFirst(array, search)};
    }

    public static int findFirst(int[] array, int search) {
        int any = BinarySearch.findAny(array, search);
        int indexDiff = 1;
        int lastCorrectIndex = any;
        int lastCorrectIndexDiff = 0;
        if (any != NOT_FOUND) {
            do {
                if (lastCorrectIndex == 0) {
                    break;
                } else if (search == array[lastCorrectIndex - indexDiff]) {
                    lastCorrectIndex -= indexDiff;
                    lastCorrectIndexDiff = indexDiff;
                    indexDiff = (indexDiff * 2 < lastCorrectIndex) ? indexDiff * 2 : lastCorrectIndexDiff;
                } else if (lastCorrectIndexDiff == 0) {
                    break;
                } else {
                    lastCorrectIndexDiff = 0;
                    indexDiff = 1;
                }
            } while (true);
        }
        return lastCorrectIndex;
    }

    public static int findAny(int[] array, int search) {
        int result = NOT_FOUND;
        int length = array.length;

        if (length > 0) {
            int index = length / 2;
            int begin = 0;
            int end = length - 1;
            int lastIndex = NOT_FOUND;
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
