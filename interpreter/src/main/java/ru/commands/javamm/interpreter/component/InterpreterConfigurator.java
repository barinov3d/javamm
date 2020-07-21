package ru.commands.javamm.interpreter.component;

import ru.commands.javamm.interpreter.Interpreter;
import ru.commands.javamm.interpreter.component.impl.BlockOperationInterpreterImpl;
import ru.commands.javamm.interpreter.component.impl.InterpreterImpl;
import ru.commands.javamm.interpreter.component.impl.operation.simple.PrintlnOperationInterpreter;

import java.util.Set;

public class InterpreterConfigurator {

    private Set<OperationInterpreter<?>> operationInterpreters = Set.of(
            new PrintlnOperationInterpreter()
    );

    private BlockOperationInterpreter blockOperationInterpreter =
            new BlockOperationInterpreterImpl(operationInterpreters);

    private Interpreter interpreter = new InterpreterImpl(blockOperationInterpreter);

    public Interpreter getInterpreter() {
        return interpreter;
    }
}