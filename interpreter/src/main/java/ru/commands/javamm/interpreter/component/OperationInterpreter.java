package ru.commands.javamm.interpreter.component;

import ru.commands.javamm.code.fragment.Operation;

public interface OperationInterpreter<T extends Operation> {
    Class<T> getOperationClass();

    void interpret(T operation);
}
