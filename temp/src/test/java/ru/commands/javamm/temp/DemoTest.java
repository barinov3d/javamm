package ru.commands.javamm.temp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.quality.Strictness.LENIENT;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class DemoTest {

    @Mock
    private Demo demo;

    private final List<Integer> list = new ArrayList<>(Arrays.asList(6, 2, 1, 1, 1, 1, 4, 5));

    @Test
    void should_find_value() {
        demo = new Demo();
        Integer exactValue = demo.findExactValue(list, list.get(0));
        assertEquals(list.get(0), exactValue);
    }

    @Test
    void should_return_minus_one_if_no_values() {
        demo = new Demo();
        Integer exactValue = demo.findExactValue(list, 99);
        assertEquals(-1, exactValue);
    }

}