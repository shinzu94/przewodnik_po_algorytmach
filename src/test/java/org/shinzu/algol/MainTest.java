package org.shinzu.algol;

import com.fitbur.testify.junit.UnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(UnitTest.class)
public class MainTest {
    @Test
    public void returnZero() {
        assertThat(Main.main(new String[]{""})).isEqualTo(0);
    }
}
