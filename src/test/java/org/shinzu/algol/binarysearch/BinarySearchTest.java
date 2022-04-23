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

        array = Arrays.stream(array).sorted().toArray();
        int result = BinarySearch.findAny(array, array[searchedIndex]);
        //Assert
        assertThat(result).isEqualTo(searchedIndex);
    }

    @Test
    public void callFindAnyForRandomLengthArrayAndSearchedValueOfRandomElementShouldFindTheRandomElement() {
        int length = random.nextInt(100) + 1;
        int searchedIndex = random.nextInt(length - 1);

        int[] array = ThreadLocalRandom.current().ints(0, 50000).distinct().limit(length).sorted().toArray();

        array = Arrays.stream(array).sorted().toArray();
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
}
