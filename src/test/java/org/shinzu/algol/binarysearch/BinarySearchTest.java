package org.shinzu.algol.binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {
    Random random = new Random();

    @Test
    public void callFindForEmptyArrayShouldReturnMinusOne() {
        int result = BinarySearch.find(new int[]{}, 1);
        //Assert
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void callFindForTwoElementsArrayAndSearchedFirstElementShouldFindFirstElement() {
        int firstElement = 1;
        int result = BinarySearch.find(new int[]{firstElement, 5}, firstElement);
        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void callFindForTwoElementsArrayAndSearchedSecondElementShouldFindSecondElement() {
        int secondElement = 5;
        int result = BinarySearch.find(new int[]{1, secondElement}, secondElement);
        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void callFindForTwoElementsArrayWithoutSearchedValueShouldReturnMinusOne() {
        int result = BinarySearch.find(new int[]{1, 5}, 2);
        //Assert
        assertThat(result).isEqualTo(-1);
    }


    @Test
    public void callFindForTwentyFiveElementsArrayAndSearchedValueOfTwentyThreeElementShouldFindSecondElement() {
        int length = 25;
        int searchedIndex = 23;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(50000);
        }
        array = Arrays.stream(array).sorted().toArray();
        int result = BinarySearch.find(array, array[searchedIndex]);
        //Assert
        assertThat(result).isEqualTo(1);
    }
}
