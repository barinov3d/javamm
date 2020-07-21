package ru.commands.javamm.compiler.component.impl;

import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.code.fragment.operations.Block;
import ru.commands.javamm.compiler.component.BlockOperationReader;
import ru.commands.javamm.compiler.component.OperationReader;
import ru.commands.javamm.compiler.component.impl.error.JavammLineSyntaxError;

import java.util.*;

public class BlockOperationReaderImpl implements BlockOperationReader {
    private final Collection<OperationReader> operationReaders;

    public BlockOperationReaderImpl(final Set<OperationReader> operationReaders) {
        this.operationReaders = List.copyOf(operationReaders);
    }

    @Override
    public Block read(SourceLine sourceLine, ListIterator<SourceLine> iterator) {
        final List<Operation> operations = new ArrayList<>();
        readBlockOperations(operations, iterator);
        return new Block(operations, sourceLine);
    }

    private void readBlockOperations(final List<Operation> operations, final ListIterator<SourceLine> iterator) {
        while (iterator.hasNext()) {
            final SourceLine sourceLine = iterator.next();
            final Optional<OperationReader> optionalOperationReader = findOperationReader(sourceLine);
            if (optionalOperationReader.isPresent()) {
                operations.add(optionalOperationReader.get().read(sourceLine, iterator));
            } else {
                //FIXME Replace by expression resolver
                throw new JavammLineSyntaxError("Unsupported operation: " + sourceLine.getCommand(), sourceLine);
            }
        }
    }

    private Optional<OperationReader> findOperationReader(final SourceLine sourceLine) {
        return operationReaders.stream().filter(o -> o.canRead(sourceLine)).findFirst();
    }
}
