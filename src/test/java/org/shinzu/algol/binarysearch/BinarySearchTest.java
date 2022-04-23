package org.shinzu.algol.binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {
    Random random = new Random();

    @Test
    public void callFindAnyForEmptyArrayShouldReturnMinusOne() {
        int result = BinarySearch.findAny(new int[]{}, 1);
        //Assert
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    @Test
    public void callFindAnyForTwoElementsArrayAndSearchedFirstElementShouldFindFirstElement() {
        int firstElement = 1;
        int result = BinarySearch.findAny(new int[]{firstElement, 5}, firstElement);
        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void callFindAnyForTwoElementsArrayAndSearchedSecondElementShouldFindSecondElement() {
        int secondElement = 5;
        int result = BinarySearch.findAny(new int[]{1, secondElement}, secondElement);
        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void callFindAnyForTwoElementsArrayWithoutSearchedValueShouldReturnMinusOne() {
        int result = BinarySearch.findAny(new int[]{1, 5}, 2);
        //Assert
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    @Test
    public void callFindAnyForTwentyFiveElementsArrayAndSearchedValueOfTwentyThreeElementShouldFindTwentyThreeElement() {
        int length = 25;
        int searchedIndex = 23;
        int[] array = ThreadLocalRandom.current().ints(0, 50000).distinct().limit(length).sorted().toArray();

        int result = BinarySearch.findAny(array, array[searchedIndex]);
        //Assert
        assertThat(result).isEqualTo(searchedIndex);
    }

    @Test
    public void callFindAnyForRandomLengthArrayAndSearchedValueOfRandomElementShouldFindTheRandomElement() {
        int length = random.nextInt(100) + 1;
        int searchedIndex = random.nextInt(length - 1);
        int[] array = ThreadLocalRandom.current().ints(0, 50_000).distinct().limit(length).sorted().toArray();

        int result = BinarySearch.findAny(array, array[searchedIndex]);
        //Assert
        assertThat(result).isEqualTo(searchedIndex);
    }

    @Test
    public void callFindAnyForLargeArrayAndSearchedValueOfRandomElementShouldFindTheRandomElement() {
        int length = 100_000;
        int searchedIndex = random.nextInt(length - 1);
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).distinct().limit(length).sorted().toArray();

        int result = BinarySearch.findAny(array, array[searchedIndex]);
        //Assert
        assertThat(result).isEqualTo(searchedIndex);
    }

    @Test
    public void callFindAnyForLargeArrayAndSearchedNotExistValueShouldReturnMinusOne() {
        int length = 100_000;
        int searchedIndex = random.nextInt(length - 1);
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).distinct().limit(length).map(x -> x * 2).sorted().toArray();

        int result = BinarySearch.findAny(array, array[searchedIndex] + 1);
        //Assert
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    @Test
    public void callFindFirstForEmptyArrayShouldReturnMinusOne() {
        int result = BinarySearch.findFirst(new int[]{}, 1);
        //Assert
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    @Test
    public void callFindFirstForTwoElementsArrayAndSearchedFirstElementShouldFindFirstElement() {
        int firstElement = 1;
        int result = BinarySearch.findFirst(new int[]{firstElement, firstElement}, firstElement);
        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void callFindFirstForTwoElementsArrayAndSearchedSecondElementShouldFindSecondElement() {
        int secondElement = 5;
        int result = BinarySearch.findFirst(new int[]{1, secondElement}, secondElement);
        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void callFindFirstForTwoElementsArrayWithoutSearchedValueShouldReturnMinusOne() {
        int result = BinarySearch.findFirst(new int[]{1, 5}, 2);
        //Assert
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    @Test
    public void callFindFirstForTwentyFiveElementsArrayAndSearchedValueOfSomeoneDoubledValuesShouldFindDoubledElement() {
        int length = 25;
        int[] array = ThreadLocalRandom.current().ints(20, 5_000_000).limit(length).map(x -> x * 2).toArray();
        array[0] = array[1] = 2;
        array[2] = 3;
        array[3] = array[4] = array[5] = 10;
        array = Arrays.stream(array).sorted().toArray();

        int result1 = BinarySearch.findFirst(array, 2);
        int result2 = BinarySearch.findFirst(array, 10);
        //Assert
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(3);
    }

    @Test
    public void callFindFirstForRandomLengthArrayAndSearchedValueOfRandomElementShouldDoubledElementsInEnd() {
        int length = random.nextInt(100) + 10;
        int[] array = ThreadLocalRandom.current().ints(0, 50_000).limit(length).sorted().toArray();

        array[length - 1] = array[length - 2] = array[length - 3] = array[length - 4] = array[length - 5] = array[length - 6] = 50_005;
        int result = BinarySearch.findFirst(array, 50_005);
        //Assert
        assertThat(result).isEqualTo(length - 6);
    }

    @Test
    public void callFindFirstForLargeArrayAndSearchedValueOfDoubledElementShouldFindFirstDoubledElement() {
        int length = 100_000;
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).limit(length).sorted().toArray();
        array[length - 1] = array[length - 2] = array[length - 3] = array[length - 4] = array[length - 5] = array[length - 6] = 5_000_001;
        int result = BinarySearch.findFirst(array, 5_000_001);
        //Assert
        assertThat(result).isEqualTo(length - 6);
    }

    @Test
    public void callFindFirstForLargeArrayAndSearchedNotExistValueShouldReturnMinusOne() {
        int length = 100_000;
        int searchedIndex = random.nextInt(length - 1);
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).distinct().limit(length).map(x -> x * 2).sorted().toArray();

        int result = BinarySearch.findFirst(array, array[searchedIndex] + 1);
        //Assert
        assertThat(result).isEqualTo(BinarySearch.NOT_FOUND);
    }

    @Test
    public void callFindAllForEmptyArrayShouldReturnEmptyArray() {
        int[] result = BinarySearch.findAll(new int[]{}, 1);
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callFindAllForTwoElementsWithSameValueArrayAndSearchedFirstElementShouldFindAllElements() {
        int firstElement = 1;
        int[] result = BinarySearch.findAll(new int[]{firstElement, firstElement}, firstElement);
        //Assert
        assertThat(result).containsOnly(0, 1);
    }

    @Test
    public void callFindAllForTwoElementsArrayAndSearchedSecondElementShouldFindSecondElement() {
        int secondElement = 5;
        int[] result = BinarySearch.findAll(new int[]{1, secondElement}, secondElement);
        //Assert
        assertThat(result).containsOnly(1);
    }

    @Test
    public void callFindAllForTwoElementsArrayWithoutSearchedValueShouldReturnEmptyArray() {
        int[] result = BinarySearch.findAll(new int[]{1, 5}, 2);
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callFindAllForTwentyFiveElementsArrayAndSearchedValueOfSomeoneDoubledValuesShouldFindDoubledElements() {
        int length = 25;
        int[] array = ThreadLocalRandom.current().ints(20, 5_000_000).limit(length).map(x -> x * 2).toArray();
        array[0] = array[1] = 2;
        array[2] = 3;
        array[3] = array[4] = array[5] = 10;
        array = Arrays.stream(array).sorted().toArray();

        int[] result1 = BinarySearch.findAll(array, 2);
        int[] result2 = BinarySearch.findAll(array, 10);
        //Assert
        assertThat(result1).containsOnly(0, 1);
        assertThat(result2).containsOnly(3, 4, 5);
    }

    @Test
    public void callFindAllForRandomLengthArrayAndSearchedValueOfRandomElementShouldDoubledElementsInEnd() {
        int length = random.nextInt(100) + 10;
        int[] array = ThreadLocalRandom.current().ints(0, 50_000).limit(length).sorted().toArray();

        array[length - 1] = array[length - 2] = array[length - 3] = array[length - 4] = array[length - 5] = array[length - 6] = 50_005;
        int[] result = BinarySearch.findAll(array, 50_005);
        //Assert
        assertThat(result).containsOnly(length - 6, length - 5, length - 4, length - 3, length - 2, length - 1 );
    }

    @Test
    public void callFindAllForLargeArrayAndSearchedValueOfDoubledElementsShouldFindDoubledElements() {
        int length = 100_000;
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).limit(length).sorted().toArray();
        array[length - 1] = array[length - 2] = array[length - 3] = array[length - 4] = array[length - 5] = array[length - 6] = 5_000_001;
        int[] result = BinarySearch.findAll(array, 5_000_001);
        //Assert
        assertThat(result).containsOnly(length - 6, length - 5, length - 4, length - 3, length - 2, length - 1);
    }

    @Test
    public void callFindAllForLargeArrayAndSearchedNotExistValueShouldReturnEmptyArray() {
        int length = 100_000;
        int searchedIndex = random.nextInt(length - 1);
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).distinct().limit(length).map(x -> x * 2).sorted().toArray();

        int[] result = BinarySearch.findAll(array, array[searchedIndex] + 1);
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callFindAllForLargeArrayWithOneValueAndSearchedValueOfDoubledElementsShouldFindEachElementInTable() {
        int length = 100_000;
        int[] array = new int[length];
        int[] result = BinarySearch.findAll(array, 0);
        //Assert
        assertThat(result).isEqualTo(result);
    }

    @Test
    public void callFindRangeForEmptyArrayShouldReturnEmptyArray() {
        int[] result = BinarySearch.findRange(new int[]{}, 1);
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callFindRangeForTwoElementsWithSameValueArrayAndSearchedFirstElementShouldFindAllElements() {
        int firstElement = 1;
        int[] result = BinarySearch.findRange(new int[]{firstElement, firstElement}, firstElement);
        //Assert
        assertThat(result).containsOnly(0, 1);
    }

    @Test
    public void callFindRangeForTwoElementsArrayAndSearchedSecondElementShouldFindSecondElement() {
        int secondElement = 5;
        int[] result = BinarySearch.findRange(new int[]{1, secondElement}, secondElement);
        //Assert
        assertThat(result).containsOnly(1);
    }

    @Test
    public void callFindRangeForTwoElementsArrayWithoutSearchedValueShouldReturnEmptyArray() {
        int[] result = BinarySearch.findRange(new int[]{1, 5}, 2);
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callFindRangeForTwentyFiveElementsArrayAndSearchedValueOfSomeoneDoubledValuesShouldFindDoubledElements() {
        int length = 25;
        int[] array = ThreadLocalRandom.current().ints(20, 5_000_000).limit(length).map(x -> x * 2).toArray();
        array[0] = array[1] = 2;
        array[2] = 3;
        array[3] = array[4] = array[5] = 10;
        array = Arrays.stream(array).sorted().toArray();

        int[] result1 = BinarySearch.findRange(array, 2);
        int[] result2 = BinarySearch.findRange(array, 10);
        //Assert
        assertThat(result1).containsOnly(0, 1);
        assertThat(result2).containsOnly(3, 5);
    }

    @Test
    public void callFindRangeForRandomLengthArrayAndSearchedValueOfRandomElementShouldDoubledElementsInEnd() {
        int length = random.nextInt(100) + 10;
        int[] array = ThreadLocalRandom.current().ints(0, 50_000).limit(length).sorted().toArray();

        array[length - 1] = array[length - 2] = array[length - 3] = array[length - 4] = array[length - 5] = array[length - 6] = 50_005;
        int[] result = BinarySearch.findRange(array, 50_005);
        //Assert
        assertThat(result).containsOnly(length - 6, length - 1 );
    }

    @Test
    public void callFindRangeForLargeArrayAndSearchedValueOfDoubledElementsShouldFindDoubledElements() {
        int length = 100_000;
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).limit(length).sorted().toArray();
        array[length - 1] = array[length - 2] = array[length - 3] = array[length - 4] = array[length - 5] = array[length - 6] = 5_000_001;
        int[] result = BinarySearch.findRange(array, 5_000_001);
        //Assert
        assertThat(result).containsOnly(length - 6, length - 1);
    }

    @Test
    public void callFindRangeForLargeArrayAndSearchedNotExistValueShouldReturnEmptyArray() {
        int length = 100_000;
        int searchedIndex = random.nextInt(length - 1);
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).distinct().limit(length).map(x -> x * 2).sorted().toArray();

        int[] result = BinarySearch.findAll(array, array[searchedIndex] + 1);
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callFindRangeForLargeArrayWithOneValueAndSearchedValueOfDoubledElementsShouldFindEachElementInTable() {
        int length = 100_000;
        int[] array = new int[length];
        int[] result = BinarySearch.findRange(array, 0);
        //Assert
        assertThat(result).containsOnly(0, length-1);
    }
}
