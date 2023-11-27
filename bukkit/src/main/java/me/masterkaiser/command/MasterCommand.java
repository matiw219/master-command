package me.masterkaiser.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MasterCommand extends IMasterCommand<CommandSender> {
    @Override
    default @NotNull List<String> onTabComplete(@NotNull CommandSender sender, @NotNull String[] args) {
        return playerCompletions();
    }

    static List<String> playerCompletions() {
        return Bukkit.getOnlinePlayers()
                .stream()
                .map(HumanEntity::getName)
                .toList();
    }
}
