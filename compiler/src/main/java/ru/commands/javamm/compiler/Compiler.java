package ru.commands.javamm.compiler;

import ru.commands.javamm.code.fragment.ByteCode;
import ru.commands.javamm.code.fragment.SourceCode;

public interface Compiler {
    ByteCode compile(SourceCode... sourceCode) throws JavammSyntaxError;
}
