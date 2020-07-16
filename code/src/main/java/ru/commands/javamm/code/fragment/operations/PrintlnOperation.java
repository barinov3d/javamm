package ru.commands.javamm.code.fragment.operations;

import static java.util.Objects.requireNonNull;

import ru.commands.javamm.code.fragment.SourceLine;

/**
 * @author Dmitry Barinov
 */
public class PrintlnOperation extends AbstractOperation {

    private final String text;

    public PrintlnOperation(final SourceLine sourceLine, final String text) {
        super(sourceLine);
        this.text = requireNonNull(text);
    }

    public String getText() {
        return text;
    }
}
