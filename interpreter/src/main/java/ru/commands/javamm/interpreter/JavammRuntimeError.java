package ru.commands.javamm.interpreter;

public abstract class JavammRuntimeError extends Exception {
    protected JavammRuntimeError(final String message) {
        super(message);
    }
}
