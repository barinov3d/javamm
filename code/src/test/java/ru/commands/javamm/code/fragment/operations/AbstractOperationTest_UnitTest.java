package ru.commands.javamm.code.fragment.operations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import ru.commands.javamm.code.fragment.SourceLine;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class AbstractOperationTest_UnitTest {

    @Test
    void SourceLine_toString_should_be_invoked_when_AbstractOperation_toString_executed() {
        SourceLine sourceLine = new SourceLine("Module 11", 1, List.of());
        assertEquals(sourceLine.toString(), new AbstractOperation(sourceLine){}.toString());
    }
}