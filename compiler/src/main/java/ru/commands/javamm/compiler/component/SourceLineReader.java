package ru.commands.javamm.compiler.component;

import ru.commands.javamm.code.fragment.SourceCode;
import ru.commands.javamm.code.fragment.SourceLine;

import java.util.List;

public interface SourceLineReader {
    List<SourceLine> read(SourceCode sourceCode);
}
