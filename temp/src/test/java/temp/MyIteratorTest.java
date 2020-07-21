package temp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import ru.commands.javamm.temp.MyIterator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.quality.Strictness.LENIENT;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class MyIteratorTest {

    @Mock
    private MyIterator myIterator;

    private List<Integer> list;

    @Test
    @Order(1)
    void Should_return_the_valid_iteration_values() {
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        myIterator = new MyIterator(list);
        assertEquals(2, myIterator.next());
        assertEquals(4, myIterator.next());
        assertEquals(6, myIterator.next());
        assertEquals(8, myIterator.next());
        assertThrows(RuntimeException.class, () -> myIterator.next());
    }

    @Test
    @Order(2)
    void Should_return_hasNext_false_on_collection() {
        list = Arrays.asList(1, 3, 99);
        myIterator = new MyIterator(list);
        assertFalse(myIterator.hasNext());
    }

    @Test
    @Order(2)
    void Should_return_hasNext_false_on_empty_collection() {
        list = List.of();
        myIterator = new MyIterator(list);
        assertFalse(myIterator.hasNext());
    }
}