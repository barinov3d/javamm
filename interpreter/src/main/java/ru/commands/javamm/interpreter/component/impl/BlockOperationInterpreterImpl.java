package ru.commands.javamm.interpreter.component.impl;

import ru.commands.javamm.code.fragment.Operation;
import ru.commands.javamm.code.fragment.exceptions.ConfigException;
import ru.commands.javamm.code.fragment.operations.Block;
import ru.commands.javamm.interpreter.component.BlockOperationInterpreter;
import ru.commands.javamm.interpreter.component.OperationInterpreter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

import static java.lang.String.format;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static java.util.function.Function.identity;

public final class BlockOperationInterpreterImpl implements BlockOperationInterpreter {

    private final Map<Class<? extends Operation>, OperationInterpreter> operationInterpreterMap;

    public BlockOperationInterpreterImpl(final Set<OperationInterpreter<?>> operationInterpreters) {
        this.operationInterpreterMap = buildOperationInterpreterMap(operationInterpreters);
    }

    //Functional
    private Map<Class<? extends Operation>, OperationInterpreter> buildOperationInterpreterMap(
            final Collection<OperationInterpreter<?>> operationInterpreters) {
        return operationInterpreters.stream()
                .collect(toUnmodifiableMap(OperationInterpreter::getOperationClass, identity(), checkDuplicates()));
    }

    //Functional
    private BinaryOperator<OperationInterpreter> checkDuplicates() {
        return (oi1, oi2) -> {
            throw new ConfigException(format(
                    "Duplicate of OperationInterpreter found: operation=%s, interpreter1=%s, interpreter2=%s",
                    oi1.getOperationClass().getName(), oi1, oi2));
        };
    }

    /*
    //Imperative
    private Map<Class<? extends Operation>, OperationInterpreter> buildOperationInterpreterMap(
            final Collection<OperationInterpreter<?>> operationInterpreters) {
        final Map<Class<? extends Operation>, OperationInterpreter> map = new HashMap<>();
        for (final OperationInterpreter operationInterpreter : operationInterpreters) {
            final OperationInterpreter prev = map.put(operationInterpreter.getOperationClass(), operationInterpreter);
            if (prev != null) {
                throw new ConfigException(format(
                    "Duplicate of OperationInterpreter found: operation=%s, interpreter1=%s, interpreter2=%s",
                    prev.getOperationClass().getName(), prev, operationInterpreter));
            }
        }
        return Map.copyOf(map);
    }
    */

    //Imperative
    @Override
    @SuppressWarnings("unchecked")
    public void interpret(final Block block) {
        for (final Operation operation : block.getOperations()) {
            final OperationInterpreter operationInterpreter = operationInterpreterMap.get(operation.getClass());
            if (operationInterpreter != null) {
                operationInterpreter.interpret(operation);
            } else {
                throw new ConfigException("OperationInterpreter not defined for " + operation.getClass());
            }
        }
    }

    /*
    //Functional
    @SuppressWarnings("unchecked")
    public void interpret(final Block block) {
        block.getOperations().forEach(operation ->
            ofNullable(operationInterpreterMap.get(operation.getClass()))
                .ifPresentOrElse(operationInterpreter -> {
                    operationInterpreter.interpret(operation);
                }, () -> {
                    throw new ConfigException("OperationInterpreter not defined for " + operation.getClass());
                }));
    }
    */
}
