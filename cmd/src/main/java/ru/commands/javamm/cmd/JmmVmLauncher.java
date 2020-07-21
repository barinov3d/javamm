package ru.commands.javamm.cmd;

import ru.commands.javamm.code.fragment.ByteCode;
import ru.commands.javamm.compiler.Compiler;
import ru.commands.javamm.compiler.CompilerConfiguration;
import ru.commands.javamm.interpreter.Interpreter;
import ru.commands.javamm.interpreter.JavammRuntimeError;
import ru.commands.javamm.interpreter.component.InterpreterConfigurator;

import java.io.IOException;

public final class JmmVmLauncher {

    private JmmVmLauncher() {
    }

    public static void main(String[] args) throws JavammRuntimeError, IOException {
        final Compiler compiler = new CompilerConfiguration().getCompiler();
        final Interpreter interpreter = new InterpreterConfigurator().getInterpreter();
        final ByteCode byteCode = compiler.compile(new FileSourceCode("C://file.txt"));
        //System.out.println(byteCode.getCode());
        interpreter.interpret(byteCode);
    }
}
