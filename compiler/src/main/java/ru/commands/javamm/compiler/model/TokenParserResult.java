package ru.commands.javamm.compiler.model;

import java.util.List;

public class TokenParserResult {
    private final List<String> tokens;

    private final boolean multilineCommentStarted;

    public TokenParserResult(final List<String> tokens, final boolean multilineCommentStarted) {
        this.tokens = List.copyOf(tokens);
        this.multilineCommentStarted = multilineCommentStarted;
    }

    public TokenParserResult(final boolean multilineCommentStarted) {
        this(List.of(), multilineCommentStarted);
    }

    public List<String> getTokens() {
        return tokens;
    }

    public boolean isNotEmpty() {
        return !tokens.isEmpty();
    }

    public boolean isMultilineCommentStarted() {
        return multilineCommentStarted;
    }

}
