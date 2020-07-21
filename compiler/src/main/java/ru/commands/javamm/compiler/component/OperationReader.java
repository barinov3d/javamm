package ru.commands.javamm.compiler.component;

import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.code.fragment.SourceLine;

import java.util.ListIterator;

public interface OperationReader {
    boolean canRead(SourceLine sourceLine);

    Operation read(SourceLine sourceLine, ListIterator<SourceLine> iterator);

}
