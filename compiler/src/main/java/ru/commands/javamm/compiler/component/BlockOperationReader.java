package ru.commands.javamm.compiler.component;

import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.code.fragment.operations.Block;

import java.util.ListIterator;

public interface BlockOperationReader {
    Block read(SourceLine sourceLine, ListIterator<SourceLine> iterator);
}
