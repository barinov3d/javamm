package ru.commands.javamm.interpreter.component.impl.operation;

import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.interpreter.TerminateInterpreterException;
import ru.commands.javamm.interpreter.component.OperationInterpreter;

public abstract class AbstractOperationInterpreter<T extends Operation> implements OperationInterpreter<T> {

    @Override
    public final void interpret(final T operation) {
        checkForTerminate();
        interpretOperation(operation);
    }

    protected final void checkForTerminate() {
        if (Thread.interrupted()) {
            throw new TerminateInterpreterException();
        }
    }

    protected abstract void interpretOperation(T operation);
}
