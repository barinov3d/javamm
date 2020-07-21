package ru.commands.javamm.compiler.component.impl.operation;

import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.code.fragment.SourceLine;
import ru.commands.javamm.compiler.component.OperationReader;

import java.util.ListIterator;
import java.util.Optional;

public abstract class AbstractOperationReader<T extends Operation> implements OperationReader {
    @Override
    public boolean canRead(SourceLine sourceLine) {
        final Optional<String> keywordOptional = getOperationKeyword();
        return keywordOptional.isPresent() && keywordOptional.get().equals(sourceLine.getFirst());
    }

    protected Optional<String> getOperationKeyword() {
        return Optional.empty();
    }

    @Override
    public final T read(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        validate(sourceLine);
        return get(sourceLine, iterator);
    }

    protected void validate(SourceLine sourceLine) {
        //do something
    }

    protected abstract T get(SourceLine sourceLine, ListIterator<SourceLine> iterator);
}
