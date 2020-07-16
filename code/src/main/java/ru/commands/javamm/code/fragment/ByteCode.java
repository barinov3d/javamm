package ru.commands.javamm.code.fragment;

import ru.commands.javamm.code.fragment.operations.Block;

/**
 * @author Dmitry Barinov
 */
public interface ByteCode {
    /**
     * @return block of code to execute
     */
    Block getCode();
}
