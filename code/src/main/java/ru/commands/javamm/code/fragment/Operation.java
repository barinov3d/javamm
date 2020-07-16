package ru.commands.javamm.code.fragment;

/**
 * @author Dmitry Barinov
 * <p>
 * Minimal possible set of commands which can be executed by interpreter
 */
public interface Operation extends CompiledCodeFragment {
    SourceLine getSourceLine();
}
