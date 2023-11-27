package me.masterkaiser.command;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public class CommandManager implements ICommandManager<MasterCommand> {
    private CommandMap commandMap;
    private @Getter @Setter String prefix = "master";
    private @Getter @Setter String noPermissionMessage = "&cAccess denied";
    private @Getter @Setter String playerOnlyMessage = "&cCommand only for player`s";

    public CommandManager() {
        try {
            final Field commandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMap.setAccessible(true);
            this.commandMap = (CommandMap) commandMap.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerCommand(@NotNull MasterCommand masterCommand) {
        BukkitCommand bukkitCommand = new BukkitCommand(masterCommand, this);
        this.commandMap.register(this.prefix, bukkitCommand);
    }
}
