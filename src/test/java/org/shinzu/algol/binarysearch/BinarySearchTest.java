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
        assertThat(result).isEqualTo(-1);
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
        assertThat(result).isEqualTo(-1);
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
        int[] array = ThreadLocalRandom.current().ints(0, 50000).distinct().limit(length).sorted().toArray();

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
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void callFindFirstForEmptyArrayShouldReturnMinusOne() {
        int result = BinarySearch.findFirst(new int[]{}, 1);
        //Assert
        assertThat(result).isEqualTo(-1);
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
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void callFindFirstForTwentyFiveElementsArrayAndSearchedValueOfSomeoneDoubledValuesShouldFindTwentyThreeElement() {
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
    public void callFindFirstForLargeArrayAndSearchedValueOfRandomElementShouldFindTheRandomElement() {
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
        assertThat(result).isEqualTo(-1);
    }
}
