package org.example.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка числа на четность")
class EvenTest {
    private Even even;

    @BeforeEach
    public void init() {
        even = new Even();
    }

    @ParameterizedTest
    @MethodSource("provideValues")
    void isEven1(int value, boolean expected) {
        assertEquals(expected, even.isEven1(value));
    }

    @ParameterizedTest
    @MethodSource("provideValues")
    void isEven2(int value, boolean expected) {
        assertEquals(expected, even.isEven2(value));
    }

    private static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(2, true),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(221, false),
                Arguments.of(134, true)
        );
    }
}