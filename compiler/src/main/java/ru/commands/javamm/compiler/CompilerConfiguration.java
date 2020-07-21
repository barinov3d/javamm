package ru.commands.javamm.compiler;

import ru.commands.javamm.compiler.component.BlockOperationReader;
import ru.commands.javamm.compiler.component.OperationReader;
import ru.commands.javamm.compiler.component.SourceLineReader;
import ru.commands.javamm.compiler.component.TokenParser;
import ru.commands.javamm.compiler.component.impl.BlockOperationReaderImpl;
import ru.commands.javamm.compiler.component.impl.CompilerImpl;
import ru.commands.javamm.compiler.component.impl.SourceLineReaderImpl;
import ru.commands.javamm.compiler.component.impl.TokenParserImpl;
import ru.commands.javamm.compiler.component.impl.operation.simple.PrintlnOperationReader;

import java.util.Set;

public class CompilerConfiguration {
    private TokenParser tokenParser = new TokenParserImpl();

    private SourceLineReader sourceLineReader = new SourceLineReaderImpl(tokenParser);

    private Set<OperationReader> operationReaders = Set.of(
            new PrintlnOperationReader()
    );

    private BlockOperationReader blockOperationReader = new BlockOperationReaderImpl(operationReaders);

    private Compiler compiler = new CompilerImpl(sourceLineReader, blockOperationReader);

    public Compiler getCompiler() {
        return compiler;
    }
}
