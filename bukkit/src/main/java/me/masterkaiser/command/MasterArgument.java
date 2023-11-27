package me.masterkaiser.command;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface MasterArgument extends IArgument<CommandSender> {
    @Override
    default void executeArgument(@NotNull CommandSender commandSender, @NotNull String[] args, Runnable noPermission) {
        if (argumentMeta().getPermission() != null && !argumentMeta().getPermission().isEmpty() && !commandSender.hasPermission(argumentMeta().getPermission())) {
            noPermission.run();
            return;
        }

        onArgument(commandSender, args);
    }
}
