package org.shinzu.algol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {
    @Test
    public void returnZero() {
        assertThat(Main.main(new String[]{""})).isEqualTo(0);
    }
}
