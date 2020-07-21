package ru.commands.javamm.compiler.component.impl;

import ru.commands.javamm.code.fragment.ByteCode;
import ru.commands.javamm.code.fragment.SourceCode;
import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.code.fragment.operations.Block;
import ru.commands.javamm.compiler.Compiler;
import ru.commands.javamm.compiler.JavammSyntaxError;
import ru.commands.javamm.compiler.component.BlockOperationReader;
import ru.commands.javamm.compiler.component.SourceLineReader;

import java.util.List;

public class CompilerImpl implements Compiler {

    private final SourceLineReader sourceLineReader;
    private final BlockOperationReader blockOperationReader;

    public CompilerImpl(final SourceLineReader sourceLineReader, final BlockOperationReader blockOperationReader) {
        this.sourceLineReader = sourceLineReader;
        this.blockOperationReader = blockOperationReader;
    }

    @Override
    public ByteCode compile(SourceCode... sourceCode) throws JavammSyntaxError {
        final List<SourceLine> sourceLines = sourceLineReader.read(sourceCode[0]);
        final Block block = blockOperationReader.read(SourceLine.EMPTY_SOURCE_LINE, sourceLines.listIterator());
        return () -> block;
    }
}
