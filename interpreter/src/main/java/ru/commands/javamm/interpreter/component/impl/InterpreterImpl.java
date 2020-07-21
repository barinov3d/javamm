package ru.commands.javamm.interpreter.component.impl;

import ru.commands.javamm.code.fragment.ByteCode;
import ru.commands.javamm.interpreter.Interpreter;
import ru.commands.javamm.interpreter.JavammRuntimeError;
import ru.commands.javamm.interpreter.TerminateInterpreterException;
import ru.commands.javamm.interpreter.component.BlockOperationInterpreter;

import static java.util.Objects.requireNonNull;

public class InterpreterImpl implements Interpreter {

    private final BlockOperationInterpreter blockOperationInterpreter;

    public InterpreterImpl(final BlockOperationInterpreter blockOperationInterpreter) {
        this.blockOperationInterpreter = requireNonNull(blockOperationInterpreter);
    }

    @Override
    public void interpret(final ByteCode byteCode) throws JavammRuntimeError, TerminateInterpreterException {
        blockOperationInterpreter.interpret(byteCode.getCode());
    }
}