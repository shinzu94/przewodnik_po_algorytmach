package org.shinzu.algol.binarysearch;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {
    @Test
    public void callFindForEmptyArrayShouldReturnMinusOne() {
        long result = BinarySearch.find(new int[]{}, 1);
        //Assert
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void callFindForTwoElementsArrayAndSearchedFirstElementShouldFindFirstElement() {
        int firstElement = 1;
        long result = BinarySearch.find(new int[]{firstElement, 5}, firstElement);
        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void callFindForTwoElementsArrayAndSearchedSecondElementShouldFindSecondElement() {
        int secondElement = 5;
        long result = BinarySearch.find(new int[]{1, secondElement}, secondElement);
        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void callFindForTwoElementsArrayWithoutSearchedValueShouldReturnMinusOne() {
        long result = BinarySearch.find(new int[]{1, 5}, 2);
        //Assert
        assertThat(result).isEqualTo(-1);
    }
}
