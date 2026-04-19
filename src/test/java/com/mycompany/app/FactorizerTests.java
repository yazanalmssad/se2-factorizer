package com.mycompany.app;

import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FactorizerTests {

    private final Factorizer factorizer = Factorizer.getInstance();

    @Test
    void test_factorize_n_is_0() {
        assertTrue(factorizer.factorize(0L).isEmpty());
    }

    @Test
    void test_factorize_n_is_1() {
        assertTrue(factorizer.factorize(1L).isEmpty());
    }

    @Test
    void test_factorize_n_is_2() {
        assertIterableEquals(List.of(2L), factorizer.factorize(2L));
    }

    @Test
    void test_factorize_n_is_3() {
        assertIterableEquals(List.of(3L), factorizer.factorize(3L));
    }

    @Test
    void test_factorize_n_is_4() {
        assertIterableEquals(List.of(2L, 2L), factorizer.factorize(4L));
    }

    @Test
    void test_factorize_n_is_27() {
        assertIterableEquals(List.of(3L, 3L, 3L), factorizer.factorize(27L));
    }

    @Test
    void test_factorize_n_is_65536() {
        assertIterableEquals(
            List.of(2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L),
            factorizer.factorize(65536L)
        );
    }

    @Test
    void test_factorize_n_is_10952347() {
        assertIterableEquals(List.of(7L, 23L, 59L, 1153L), factorizer.factorize(10952347L));
    }

    @Test
    void test_factorize_n_is_100000039() {
        assertIterableEquals(List.of(100000039L), factorizer.factorize(100000039L));
    }

    @Test
    void test_factorize_negative_argument() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> factorizer.factorize(-1L)
        );
        assertTrue(ex.getMessage().contains("illegal negative parameter"));
    }

@Test
void test_factorize_large_corner_cases() {
    assertTrue(factorizer.factorize(2147483646L).size() > 0);
    assertIterableEquals(List.of(2147483647L), factorizer.factorize(2147483647L));
}

@Test
void test_factorize_more_negative_arguments() {
    IllegalArgumentException ex1 = assertThrows(
        IllegalArgumentException.class,
        () -> factorizer.factorize(-10L)
    );
    assertTrue(ex1.getMessage().contains("illegal negative parameter"));

    IllegalArgumentException ex2 = assertThrows(
        IllegalArgumentException.class,
        () -> factorizer.factorize(-2147483648L)
    );
    assertTrue(ex2.getMessage().contains("illegal negative parameter"));
}
@Test
void test_factorize_n_is_12_ignore_order() {
    List<Long> expected = List.of(3L, 2L, 2L);
    List<Long> actual = factorizer.factorize(12L);
    assertThat(expected, Matchers.containsInAnyOrder(actual.toArray()));
}
}