package ru.commands.javamm.code.fragment;

import java.util.List;

/**
 * @author Dmitry Barinov
 */
public interface SourceCode {
    String getModuleName();
    List<String> getLines();
}
