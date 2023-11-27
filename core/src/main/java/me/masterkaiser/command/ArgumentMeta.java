package me.masterkaiser.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArgumentMeta {
    private @NotNull String name;
    private String usage;
    private String description;
    private String permission;
    private String[] aliases;

    public ArgumentMeta(@NotNull String name) {
        this.name = name;
    }

    public ArgumentMeta setName(@NotNull String name) {
        this.name = name;
        return this;
    }

    public ArgumentMeta setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    public ArgumentMeta setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArgumentMeta setPermission(String permission) {
        this.permission = permission;
        return this;
    }

    public ArgumentMeta setAliases(String[] aliases) {
        this.aliases = aliases;
        return this;
    }

    public List<String> getNotNullAliases() {
        return (getAliases() == null ? new ArrayList<>() : List.of(getAliases()));
    }

    public List<String> getAliasesAndName() {
        final List<String> result = new ArrayList<>();
        result.add(name);
        result.addAll(getNotNullAliases());

        return result;
    }

    public String getPermission() {
        if (permission == null) return "";
        return permission;
    }
}
