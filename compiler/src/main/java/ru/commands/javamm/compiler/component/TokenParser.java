package ru.commands.javamm.compiler.component;

import ru.commands.javamm.compiler.model.TokenParserResult;

public interface TokenParser {
    TokenParserResult parseLine(String line, boolean multiLineCommentStarted);
}
