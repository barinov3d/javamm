package ru.commands.javamm.compiler.component.impl.error;

import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.compiler.JavammSyntaxError;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class JavammLineSyntaxError extends JavammSyntaxError {

    public JavammLineSyntaxError(final String message,
                                 final SourceLine sourceLine) {
        super(format("Syntax error in '%s' [Line: %s]: %s",
                sourceLine.getModuleName(), sourceLine.getNumber(), requireNonNull(message)));
    }
}
