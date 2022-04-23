package org.shinzu.algol.binarysearch;

import com.fitbur.testify.junit.UnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(UnitTest.class)
public class BinarySearchTest {
    @Test
    public void searchInTwoElementArray() {
        long result = BinarySearch.find(new int[]{5, 1}, 1);
        //Assert
        assertThat(result).isEqualTo(1);
    }
}
