package ru.commands.javamm.code.fragment.operation;

import static java.util.Objects.requireNonNull;
import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.code.fragment.SourceLine;

/**
 * @author Dmitry Barinov
 */
public abstract class AbstractOperation implements Operation {
    private final SourceLine sourceLine;

    protected AbstractOperation(final SourceLine sourceLine) {
        this.sourceLine = requireNonNull(sourceLine);
    }

    @Override
    public SourceLine getSourceLine() {
        return sourceLine;
    }

    @Override
    public String toString() {
        return sourceLine.toString();
    }
}
