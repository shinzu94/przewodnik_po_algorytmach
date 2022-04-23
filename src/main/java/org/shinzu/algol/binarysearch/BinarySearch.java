package org.shinzu.algol.binarysearch;

public class BinarySearch {
    public static final int NOT_FOUND = -1;

    public static int[] findRange(int[] array, int search) {
        int any = findAny(array, search);
        if (any == NOT_FOUND) {
            return new int[]{};
        } else {
            int begin = findFirstIndex(array, search, any);
            int end = findEndIndex(array, search, any);
            return new int[]{begin, end};
        }
    }

    public static int[] findAll(int[] array, int search) {
        int any = findAny(array, search);
        if (any == NOT_FOUND) {
            return new int[]{};
        } else {
            int begin = findFirstIndex(array, search, any);
            int end = findEndIndex(array, search, any);
            int[] result = new int[end - begin + 1];
            for (int i = begin, j = 0; i <= end; i++, j++) {
                result[j] = i;
            }
            return result;
        }
    }

    public static int findFirst(int[] array, int search) {
        int any = BinarySearch.findAny(array, search);
        return findFirstIndex(array, search, any);
    }

    private static int findFirstIndex(int[] array, int search, int any) {
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
                    indexDiff = (indexDiff * 2 < lastCorrectIndex) ? indexDiff * 2 : lastCorrectIndex;
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

    private static int findEndIndex(int[] array, int search, int any) {
        int indexDiff = 1;
        int lastCorrectIndex = any;
        int lastCorrectIndexDiff = 0;
        int maxIndex = array.length - 1;
        if (any != NOT_FOUND) {
            do {
                if (lastCorrectIndex == maxIndex) {
                    break;
                } else if (search == array[lastCorrectIndex + indexDiff]) {
                    lastCorrectIndex += indexDiff;
                    lastCorrectIndexDiff = indexDiff;
                    indexDiff = (indexDiff * 2 < (maxIndex - lastCorrectIndex)) ? indexDiff * 2 : maxIndex - lastCorrectIndex;
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
        int lastIndex = NOT_FOUND;
        int result = lastIndex;
        int length = array.length;

        if (length > 0) {
            int index = length / 2;
            int begin = 0;
            int end = length - 1;
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
