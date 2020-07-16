package ru.commands.javamm.code.fragment.exceptions;

import java.util.Objects;

public class JavammError extends RuntimeException {
    protected JavammError(final String message) {
        super(Objects.requireNonNull(message), null, false, false);
    }
}
