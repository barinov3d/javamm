package ru.commands.javamm.code.fragment.operation;

import static java.util.Objects.requireNonNull;
import lombok.Getter;
import ru.commands.javamm.code.fragment.SourceLine;

/**
 * @author Dmitry Barinov
 */
@Getter
public class PrintlnOperation extends AbstractOperation {

    private final String text;

    public PrintlnOperation(final SourceLine sourceLine, final String text) {
        super(sourceLine);
        this.text = requireNonNull(text);
    }
}
