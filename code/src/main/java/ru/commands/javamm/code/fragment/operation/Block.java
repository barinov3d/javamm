package ru.commands.javamm.code.fragment.operation;

import java.util.List;
import java.util.stream.Collectors;
import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.code.fragment.SourceLine;

/**
 * @author Dmitry Barinov
 */
public final class Block extends AbstractOperation {

    private final List<Operation> operations;

    public Block(final List<Operation> operations, final SourceLine sourceLine) {
        super(sourceLine);
        this.operations = List.copyOf(operations);
    }

    public Block(final Operation operation, final SourceLine sourceLine) {
        this(List.of(operation), sourceLine);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        /*
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Operation operation : operations) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(System.lineSeparator());
            }
            stringBuilder.append(operation.toString());
        }
        return stringBuilder.toString();
        */
        return operations.stream()
            .map(Object::toString)
            .collect(Collectors.joining(System.lineSeparator()));
    }
}