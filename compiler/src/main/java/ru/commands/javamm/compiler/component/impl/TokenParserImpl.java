package ru.commands.javamm.compiler.component.impl;

import ru.commands.javamm.compiler.component.TokenParser;
import ru.commands.javamm.compiler.model.TokenParserResult;

import java.util.List;

public class TokenParserImpl implements TokenParser {
    @Override
    public TokenParserResult parseLine(String line, boolean multiLineCommentStarted) {
        final List<String> tokens = line.isEmpty() ? List.of() : List.of(line.trim().split(" "));
        return new TokenParserResult(tokens, multiLineCommentStarted);
    }
}
