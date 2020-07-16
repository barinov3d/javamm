package ru.commands.javamm.compiler.component.impl;

import ru.commands.javamm.code.fragment.SourceCode;
import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.compiler.component.SourceLineReader;
import ru.commands.javamm.compiler.component.TokenParser;
import ru.commands.javamm.compiler.model.TokenParserResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class SourceLineReaderImpl implements SourceLineReader {

    private final TokenParser tokenParser;

    public SourceLineReaderImpl(final TokenParser tokenParser) {
        this.tokenParser = requireNonNull(tokenParser);
    }

    @Override
    public final List<SourceLine> read(final SourceCode sourceCode) {
        final List<SourceLine> lines = new ArrayList<>();
        int number = 1;
        boolean isMultilineCommentStarted = false;
        for (final String line : sourceCode.getLines()) {
            final TokenParserResult tokenParserResult = tokenParser.parseLine(line, isMultilineCommentStarted);
            isMultilineCommentStarted = tokenParserResult.isMultilineCommentStarted();
            if (tokenParserResult.isNotEmpty()) {
                lines.add(new SourceLine(sourceCode.getModuleName(), number, tokenParserResult.getTokens()));
            }
            number++;
        }
        return Collections.unmodifiableList(lines);
    }
}
