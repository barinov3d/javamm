package ru.commands.javamm.code.fragment;

import ru.commands.javamm.code.fragment.operation.Block;

/**
 * @author Dmitry Barinov
 */
public interface ByteCode {
    /**
     *
     * @return block of code to execute
     */
    Block getCode();
}
