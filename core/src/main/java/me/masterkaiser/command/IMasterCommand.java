package me.masterkaiser.command;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public interface IMasterCommand<Sender> {
    @NotNull CommandMeta commandMeta();
    boolean onCommand(@NotNull Sender sender, @NotNull String[] args);
    default @NotNull List<String> onTabComplete(@NotNull Sender sender, @NotNull String[] args) {
        return new ArrayList<>();
    }
}
