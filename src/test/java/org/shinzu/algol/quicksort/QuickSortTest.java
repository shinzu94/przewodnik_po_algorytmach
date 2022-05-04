package org.shinzu.algol.quicksort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    @Test
    public void callSortForEmptyArrayShouldReturnEmptyArray() {
        int[] result = QuickSort.sort(new int[]{});
        //Assert
        assertThat(result).isEmpty();
    }

    @Test
    public void callSortForNotSortedArrayWithNaturalNumbersShouldReturnSortedArray() {
        int[] result = QuickSort.sort(new int[]{7, 8, 0, 1, 2, 3, 500});
        //Assert
        assertThat(result).containsExactly(0, 1, 2, 3, 7, 8, 500);
        assertThat(result).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    public void callSortForNotSortedArrayWithIntegersNumbersShouldReturnSortedArray() {
        int[] result = QuickSort.sort(new int[]{7, 8, 0, 1, 2, 3, 500, -3, -65, 4, -2});
        //Assert
        assertThat(result).containsExactly(-65, -3, -2, 0, 1, 2, 3, 4, 7, 8, 500);
        assertThat(result).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    public void callSortForNotSortedArrayWithDoubledIntegersNumbersShouldReturnSortedArray() {
        int[] result = QuickSort.sort(new int[]{7, 8, 0, 1, 1, 2, 3, 500, -3, -65, 4, -2, -65});
        //Assert
        assertThat(result).containsExactly(-65, -65, -3, -2, 0, 1, 1, 2, 3, 4, 7, 8, 500);
        assertThat(result).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    public void callSortForArrayWithRandomNumbersShouldReturnSortedArrayLikeExistImplementation() {
        int length = 10_000;
        int[] array = ThreadLocalRandom.current().ints(-5_000_000, 5_000_000).limit(length).toArray();
        int[] result = QuickSort.sort(array);

        //Assert
        assertThat(result[0]).isLessThanOrEqualTo(result[length - 1]);
        assertThat(result).isSortedAccordingTo(Comparator.naturalOrder());
        assertThat(result).isEqualTo(Arrays.stream(array).sorted().toArray());
    }
}
