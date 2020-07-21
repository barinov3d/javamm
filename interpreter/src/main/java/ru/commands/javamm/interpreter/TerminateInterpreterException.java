package ru.commands.javamm.interpreter;

public class TerminateInterpreterException extends RuntimeException {
    public TerminateInterpreterException() {
        super(null, null, true, false);
    }
}
