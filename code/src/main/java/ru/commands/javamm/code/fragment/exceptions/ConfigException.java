package ru.commands.javamm.code.fragment.exceptions;

import java.util.Objects;

public class ConfigException extends RuntimeException {
    public ConfigException(String message) {
        super(Objects.requireNonNull(message));
    }

    public ConfigException(String message, Throwable cause) {
        super(Objects.requireNonNull(message), Objects.requireNonNull(cause));
    }
}
