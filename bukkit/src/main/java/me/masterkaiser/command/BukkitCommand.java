package me.masterkaiser.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BukkitCommand extends org.bukkit.command.defaults.BukkitCommand {
    private final MasterCommand masterCommand;
    private final CommandManager commandManager;

    public BukkitCommand(@NotNull MasterCommand masterCommand, @NotNull CommandManager commandManager) {
        super(
                masterCommand.commandMeta().getName(),
                masterCommand.commandMeta().getDescription(),
                masterCommand.commandMeta().getUsage(),
                Arrays.asList(masterCommand.commandMeta().getAliases()));
        setPermission(masterCommand.commandMeta().getPermission());
        this.masterCommand = masterCommand;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (getPermission() != null && !getPermission().isEmpty() && !sender.hasPermission(getPermission())) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    this.commandManager.getNoPermissionMessage().replace("{permission}", this.getPermission()))
            );
            return false;
        }

        if (sender instanceof ConsoleCommandSender && this.masterCommand.commandMeta().getPlayerOnly() != null
                && this.masterCommand.commandMeta().getPlayerOnly()) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    this.commandManager.getPlayerOnlyMessage()));
            return false;
        }

        return this.masterCommand.onCommand(sender, args);
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return topUpList(this.masterCommand.onTabComplete(sender, args), args[args.length - 1]);
    }

    boolean startsWithIgnoreCase(String searchIn, int startAt, String searchFor) {
        return searchIn.regionMatches(true, startAt, searchFor, 0, searchFor.length());
    }

    List<String> topUpList(List<String> list, String topUp) {
        return list.stream()
                .filter(s -> startsWithIgnoreCase(s, 0, topUp))
                .collect(Collectors.toList());
    }
}
