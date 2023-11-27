package me.masterkaiser.command;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public interface IArgument<Sender> {
    @NotNull ArgumentMeta argumentMeta();
    boolean onArgument(@NotNull Sender sender, @NotNull String[] args);
    default void executeArgument(@NotNull Sender sender, @NotNull String[] args, Runnable noPermission) {
        onArgument(sender, args);
    }
    default @NotNull List<String> onTabComplete(@NotNull Sender sender, @NotNull String[] args) {
        return new ArrayList<>();
    }
}
