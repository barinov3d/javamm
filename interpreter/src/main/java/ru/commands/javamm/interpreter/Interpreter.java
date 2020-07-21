package ru.commands.javamm.interpreter;

import ru.commands.javamm.code.fragment.ByteCode;

public interface Interpreter {
    void interpret(ByteCode byteCode) throws JavammRuntimeError, TerminateInterpreterException;
}
