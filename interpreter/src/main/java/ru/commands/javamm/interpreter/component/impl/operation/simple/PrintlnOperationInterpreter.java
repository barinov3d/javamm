package ru.commands.javamm.interpreter.component.impl.operation.simple;

import ru.commands.javamm.code.fragment.operations.PrintlnOperation;
import ru.commands.javamm.interpreter.component.impl.operation.AbstractOperationInterpreter;

public final class PrintlnOperationInterpreter extends AbstractOperationInterpreter<PrintlnOperation> {

    @Override
    public Class<PrintlnOperation> getOperationClass() {
        return PrintlnOperation.class;
    }

    @Override
    protected void interpretOperation(final PrintlnOperation operation) {
        System.out.println(operation.getText());
    }
}