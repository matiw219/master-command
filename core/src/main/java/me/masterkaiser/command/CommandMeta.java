package me.masterkaiser.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class CommandMeta {
    private String name;
    private String usage;
    private String description;
    private String permission;
    private String[] aliases;
    private Boolean playerOnly;
    private Map<String, ArgumentMeta> arguments = new HashMap<>();
    private Boolean enabled;

    public CommandMeta(String name, String usage, String description, String permission, String[] aliases, Boolean playerOnly, Map<String, ArgumentMeta> arguments) {
        this.name = name;
        this.usage = usage;
        this.description = description;
        this.permission = permission;
        this.aliases = aliases;
        this.playerOnly = playerOnly;
        this.arguments = arguments;
    }

    public CommandMeta(String name) {
        this.name = name;
    }

    public CommandMeta setName(@NotNull String name) {
        this.name = name;
        return this;
    }

    public CommandMeta setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    public CommandMeta setDescription(String description) {
        this.description = description;
        return this;
    }

    public CommandMeta setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public CommandMeta setAliases(String[] aliases) {
        this.aliases = aliases;
        return this;
    }

    public CommandMeta setPlayerOnly(boolean playerOnly) {
        this.playerOnly = playerOnly;
        return this;
    }

    public CommandMeta setArguments(Map<String, ArgumentMeta> arguments) {
        this.arguments = arguments;
        return this;
    }

    public CommandMeta setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public @NotNull ArgumentMeta getArgument(@NotNull String key) {
        if (this.arguments == null) {
            throw new NullPointerException("Cannot find " + key + " argument in command " + getName());
        }

        return this.arguments.get(key);
    }

    public String getPermission() {
        if (permission == null) return "";
        return permission;
    }
}
