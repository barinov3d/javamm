package ru.commands.javamm.compiler.component.impl.operation.simple;

import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.code.fragment.operations.PrintlnOperation;
import ru.commands.javamm.compiler.component.OperationReader;
import ru.commands.javamm.compiler.component.impl.error.JavammLineSyntaxError;
import ru.commands.javamm.compiler.component.impl.operation.AbstractOperationReader;

import java.util.ListIterator;
import java.util.Optional;

public class PrintlnOperationReader extends AbstractOperationReader<PrintlnOperation> implements OperationReader {


    @Override
    protected Optional<String> getOperationKeyword() {
        return Optional.of("println");
    }

    @Override
    protected void validate(final SourceLine sourceLine) {
        if (!")".equals(sourceLine.getLast())) {
            throw new JavammLineSyntaxError("Expected ) at the end of line", sourceLine);
        }
        if (!"(".equals(sourceLine.getToken(1))) {
            throw new JavammLineSyntaxError("Expected ( after 'println'", sourceLine);
        }
    }

    @Override
    protected PrintlnOperation get(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        final String text = sourceLine.getToken(2);
        return new PrintlnOperation(sourceLine, text);
    }
}
