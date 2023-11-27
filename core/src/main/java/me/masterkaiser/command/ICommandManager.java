package me.masterkaiser.command;

import org.jetbrains.annotations.NotNull;

public interface ICommandManager<Command> {
    void registerCommand(@NotNull Command command);
}
