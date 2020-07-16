package ru.commands.javamm.compiler;

import ru.commands.javamm.code.fragment.exceptions.JavammError;

public abstract class JavammSyntaxError extends JavammError {
    protected JavammSyntaxError(String message) {
        super(message);
    }
}
